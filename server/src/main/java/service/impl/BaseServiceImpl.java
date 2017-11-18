package service.impl;

import com.alibaba.fastjson.JSON;

import exception.BussinessException;
import org.springframework.stereotype.Service;
import service.IBaseService;
import util.ServiceRequest;
import util.ServiceResponse;
import util.SpringContextUtil;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by bll on 2017/9/2.
 */
public class BaseServiceImpl implements IBaseService {
    public ServiceResponse service(ServiceRequest serviceRequest) throws BussinessException {
        new ServiceResponse();
        try {
            return this.invokeMethodByMethodName(this.getClass(), serviceRequest);
        } catch (Exception e) {
            throw new BussinessException("调用方法出现异常", e);
        }
    }

    private ServiceResponse invokeMethodByMethodName(Class<?> classType, ServiceRequest request) throws IllegalAccessException, InvocationTargetException {
        String methodName = request.getMethod();
        String beanName = (classType.getAnnotation(Service.class)).value();
        Object instance = SpringContextUtil.getBean(beanName);
        Method[] methods = classType.getDeclaredMethods();
        ServiceResponse serviceResponse = null;
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                method.setAccessible(true);
                Class[] parameterTypes = method.getParameterTypes();
                Object[] arguments = getObjectArray(parameterTypes, request);
                if (arguments.length != 0) {
                    serviceResponse = (ServiceResponse) method.invoke(instance, arguments);
                } else {
                    serviceResponse = (ServiceResponse) method.invoke(instance);
                }

            }
        }
        return serviceResponse;
    }

    private Object[] getObjectArray(Class[] parameterTypes, ServiceRequest request) {
        List<Object> list = new ArrayList<Object>();
        HttpServletRequest servletRequest = request.getRequest();
        Map<String, Object> params = (Map) JSON.parse(servletRequest.getParameter("data"));
        switch (parameterTypes.length) {
            case 0:
                break;
            case 1:
                if (parameterTypes[0].isAssignableFrom(HttpServletRequest.class)) {
                    list.add(servletRequest);
                } else {
                    list.add(params);
                }
                break;
            case 2:
                list.add(servletRequest);
                list.add(params);
        }
        return list.toArray();
    }
}

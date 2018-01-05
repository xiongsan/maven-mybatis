package util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware{
    private static ApplicationContext context;

    public static Object getBean(String beanName) {
        try {
            return context.getBean(beanName);
        } catch (NoSuchBeanDefinitionException var2) {
            throw new FableException("JDF00402~bean不存在", var2);
        }
    }

    public static <T> T getBean(String beanName,Class<T> clazz) {
        try {
            return context.getBean(beanName,clazz);
        } catch (NoSuchBeanDefinitionException var3) {
            throw new FableException("JDF00402~bean不存在", var3);
        }
    }

    public static <T> T getBean(Class<T> clazz) {
        try {
            return context.getBean(clazz);
        } catch (NoSuchBeanDefinitionException var3) {
            throw new FableException("JDF00402~bean不存在", var3);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context=applicationContext;
    }
}
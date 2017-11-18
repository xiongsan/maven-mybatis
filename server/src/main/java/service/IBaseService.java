package service;


import exception.BussinessException;
import util.ServiceRequest;
import util.ServiceResponse;

/**
 * Created by bll on 2017/9/2.
 */
public interface IBaseService {
    ServiceResponse service(ServiceRequest serviceRequest) throws BussinessException;
}

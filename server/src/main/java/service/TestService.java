package service;

import org.springframework.stereotype.Service;
import service.impl.BaseServiceImpl;
import util.ResultKit;
import util.ServiceResponse;

/**
 * Created by Wanghairui on 2017/5/24.
 */
@Service("test")
public class TestService extends BaseServiceImpl{

    public ServiceResponse getData(){
        return ResultKit.serviceResponse("success");
    }
}

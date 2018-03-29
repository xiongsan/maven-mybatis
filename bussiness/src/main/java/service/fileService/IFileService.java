package service.fileService;

import com.fable.enclosure.bussiness.entity.ServiceRequest;
import com.fable.enclosure.bussiness.entity.ServiceResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :Hairui
 * Date :2018/1/23
 * Time :11:10
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
public interface IFileService {

    String getFileFolder(HttpServletRequest request);

    ServiceResponse deleteFile(ServiceRequest<Map<String,String>> param);
    
    ServiceResponse getFileList(ServiceRequest<Map<String,String>> param);
    
    ServiceResponse addFile(ServiceRequest<Map<String,Object>> param);

    ServiceResponse showPic();

}

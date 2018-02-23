package service.fileService;

import com.fable.enclosure.bussiness.entity.ServiceResponse;

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

    String getFileFolder();

    ServiceResponse deleteFile(Map<String,Object> param);
    
    ServiceResponse getFileList(Map<String,Object> param);
    
    ServiceResponse addFile(Map<String,Object> param);

}

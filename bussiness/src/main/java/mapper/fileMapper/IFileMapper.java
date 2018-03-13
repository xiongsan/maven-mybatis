package mapper.fileMapper;

import com.fable.enclosure.bussiness.entity.ServiceResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.xml.ws.Service;
import java.util.List;
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
 * Date :2018/2/23
 * Time :14:12
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
@Repository
public interface IFileMapper {
    List<Map<String,Object>> getFileList();

    boolean addFile(Map<String,Object> param);

    boolean deleteFile(Map<String,String> param);
}

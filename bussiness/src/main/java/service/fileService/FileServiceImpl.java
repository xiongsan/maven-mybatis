package service.fileService;

import com.fable.enclosure.bussiness.entity.ResultKit;
import com.fable.enclosure.bussiness.entity.ServiceRequest;
import com.fable.enclosure.bussiness.entity.ServiceResponse;
import com.fable.enclosure.bussiness.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.io.File;
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
 * Time :11:12
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏飞博软件股份有限公司 </p>
 */
@Service("fileService")
public class FileServiceImpl extends BaseServiceImpl implements IFileService{

    /**
     * 文件存放位置，根据项目需要
     * @return 文件父级文件夹
     */
    @Override
    public String getFileFolder() {
        String url = System.getProperty("user.dir");
        return url.substring(0, url.lastIndexOf(File.separator)) +
                File.separator +
                "user" +
                File.separator +
                "uploadFile";
    }

    /**
     * 删除文件，根据项目需要，操作进行数据库操作
     * @param param
     * @return
     */
    @Override
    public ServiceResponse deleteFile(Map<String, Object> param) {
            File file = new File(getFileFolder(), param.get("fileUrl").toString());
            if (file.exists()) {
                if (file.delete())
                    return ResultKit.success();
                return ResultKit.fail("删除文件失败");
            }
            return ResultKit.fail("文件不存在");

    }
}

package service.imp;

import com.fable.enclosure.bussiness.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import service.IFileService;

import java.io.File;

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

    @Override
    public String getFileFolder() {
        String url = System.getProperty("user.dir");
        return url.substring(0, url.lastIndexOf(File.separator)) +
                File.separator +
                "user" +
                File.separator +
                "uploadFile";
    }
}

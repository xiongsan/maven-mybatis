package service.fileService;

import com.fable.enclosure.bussiness.entity.PageRequest;
import com.fable.enclosure.bussiness.interfaces.BaseRequest;
import com.fable.enclosure.bussiness.interfaces.BaseResponse;
import com.fable.enclosure.bussiness.service.impl.BaseServiceImpl;
import com.fable.enclosure.bussiness.util.ResultKit;
import com.fable.enclosure.bussiness.util.Tool;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import mapper.fileMapper.IFileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
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
@Service
public class FileServiceImpl extends BaseServiceImpl implements IFileService{

    final private String ideaContainer = File.separator+"target";
    final private String normalContainer = File.separator+"webapps";

    
    @Autowired
    IFileMapper mapper;
    /**
     * 文件存放位置，根据项目需要
     * @return 文件父级文件夹
     */
    @Override
    public String getFileFolder(HttpServletRequest request) {
        String uploadPath =request.getServletContext().getRealPath(
                File.separator);
        if(uploadPath.contains(normalContainer)){
            uploadPath = uploadPath.substring(0, uploadPath.indexOf(normalContainer));
        }
        else{
            uploadPath = uploadPath.substring(0, uploadPath.indexOf(ideaContainer));
        }
        uploadPath = uploadPath.substring(0, uploadPath.lastIndexOf(File.separator));
        return uploadPath+File.separator+"uploadFile";
    }

    /**
     * 删除文件，根据项目需要，操作进行数据库操作
     * @param param
     * @return     */
    @Override
    public BaseResponse deleteFile(Map<String,String> param) {
                    mapper.deleteFile(param);
                    return ResultKit.success();
    }

    @Override
    public BaseResponse getFileList(PageRequest<Map<String,String>> param) {
        Page<Map<String,Object>> result = PageHelper.startPage(param.getPageNo(),param.getPageSize());
        mapper.getFileList(param.getParam());
        return ResultKit.wrap(result);
    }

    @Override
    public BaseResponse addFile(Map<String,Object> param) {
        param.put("id", Tool.newGuid());
        param.put("createTime", new Date());
        return ResultKit.serviceResponse(mapper.addFile(param));
    }

    @Override
    public BaseResponse showPic() {
        return ResultKit.serviceResponse(mapper.showPic());
    }


}

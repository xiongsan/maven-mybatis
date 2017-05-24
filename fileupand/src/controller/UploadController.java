package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class UploadController {
     //此方法我没有成功实现
	
	@RequestMapping("/upload")
	public void upload(@RequestParam("file") CommonsMultipartFile file,HttpSession session) throws IllegalStateException, IOException{
		String uploadDir = System.getProperty("user.home") + File.separator + "myDocument";
		File myfile = new File(uploadDir);
		if (!myfile.exists()){
			myfile.mkdirs();
		}

		file.transferTo(new File(uploadDir,file.getOriginalFilename()));
	}

}

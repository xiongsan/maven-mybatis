package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DownController {
@RequestMapping("/download")
public void downSomething(HttpSession session,HttpServletResponse resp) throws Exception
{
	 resp.setHeader("content-disposition", new String("attachment;filename=第三版中文版.pdf".getBytes("utf-8"),"iso8859-1"));
     ServletContext application=session.getServletContext();
     FileInputStream in=null;
     OutputStream out=null;
     try{
     in=new FileInputStream(application.getRealPath("file/SPRING in action(第三版中文版).pdf"));
     out=resp.getOutputStream();
     int n;
     byte[] b=new byte[1024];
     while((n=in.read(b))!=-1)
     {
    	 out.write(b, 0, n);
     }
     }
     catch(Exception e)
     {
    	 e.printStackTrace();
     }
     finally
     {
    	 if(in!=null)
    	 {
    		 in.close();
    	 }
    	 if(out!=null)
    	 {
    		 in.close();
    	 }
     }
}
    @RequestMapping("/download2")
    public ResponseEntity<byte[]> download2() throws Exception{
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "bpmn20.xml");

        File file=new ClassPathResource("bpmn20.xml").getFile();
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }

}

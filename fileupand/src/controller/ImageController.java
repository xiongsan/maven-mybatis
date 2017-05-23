package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@Controller
public class ImageController {
    @RequestMapping("/getImage")
	public void getImage(OutputStream out,HttpSession session) throws ImageFormatException, IOException
	{
		Random random = new Random();
		//获得画板
		BufferedImage image=new BufferedImage(75,35,BufferedImage.TYPE_INT_RGB);
		//获得画笔
		Graphics graphics=image.getGraphics();
		//设置背景颜色
		graphics.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
		//设置填充形状
		graphics.fillRect(0, 0, 75, 35);
		//设置画笔颜色
		graphics.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
		//设置字体
		graphics.setFont(new Font("Courier New",Font.BOLD+Font.ITALIC,18));
		//随机生成字体
		String s="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<5;i++)
		{
			sb.append(s.charAt(random.nextInt(s.length())));
		}
		//将随机生成的验证码存入session一遍验证时候用
		session.setAttribute("code", sb.toString());
		//将随机出来的字体写入图片
		graphics.drawString(sb.toString(), 5, 20);
		//将图片压缩成JEPG格式输出
		JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(out);
		encoder.encode(image);
	}
    
    
    //验证用户名秘法是否正确
    @RequestMapping(value="/validateCode",produces="text/plain;charset=utf-8")
	public @ResponseBody String validateCode(String code,HttpSession session){
		String sessionCode=(String) session.getAttribute("code");
		if(sessionCode!=null&&sessionCode.equalsIgnoreCase(code)){
			return "验证码正确";
		}else{
			return "验证码错误";
		}
	}
}

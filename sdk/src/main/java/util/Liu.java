package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * <p>
 * Title :
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Author :王海瑞 2017/3/6
 * </p>
 * <p>
 * Department :
 * </p>
 * <p> Copyright : 江苏汇鑫融智软件科技有限公司 </p>
 */
public class Liu{
    public void change2Image(String path, String savePath) throws Exception
    {
        File file = new File(path);
        if (!file.exists())
        {
            System.out.println("文件不存在！");
            return ;
        }
        // 复制到的路径如不存在就创建
        File saveFile = new File(savePath);
        if (!saveFile.exists())
        {
            saveFile.mkdirs();
        }
        // 新文件全路径
        String savePathNew = "";
        for (File fbean : file.listFiles())
        {
            if (fbean.isFile())
            {
                System.out.println(fbean.getName() + "\t" + fbean.getAbsolutePath());
//    savePathNew = savePath + File.separator + fbean.getName()+ ".jpg";
                // 把文件名称中含有.tbi格式的转化为.jpg格式
                savePathNew = savePath + File.separator + (fbean.getName().replaceAll(".tbi", ".jpg"));
                // 开始复制
                copy(fbean ,new File(savePathNew));
            }
        }
    }


    private static void copy(File fromFile, File toFile) throws Exception{
        if (!fromFile.exists())
        {
            System.out.println("来源文件为空！");
        }
        if (!toFile.exists())
        {
            System.out.println("创建新文件。。");
            toFile.createNewFile();
        }
        FileInputStream fis = new FileInputStream(fromFile);
        System.out.println("fromFile :" + fromFile.getAbsolutePath());
        FileOutputStream fos = new FileOutputStream(toFile);
        System.out.println("toFile :" + toFile.getAbsolutePath());

        int len = 0;
        byte[] buf = new byte[1024];
        while((len = fis.read(buf)) != -1){
            fos.write(buf,0,len);
        }

        fis.close();
        fos.close();
    }


    public static void main(String[] args)
    {
        String path = "E:\\FileRecv\\数据包";
        String savePath = "E:\\FileRecv\\数据包2";
        Liu change2Image = new Liu();
        try
        {
            change2Image.change2Image(path, savePath);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}

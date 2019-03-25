package aboutSocket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ServerTest implements Runnable

{

    private HashMap<Socket,Socket> hm=new HashMap<Socket,Socket>();

    private ExecutorService service = Executors.newCachedThreadPool();

    private ServerSocket ss = null;

    private static int onlineCount=0;

    public ServerTest()
    {
        try
        {
            ss = new ServerSocket(10008);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        service.execute(this);
    }



    public static void main(String[] args)
    {
        new ServerTest();
    }


    @Override
    public void run() {
        try{
            while(true){
                final Socket s = ss.accept();// 阻塞式方法
                final InetAddress address = s.getInetAddress();
                hm.put(s, s);//本机通过不同端口，不同机器通过不同ip
                InputStream is = s.getInputStream();
                final BufferedReader br = new BufferedReader(new InputStreamReader(is));
                service.execute(()->accept(br,s,address));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void accept(BufferedReader br,final Socket s,final InetAddress address){
        addOnlineCount();
        System.out.println("client has connected ,count:"+getOnlineCount());
        try{
            while(!s.isOutputShutdown()){
                String line = br.readLine();
                Iterator<Socket> iterator= hm.keySet().iterator();
                while (iterator.hasNext()){
                    Socket socket= hm.get(iterator.next());
                    if(socket!=s){
                        OutputStream os= socket.getOutputStream();
                        PrintWriter pw=new PrintWriter(os,true);
                        pw.println(address+"："+line);
                    }
                }
            }
            subOnlineCount();
            System.out.println("client has disconnected ,count:"+getOnlineCount());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        onlineCount--;
    }
}



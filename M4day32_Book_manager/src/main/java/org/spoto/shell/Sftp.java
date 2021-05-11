package org.spoto.shell;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import io.netty.util.internal.StringUtil;
import org.spoto.utils.StringUtils;

import java.io.FileInputStream;
import java.io.OutputStream;

public class Sftp {

    public static void main(String[] args) throws Exception{
        String dir=args[0];
       Sftp.sshSftp("192.111.26.76","wasadmin","Was_123..",22,dir);
    }

    public static void sshSftp(String ip,String user,String psw,int port,String dir) throws Exception{
        Session session=null;
        JSch jSch = new JSch();
        if (port <=0){
             session = jSch.getSession(user,ip);
        }else {
            session = jSch.getSession(user,ip,port);
        }
        //不是String类型，用不了StringUtil工具类
        if (session==null){
             throw new Exception("session is null");
        }

        session.setPassword(psw);
        session.setConfig("StrictHostKeyChecking","no");

        session.connect(3000);
        sftp_put(session,"web.war",dir);
        System.out.println("sftp success");
    }

    public static void sftp_put(Session session,String uploadFileName, String dir) throws Exception{
        Channel channel=null;
        try {
            channel = session.openChannel("sftp");
            channel.connect(1000);

            ChannelSftp sftp = (ChannelSftp)channel;
            sftp.cd("/opt/shell_script/temp");
            OutputStream outstream = sftp.put(uploadFileName);

            FileInputStream is = new FileInputStream(dir);

            byte [] b=new byte[1024];
            int n;
            while ((n=is.read(b))!=-1){
                outstream.write(b,0,n);
            }

           outstream.flush();
           outstream.close();
           is.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.disconnect();
            channel.disconnect();
        }

    }

}

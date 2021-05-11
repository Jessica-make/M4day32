package org.spoto.shell;

import com.jcraft.jsch.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class Shell {

    public static void main(String[] args) throws Exception{
        String user="wasadmin";
        String passwd="Was_123..";
        String host="192.111.26.76";
        Shell demo = new Shell(user, passwd, host);
        demo.connect();
        demo.execCmd();
    }
    private  String charset="UTF-8";

    private String user;

    private String passwd;

    private String host;

    private JSch jsch;

    private Session session;

    public Shell(String user,String passwd,String host){
        this.user=user;
        this.passwd=passwd;
        this.host=host;
    }


    public void connect() throws JSchException{
        JSch jsch = new JSch();
        jsch.getSession(user,host,22);
        session.setPassword(passwd);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking","no");
        session.setConfig(config);
        session.connect();
    }

    public void execCmd(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = "/opt/shell_script/deploy_dev.sh";
        BufferedReader reader = null;
        Channel channel = null;
        try {
            channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);
            channel.connect();
            InputStream in = channel.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in, Charset.forName(charset)));
            String buf = null;
            while ((buf = reader.readLine()) != null) {
                System.out.println(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSchException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            channel.disconnect();
            session.disconnect();
        }
    }
}

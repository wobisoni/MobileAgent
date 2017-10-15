package mobileagent.agent;

import mobileagent.GUI.ServerWindows;
import mobileagent.library.ImageDemo;
import mobileagent.bean.Agent;
import com.ibm.aglet.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import mobileagent.library.Authenticate;

public class AgentHost extends Aglet implements Serializable{
    transient ServerWindows serverWindow;
    
    @Override
    public void onCreation(Object o) {
        serverWindow = new ServerWindows(this);
        serverWindow.setVisible(true);
    }
    
    @Override
    public void run() {
    }
    
    public boolean handleMessage(Message msg) {
        if (msg.sameKind("systemInfo")) {
            System.out.println("Receive message from slave");
            Agent agent = (Agent)msg.getArg();
             serverWindow.setSystemInfo(agent);
        }else if(msg.sameKind("capture")){
            try {
                File  file = new File("F:\\TestPic\\"+System.nanoTime()+".jpg");
                byte[] byteImage = (byte[]) msg.getArg();
                System.out.println("bi "+byteImage);
                InputStream inputStream = new ByteArrayInputStream(byteImage);
                BufferedImage bi = ImageIO.read(inputStream);
                ImageDemo id = new ImageDemo(bi);
                id.setVisible(true);
                ImageIO.write(bi, "png", file);
            } catch (IOException ex) {
                Logger.getLogger(AgentHost.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }else if(msg.sameKind("remote")){
            try{
                    Socket sc = new Socket("localhost",4000);
                    System.out.println("Connecting to the Slave");
                    Authenticate frame1 = new Authenticate(sc);

                    frame1.setSize(300,80);
                    frame1.setLocation(500,300);
                    frame1.setVisible(true);
            } catch (Exception ex){
                    ex.printStackTrace();
            }
        }else{
            return false;
        }
        return true;
    }
}

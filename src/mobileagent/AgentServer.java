package mobileagent;

import com.ibm.aglet.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class AgentServer extends Aglet implements Serializable{
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
                Logger.getLogger(AgentServer.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } else{
           return false;
         }
         return true;
         }
}

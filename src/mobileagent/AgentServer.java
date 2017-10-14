package mobileagent;

import com.ibm.aglet.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
                File  file = new File("F:\\picture\\"+System.nanoTime()+".jpg");
                BufferedImage bi = (BufferedImage)msg.getArg();
                ImageIO.write(bi, "jpg", file);
            } catch (IOException ex) {
                System.out.println("Khong tao duoc file anh");
            }
        } else{
           return false;
         }
         return true;
         }
}

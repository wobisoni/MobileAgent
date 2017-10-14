package mobileagent;

import com.ibm.aglet.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import javax.imageio.ImageIO;

public class AgentSlave extends Aglet implements Serializable{
    AgletProxy ap = null;
    transient BufferedImage img;
    transient String name = "Unknown";
    
    public void onCreation(Object o) {
        ap =(AgletProxy)o;
        sendSystemInfo();
    }
    
    public void run() {
         System.out.println("Hello :)");
    }

    public boolean handleMessage(Message msg) {
         if (msg.sameKind("dialog")) {

        } else if(msg.sameKind("shutdown")){
                   shutdown();
        } else if(msg.sameKind("restart")){
                   restart();
        } else if(msg.sameKind("logout")){
            
        } else if(msg.sameKind("dispose")){
                   dispose();
        }else if(msg.sameKind("capture")){
                    capture();
        }else{
                  return false;
        }
        return true;
    }
    
    public void sendSystemInfo(){
         try {
            name = System.getProperty("user.name");
            String os = System.getProperty("os.name");
            String architecture = System.getProperty("os.arch");
            String version = System.getProperty("os.version");
            String ip = "";
            InetAddress  myIP = InetAddress.getLocalHost();
            ip = myIP.getHostAddress();
            int port = getAgletContext().getHostingURL().getPort();
            AgletProxy agletProxy = getAgletContext().getAgletProxy(getAgletID());
            Agent agent = new Agent(getAgletID(), agletProxy, " ",  " ", getProxy().isActive()? "Active":"Inactive", name, ip+":"+port, os, architecture, version);
            ap.sendMessage(new Message("systemInfo", agent));
         } catch (Exception ex) {
         }
    }
    
    public void shutdown(){
         try {
                Runtime.getRuntime().exec("shutdown -s -t 30 -c \"Your PC will shut down in 30s\"");
             } catch (IOException ex) {
             }
    }
    
    public void restart(){
         try {
             Runtime.getRuntime().exec("shutdown -r -t 30 -c \"Your PC will restart in 30s\"");
         } catch (IOException ex) {
         }
    }
    
    public void capture(){
         try {
              Toolkit toolkit = Toolkit.getDefaultToolkit();
              Dimension screenSize = toolkit.getScreenSize();
              Rectangle screenRect = new Rectangle(screenSize);
              Robot  robot = new Robot();
              img = robot.createScreenCapture(screenRect);
              ap.sendMessage(new Message("capture", img));
         } catch (Exception ex) {           
         }
    }
    
    public void sendText(String text) {
            try {
                    if (ap == null) {
                            return;
                    } 
                    ap.sendMessage(new Message("text", name + " : " + text));
            } catch (Exception ex) {
                    ex.printStackTrace();
            } 
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
            ImageIO.write(img, "jpg", out); // png is lossless
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        img = ImageIO.read(in);
    }
    
}

package mobileagent.agent;

import com.ibm.aglet.*;
import com.ibm.aglet.event.*;
import java.awt.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import mobileagent.library.ReceiveEvents;
import mobileagent.library.SendScreen;

public class AgentRemote extends Aglet{
    AgletProxy ap;
    Rectangle rectangle = null;
    Robot robot = null;
    ServerSocket ssocket=null;
    String width="";
    String height="";
    
    @Override
    public void onCreation(Object o) {
        ap = (AgletProxy)o;
        addMobilityListener(new MobilityAdapter(){
            @Override
            public void onArrival(MobilityEvent me) {
                try {
                    remote();
                    ap.sendMessage(new Message("remote", getProxy()));
                } catch (Exception ex) {
                    ex.printStackTrace();
                } 
                
            }
        });
    }

    @Override
    public boolean handleMessage(Message msg) {
        if(msg.sameKind("dispose")){
            try {
                System.out.println("tat server");
                ssocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            dispose();
        }else{
            return false;
        }
        return true;
    }

    public void remote() {
        Robot robot = null;
        Rectangle rectangle = null;
        int port = 4000;
        try{
            GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gDev = gEnv.getDefaultScreenDevice();

            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            width=""+dim.getWidth();
            height=""+dim.getHeight();
            rectangle = new Rectangle(dim);
            robot=new Robot(gDev);
            ssocket = new ServerSocket(port);
            ap.sendOnewayMessage(new Message("remote", getProxy()));
            System.out.println("Awaiting Connection from Client:");
            
            while(true){
                System.out.print(".");
                Socket socket = ssocket.accept();
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF("start");
                dos.writeUTF(width);
                dos.writeUTF(height);
                new SendScreen(socket,robot,rectangle);
                new ReceiveEvents(socket,robot);
            }
        }catch (Exception ex){
                ex.printStackTrace();
        }
    }
}

package mobileagent.agent;

import com.ibm.aglet.*;
import com.ibm.aglet.event.*;
import java.awt.*;
import java.io.DataOutputStream;
import java.net.*;
import java.net.UnknownHostException;
import mobileagent.library.ReceiveEvents;
import mobileagent.library.SendScreen;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import static java.net.InetAddress.getLocalHost;

public class AgentRemote extends Aglet{
    AgletProxy ap;
    ServerSocket socket = null;
    DataOutputStream dos = null;
    Rectangle rectangle = null;
    Robot robot = null;

    String width="";
    String height="";
    
    @Override
    public void onCreation(Object o) {
        ap = (AgletProxy)o;
        addMobilityListener(new MobilityAdapter(){
            @Override
            public void onArrival(MobilityEvent me) {
                remote();
            }
        });
    }

    @Override
    public boolean handleMessage(Message msg) {
        if(msg.sameKind("dispose")){
            dispose();
        }else{
            return false;
        }
        return true;
    }

    public void remote() {
        try{
            System.out.println("Awaiting Connection from Server");
            socket = new ServerSocket(4000);
            
            GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gDev = gEnv.getDefaultScreenDevice();

            Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
            width=""+dim.getWidth();
            height=""+dim.getHeight();
            rectangle = new Rectangle(dim);
            robot = new Robot(gDev);

            ap.sendMessage(new Message("remote", getIP()));
            System.out.println("tiep tuc");
            while(true){
                Socket sc = socket.accept();
                dos=new DataOutputStream(sc.getOutputStream());
                dos.writeUTF("valid");
                dos.writeUTF(width);
                dos.writeUTF(height);
                new SendScreen(sc,robot,rectangle);
                new ReceiveEvents(sc,robot);
            }
        }catch (Exception ex){
                ex.printStackTrace();
        }
    }
	
    private String getIP() {
         String mIP ="";
         try {
            InetAddress myIP = getLocalHost();
            mIP = myIP.getHostAddress();
         } catch (UnknownHostException ex) {
            getLogger(AgentHost.class.getName()).log(SEVERE, null, ex);
         }
         return mIP;
    }
}

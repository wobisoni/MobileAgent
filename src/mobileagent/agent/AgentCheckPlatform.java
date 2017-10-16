package mobileagent.agent;

import com.ibm.aglet.Aglet;
import com.ibm.aglet.AgletProxy;
import com.ibm.aglet.Message;
import com.ibm.aglet.event.MobilityAdapter;
import com.ibm.aglet.event.MobilityEvent;
import java.net.InetAddress;
import mobileagent.bean.Agent;

public class AgentCheckPlatform extends Aglet{
    @Override
    public void onCreation(Object o) {
        addMobilityListener(new MobilityAdapter(){
            @Override
            public void onArrival(MobilityEvent me) {
                System.out.println("Hello");
                dispose();
            }
        });
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            dispose();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
//    public void sendSystemInfo(){
//        try {
//           String name = System.getProperty("user.name");
//           String os = System.getProperty("os.name");
//           String architecture = System.getProperty("os.arch");
//           String version = System.getProperty("os.version");
//   
//           AgletProxy agletProxy = getAgletContext().getAgletProxy(getAgletID());
//           System.out.println("port ="+port);
//           Agent agent = new Agent(getAgletID(), agletProxy, "",  "" , getProxy().isActive()? "Active":"Inactive", name, ip+":"+port, os, architecture, version);
//           ap.sendOnewayMessage(new Message("systemInfo", agent));
//        } catch (Exception ex) {
//        }
//    }
}

package mobileagent.library;

import com.ibm.aglet.Aglet;
import com.ibm.aglet.AgletProxy;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mobileagent.bean.Host;
import mobileagent.render.IpTableModel;

public class SendNoti {
IpTableModel ipModel;
    ExecutorService executor;
    Aglet aglet;
    Host host;
    String ip;
    int last = 0;
    int temp = 0;
    final int threads;
    final int port;
    String noti;

    public SendNoti(String ip, Aglet aglet, IpTableModel ipModel) {
        this.ipModel = ipModel;
        this.ip = ip;
        this.aglet = aglet;
        this.threads = 64;
        this.port = 4434;
    }

    public void sendNoti(String noti){
        this.noti = noti;
        temp = 0;
        executor = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < ipModel.getRowCount()-1; i++) {
            executor.submit(new Runnable() {
                public void run() {
                    startSend();
                }
            });
        }
    }
    
    public void startSend(){
        synchronized (this){
            host = ipModel.getObject(temp);
            temp++;
        }
        try{
            if(host.getPlatform()==1){
                String urlcheck = "atp://"+host.getIp()+":"+port;
                URL url = new URL(urlcheck);
                AgletProxy ap = aglet.getAgletContext().createAglet(url,"mobileagent.agent.AgentNoti" , noti);
                ap.dispatch(url);
            }
        }catch(Exception e){
            
        }
    }
}

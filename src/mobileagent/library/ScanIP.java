package mobileagent.library;

import mobileagent.render.IpTableModel;
import com.ibm.aglet.Aglet;
import com.ibm.aglet.AgletProxy;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mobileagent.bean.Host;

public class ScanIP {
    IpTableModel ipModel;
    ExecutorService executor;
    Aglet aglet;
    String ip;
    int last = 0;
    int temp = 0;
    final int threads;
    final int port;
    String noti;

    public ScanIP(String ip, Aglet aglet, IpTableModel ipModel) {
        this.ipModel = ipModel;
        this.ip = ip;
        this.aglet = aglet;
        this.threads = 64;
        this.port = 4434;
    }

    public void startScan() throws UnknownHostException, IOException{
        System.out.println(ip);
        last = 0;
        ip = ip.substring(0, ip.lastIndexOf(".")+1);
        System.out.println(ip);
        executor = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < 255; i++) {
            executor.submit(new Runnable() {
                public void run() {
                    pingIP();
                }
            });
        }
    }
    
    public void pingIP(){
        String scanIP = "";
        synchronized (this){
            scanIP = ip+last;
            last++;
        }
        
        try {
            InetAddress address = InetAddress.getByName(scanIP);
            if(address.isReachable(5000)){
                String hostname = address.getHostName();
                String urlcheck = "atp://"+scanIP+":"+port;
                URL url = new URL(urlcheck);
                try{
                    Object obj[] = new Object[]{aglet.getProxy(), scanIP, hostname};
                    AgletProxy agletpx = aglet.getAgletContext().createAglet(url,"mobileagent.agent.AgentCheckPlatform" , obj);
//                    agletpx.dispatch(url);
                }catch(Exception e){
                    Host ipA = new Host(scanIP, hostname,"","","",0);
                    System.out.println(scanIP+"-"+hostname+"-"+0);
                    ipModel.addRow(ipA);
                }
            }   
        } catch (Exception ex) {
        } 
    }
    
    public void stopScan(){
        executor.shutdown();
        last = 0;
        ipModel.clear();
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
        Host host;
        synchronized (this){
            host = ipModel.getObject(temp);
            temp++;
        }
        try{
            if(host.getPlatform()==1){
                String urlcheck = "atp://"+host.getIp()+":"+port;
                URL url = new URL(urlcheck);
                AgletProxy ap = aglet.getAgletContext().createAglet(aglet.getCodeBase(),"mobileagent.agent.AgentNoti" , noti);
                ap.dispatch(url);
            }
        }catch(Exception e){
            
        }
    }
}

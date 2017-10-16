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

public class ScanIP {
    IpTableModel ipModel;
    ExecutorService executor;
    Aglet aglet;
    String ip;
    int last = 0;
    final int threads;
    final int port;

    public ScanIP(String ip, Aglet aglet, IpTableModel ipModel) {
        this.ipModel = ipModel;
        this.ip = ip;
        this.aglet = aglet;
        this.threads = 64;
        this.port = 4434;
    }

    public void startScan() throws UnknownHostException, IOException{
        System.out.println(ip);
        ip = ip.substring(0, ip.lastIndexOf(".")+1);
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
            last++;
            scanIP = ip+last;
        }
        
        try {
            InetAddress address = InetAddress.getByName(scanIP);
            if(address.isReachable(3000)){
                String hostname = address.getHostName();
                int check = 1;
                String urlcheck = "atp://"+scanIP+":"+port;
                URL url = new URL(urlcheck);
                try{
                    AgletProxy ap = aglet.getAgletContext().createAglet(url,"mobileagent.agent.AgentCheckPlatform" , ip);
                }catch(Exception e){
                    check = 0;
                }
                Host ipA = new Host(scanIP, hostname,"","","",check);
                System.out.println(scanIP+"-"+hostname+"-"+check);
                ipModel.addRow(ipA);
            }   
        } catch (Exception ex) {
        } 
    }
    
    public void stopScan(){
        executor.shutdown();
        last = 0;
        ipModel.clear();
    }
}

package mobileagent.bean;

import com.ibm.aglet.*;
import java.io.Serializable;

public class Agent implements Serializable{
    private AgletID aId;
    private AgletProxy aProxy;
    private String aName;
    private String aTime;
    private String aStatus;
    private String sName;
    private String sIp;
    private String sOs;
    private String sArch;
    private String sVersion;
    
    public Agent() {
        
    }

    public Agent(AgletID aId, AgletProxy aProxy, String aName, String aTime, String aStatus, String sName, String sIp, String sOs, String sArch, String sVersion) {
        this.aId = aId;
        this.aProxy = aProxy;
        this.aName = aName;
        this.aTime = aTime;
        this.aStatus = aStatus;
        this.sName = sName;
        this.sIp = sIp;
        this.sOs = sOs;
        this.sArch = sArch;
        this.sVersion = sVersion;
    }

    public AgletID getaId() {
        return aId;
    }

    public void setaId(AgletID aId) {
        this.aId = aId;
    }

    public AgletProxy getaProxy() {
        return aProxy;
    }

    public void setaProxy(AgletProxy aProxy) {
        this.aProxy = aProxy;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaTime() {
        return aTime;
    }

    public void setaTime(String aTime) {
        this.aTime = aTime;
    }

    public String getaStatus() {
        return aStatus;
    }

    public void setaStatus(String aStatus) {
        this.aStatus = aStatus;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsIp() {
        return sIp;
    }

    public void setsIp(String sIp) {
        this.sIp = sIp;
    }

    public String getsOs() {
        return sOs;
    }

    public void setsOs(String sOs) {
        this.sOs = sOs;
    }

    public String getsArch() {
        return sArch;
    }

    public void setsArch(String sArch) {
        this.sArch = sArch;
    }

    public String getsVersion() {
        return sVersion;
    }

    public void setsVersion(String sVersion) {
        this.sVersion = sVersion;
    }
}

package mobileagent.library;

import mobileagent.bean.Agent;
import mobileagent.bean.Agent;
import com.ibm.aglet.InvalidAgletException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel{
    String[] header;
    ArrayList<Agent>  arAgent;

    public MyTableModel(ArrayList<Agent> arAgent) {
         this.header = new String [] { "ID","Name", "Status", "Location", " IP Address", "Create time" };
         this.arAgent = arAgent;
    }
    
    public int getRowCount() {
         return arAgent.size();
    }

    public String getColumnName(int column) {
         return header[column];
    }

    public int getColumnCount() {
         return header.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
         Object object = null;
         switch(columnIndex){
                   case 0:
                       return arAgent.get(rowIndex).getaId();
                   case 1:
                       return arAgent.get(rowIndex).getaName();
                   case 2:
                       return arAgent.get(rowIndex).getaStatus();
                   case 3:
                       return arAgent.get(rowIndex).getsName();
                   case 4:
                       return arAgent.get(rowIndex).getsIp();
                   case 5:
                       return arAgent.get(rowIndex).getaTime();
         }
         return object;
    }
    
    public Agent getObject(int index){
        return arAgent.get(index);
    }
    
    public void addRow(Agent agent){
         arAgent.add(agent);
         fireTableDataChanged();
    }
    
    public void updateRow(int index, Agent agent){
         arAgent.set(index, agent);
         fireTableDataChanged();
    }
    
    public void delRow(int index) throws InvalidAgletException{
         arAgent.remove(index);
         fireTableDataChanged();
    }

    public void updateInfo(Agent agent) {
        for (int i = 0; i < arAgent.size(); i++){
            if(((Agent)arAgent.get(i)).getaId().equals(agent.getaId())){
                  Agent ag = (Agent)arAgent.get(i);
                 ag.setsIp(agent.getsIp());
                 ag.setsArch(agent.getsArch());
                 ag.setsName(agent.getsName());
                 ag.setsOs(agent.getsOs());
                 ag.setsVersion(agent.getsVersion());
            }
        }
        fireTableDataChanged();
    }
}

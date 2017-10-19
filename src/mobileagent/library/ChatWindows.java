package mobileagent.library;

import com.ibm.aglet.AgletProxy;
import java.awt.*;
import java.awt.event.*;
import mobileagent.agent.AgentChatServer;
import mobileagent.agent.AgentChatClient;

public class ChatWindows extends Frame implements ActionListener {
	TextArea text = new TextArea();
	TextField input = new TextField();

	String address = "";
	AgentChatServer master = null;
	AgentChatClient slave = null;
        AgletProxy apClient;

	public ChatWindows(AgentChatServer master) {
            super("Chat");
            this.master = master;
            setLayout(new BorderLayout(5, 5));

            add("Center", text);
            add("South", input);

            text.setEditable(false);
            input.addActionListener(this);

            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.out.println("tat chat");
                    setVisible(false);
                } 
            });
        }
        
	public ChatWindows(AgentChatClient slave) {
            super("ADMIN");
            this.slave = slave;
            setLayout(new BorderLayout());

            add("Center", text);
            add("South", input);

            text.setEditable(false);
            input.addActionListener(this);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.out.println("tat Client");
                    setVisible(false);
                } 
            });
        }
        
	public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == input) {
                String t = input.getText();
                appendText("Me:"+t);
                if (master != null) {
                    if(apClient==null){
                        apClient = master.dispatchSlave();
                    }
                    master.sendText(t);
                } else if (slave != null) {
                    slave.sendText(t);
                } 
                input.setText("");
            } 
        }
        
	public void appendText(String str) {
            text.append(str + "\r\n");
        }
}
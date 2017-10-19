package mobileagent.agent;

import com.ibm.aglet.Aglet;
import com.ibm.aglet.event.MobilityAdapter;
import com.ibm.aglet.event.MobilityEvent;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class AgentNoti extends Aglet{
    String message;
    public void onCreation(Object o) {
        message = (String)o;
        addMobilityListener(new MobilityAdapter(){
            @Override
            public void onArrival(MobilityEvent me) {
                try {
                    GUI();
                    Thread.sleep(10000);
                    dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                } 
                
            }
        });
    }
    
    public void GUI(){
        JFrame frame = new JFrame();
        frame.setSize(300,150);
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setTitle("Tin nhắn từ máy chủ");
        JLabel messageLabel = new JLabel("<HtMl>"+message);
        frame.add(messageLabel);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();// size of the screen
        Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());// height of the task bar
        frame.setLocation(scrSize.width - frame.getWidth(), scrSize.height - toolHeight.bottom - frame.getHeight());
        frame.setVisible(true);
    }
}

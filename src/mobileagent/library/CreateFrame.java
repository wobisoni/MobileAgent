package mobileagent.library;

import com.ibm.aglet.Aglet;
import com.ibm.aglet.AgletProxy;
import com.ibm.aglet.InvalidAgletException;
import com.ibm.aglet.Message;
import com.ibm.aglet.MessageException;
import com.ibm.aglet.NotHandledException;
import java.awt.BorderLayout;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.net.Socket;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateFrame extends Thread {
    String width="", height="";
    private final JFrame frame = new JFrame();
    private final JDesktopPane desktop = new JDesktopPane();
    private Socket socket = null;
    private final JInternalFrame interFrame = new JInternalFrame("Remote Desktop", true, true, true);
    private final JPanel panel = new JPanel();
    AgletProxy remoteProxy = null;

    public CreateFrame(AgletProxy aglet, Socket socket, String width, String height) {
        this.width = width;
        this.height = height;
        this.socket = socket;
        this.remoteProxy = aglet;
        start();
    }

    public void drawGUI() {
        frame.add(desktop, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);		//CHECK THIS LINE
        frame.setVisible(true);
        interFrame.setLayout(new BorderLayout());
        interFrame.getContentPane().add(panel, BorderLayout.CENTER);
        interFrame.setSize(100,100);
        desktop.add(interFrame);

        try {
            //Initially show the internal frame maximized
            interFrame.setMaximum(true);
        }catch (PropertyVetoException ex) { 
            ex.printStackTrace();
        }
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    remoteProxy.sendOnewayMessage(new Message("dispose", null));
                    socket.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        //This allows to handle KeyListener events
        panel.setFocusable(true);
        interFrame.setVisible(true);
    }

    public void run() { 
        //Used to read screenshots
        InputStream is = null;
        //start drawing GUI
        drawGUI();
        try{
            is = socket.getInputStream();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        //Start receiving screenshots
        new ReceiveScreen(is, panel);
        //Start sending events to the client
        new SendEvents(socket,panel,width,height);
    }
}

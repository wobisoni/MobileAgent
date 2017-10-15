package mobileagent.GUI;

import mobileagent.agent.AgentHost;
import mobileagent.library.MyTableModel;
import mobileagent.bean.Agent;
import com.ibm.aglet.AgletContext;
import com.ibm.aglet.AgletID;
import com.ibm.aglet.AgletProxy;
import com.ibm.aglet.Message;
import static java.awt.EventQueue.invokeLater;
import java.net.InetAddress;
import static java.net.InetAddress.getLocalHost;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Logger.getLogger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.UIManager.setLookAndFeel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class ServerWindows extends javax.swing.JFrame {
    transient AgentHost agentServer = null;
    static ArrayList<Agent> arAgent;
    MyTableModel mListAgent;
    String ip = "";
    
    public ServerWindows() {
        initComponents();
    }

    public ServerWindows(AgentHost aglet) {
         arAgent = new ArrayList();
         mListAgent = new MyTableModel(arAgent);
         ip = getIP();
         this.agentServer = aglet;
         initComponents();
         tbListAgent.setModel(mListAgent);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        panel11 = new javax.swing.JPanel();
        panel111 = new javax.swing.JPanel();
        spListAgent = new javax.swing.JScrollPane();
        tbListAgent = new javax.swing.JTable();
        panel112 = new javax.swing.JPanel();
        spListHost = new javax.swing.JScrollPane();
        tbListHost = new javax.swing.JTable();
        btnMove = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        panel12 = new javax.swing.JPanel();
        panel121 = new javax.swing.JPanel();
        panel1211 = new javax.swing.JPanel();
        lb1 = new javax.swing.JLabel();
        lbAID = new javax.swing.JLabel();
        panel1212 = new javax.swing.JPanel();
        lb2 = new javax.swing.JLabel();
        lbAName = new javax.swing.JLabel();
        panel1213 = new javax.swing.JPanel();
        lb3 = new javax.swing.JLabel();
        lbALocal = new javax.swing.JLabel();
        panel1214 = new javax.swing.JPanel();
        lb4 = new javax.swing.JLabel();
        lbAServer = new javax.swing.JLabel();
        panel1215 = new javax.swing.JPanel();
        lb5 = new javax.swing.JLabel();
        lbATime = new javax.swing.JLabel();
        panel1216 = new javax.swing.JPanel();
        lb6 = new javax.swing.JLabel();
        lbAStatus = new javax.swing.JLabel();
        panel122 = new javax.swing.JPanel();
        panel1221 = new javax.swing.JPanel();
        lb7 = new javax.swing.JLabel();
        lbSName = new javax.swing.JLabel();
        panel1222 = new javax.swing.JPanel();
        lb8 = new javax.swing.JLabel();
        lbSIP = new javax.swing.JLabel();
        panel1223 = new javax.swing.JPanel();
        lb9 = new javax.swing.JLabel();
        lbSOS = new javax.swing.JLabel();
        panel1224 = new javax.swing.JPanel();
        lb10 = new javax.swing.JLabel();
        lbSArch = new javax.swing.JLabel();
        panel1225 = new javax.swing.JPanel();
        lb11 = new javax.swing.JLabel();
        lbSVersion = new javax.swing.JLabel();
        panel1226 = new javax.swing.JPanel();
        lb12 = new javax.swing.JLabel();
        lbSStatus = new javax.swing.JLabel();
        panel13 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnReDesktop = new javax.swing.JButton();
        btnCapture = new javax.swing.JButton();
        btnChat = new javax.swing.JButton();
        btnSystem = new javax.swing.JButton();
        btnNoti = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        lbbottom = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuSettings = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N

        panel1.setName("panel1"); // NOI18N
        panel1.setLayout(new java.awt.BorderLayout());

        panel11.setName("panel11"); // NOI18N
        panel11.setLayout(new java.awt.BorderLayout());

        panel111.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List Agent", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(255, 0, 0))); // NOI18N
        panel111.setName("panel111"); // NOI18N
        panel111.setPreferredSize(new java.awt.Dimension(550, 433));

        spListAgent.setName("spListAgent"); // NOI18N

        tbListAgent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tbListAgent.setName("tbListAgent"); // NOI18N
        spListAgent.setViewportView(tbListAgent);

        org.jdesktop.layout.GroupLayout panel111Layout = new org.jdesktop.layout.GroupLayout(panel111);
        panel111.setLayout(panel111Layout);
        panel111Layout.setHorizontalGroup(
            panel111Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(spListAgent, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
        );
        panel111Layout.setVerticalGroup(
            panel111Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(spListAgent, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );

        panel11.add(panel111, java.awt.BorderLayout.CENTER);

        panel112.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List Host", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(255, 0, 0))); // NOI18N
        panel112.setName("panel112"); // NOI18N

        spListHost.setName("spListHost"); // NOI18N

        tbListHost.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "IP"
            }
        ));
        tbListHost.setName("tbListHost"); // NOI18N
        spListHost.setViewportView(tbListHost);

        btnMove.setBackground(new java.awt.Color(255, 255, 255));
        btnMove.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMove.setIcon(new javax.swing.ImageIcon("C:\\aglets\\public\\mobileagent\\icon\\move.png")); // NOI18N
        btnMove.setText("Move");
        btnMove.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMove.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnMove.setMaximumSize(new java.awt.Dimension(133, 59));
        btnMove.setMinimumSize(new java.awt.Dimension(133, 59));
        btnMove.setName("btnMove"); // NOI18N
        btnMove.setPreferredSize(new java.awt.Dimension(135, 59));
        btnMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon("C:\\aglets\\public\\mobileagent\\icon\\update.png")); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUpdate.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnUpdate.setMaximumSize(new java.awt.Dimension(133, 59));
        btnUpdate.setMinimumSize(new java.awt.Dimension(133, 59));
        btnUpdate.setName("btnUpdate"); // NOI18N
        btnUpdate.setPreferredSize(new java.awt.Dimension(135, 59));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout panel112Layout = new org.jdesktop.layout.GroupLayout(panel112);
        panel112.setLayout(panel112Layout);
        panel112Layout.setHorizontalGroup(
            panel112Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(spListHost, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 135, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(btnMove, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(btnUpdate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        panel112Layout.setVerticalGroup(
            panel112Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panel112Layout.createSequentialGroup()
                .add(spListHost, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 273, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(btnMove, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnUpdate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 6, Short.MAX_VALUE))
        );

        panel11.add(panel112, java.awt.BorderLayout.LINE_END);

        panel1.add(panel11, java.awt.BorderLayout.CENTER);

        panel12.setName("panel12"); // NOI18N
        panel12.setLayout(new java.awt.GridLayout(2, 1));

        panel121.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agent Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(255, 0, 0))); // NOI18N
        panel121.setName("panel121"); // NOI18N
        panel121.setPreferredSize(new java.awt.Dimension(250, 155));
        panel121.setLayout(new java.awt.GridLayout(6, 1));

        panel1211.setName("panel1211"); // NOI18N
        panel1211.setLayout(new java.awt.GridLayout(1, 2));

        lb1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb1.setText("   ID");
        lb1.setName("lb1"); // NOI18N
        panel1211.add(lb1);

        lbAID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbAID.setText(": id");
        lbAID.setName("lbAID"); // NOI18N
        panel1211.add(lbAID);

        panel121.add(panel1211);

        panel1212.setName("panel1212"); // NOI18N
        panel1212.setLayout(new java.awt.GridLayout(1, 2));

        lb2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb2.setText("   Name");
        lb2.setName("lb2"); // NOI18N
        panel1212.add(lb2);

        lbAName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbAName.setText(": name");
        lbAName.setName("lbAName"); // NOI18N
        panel1212.add(lbAName);

        panel121.add(panel1212);

        panel1213.setName("panel1213"); // NOI18N
        panel1213.setLayout(new java.awt.GridLayout(1, 2));

        lb3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb3.setText("   Locate");
        lb3.setName("lb3"); // NOI18N
        panel1213.add(lb3);

        lbALocal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbALocal.setText(": locate");
        lbALocal.setName("lbALocal"); // NOI18N
        panel1213.add(lbALocal);

        panel121.add(panel1213);

        panel1214.setName("panel1214"); // NOI18N
        panel1214.setLayout(new java.awt.GridLayout(1, 2));

        lb4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb4.setText("   Server");
        lb4.setName("lb4"); // NOI18N
        panel1214.add(lb4);

        lbAServer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbAServer.setText(": Server");
        lbAServer.setName("lbAServer"); // NOI18N
        panel1214.add(lbAServer);

        panel121.add(panel1214);

        panel1215.setName("panel1215"); // NOI18N
        panel1215.setLayout(new java.awt.GridLayout(1, 2));

        lb5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb5.setText("   Time create");
        lb5.setName("lb5"); // NOI18N
        panel1215.add(lb5);

        lbATime.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbATime.setText(": time create");
        lbATime.setName("lbATime"); // NOI18N
        panel1215.add(lbATime);

        panel121.add(panel1215);

        panel1216.setName("panel1216"); // NOI18N
        panel1216.setLayout(new java.awt.GridLayout(1, 2));

        lb6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb6.setText("   Status");
        lb6.setName("lb6"); // NOI18N
        panel1216.add(lb6);

        lbAStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbAStatus.setText(": status");
        lbAStatus.setName("lbAStatus"); // NOI18N
        panel1216.add(lbAStatus);

        panel121.add(panel1216);

        panel12.add(panel121);

        panel122.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "System Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(255, 0, 0))); // NOI18N
        panel122.setName("panel122"); // NOI18N
        panel122.setLayout(new java.awt.GridLayout(6, 1));

        panel1221.setName("panel1221"); // NOI18N
        panel1221.setLayout(new java.awt.GridLayout(1, 2));

        lb7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb7.setText("   PC-Name");
        lb7.setName("lb7"); // NOI18N
        panel1221.add(lb7);

        lbSName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSName.setText(": Wobisoni");
        lbSName.setName("lbSName"); // NOI18N
        panel1221.add(lbSName);

        panel122.add(panel1221);

        panel1222.setName("panel1222"); // NOI18N
        panel1222.setLayout(new java.awt.GridLayout(1, 2));

        lb8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb8.setText("   IP Address");
        lb8.setName("lb8"); // NOI18N
        panel1222.add(lb8);

        lbSIP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSIP.setText(": 192.168.1.8");
        lbSIP.setName("lbSIP"); // NOI18N
        panel1222.add(lbSIP);

        panel122.add(panel1222);

        panel1223.setName("panel1223"); // NOI18N
        panel1223.setLayout(new java.awt.GridLayout(1, 2));

        lb9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb9.setText("   OS");
        lb9.setName("lb9"); // NOI18N
        panel1223.add(lb9);

        lbSOS.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSOS.setText(": Windows 10");
        lbSOS.setName("lbSOS"); // NOI18N
        panel1223.add(lbSOS);

        panel122.add(panel1223);

        panel1224.setName("panel1224"); // NOI18N
        panel1224.setLayout(new java.awt.GridLayout(1, 2));

        lb10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb10.setText("   Architecture");
        lb10.setName("lb10"); // NOI18N
        panel1224.add(lb10);

        lbSArch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSArch.setText(": Windows");
        lbSArch.setName("lbSArch"); // NOI18N
        panel1224.add(lbSArch);

        panel122.add(panel1224);

        panel1225.setName("panel1225"); // NOI18N
        panel1225.setLayout(new java.awt.GridLayout(1, 2));

        lb11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb11.setText("   Version");
        lb11.setName("lb11"); // NOI18N
        panel1225.add(lb11);

        lbSVersion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSVersion.setText(": 10.0");
        lbSVersion.setName("lbSVersion"); // NOI18N
        panel1225.add(lbSVersion);

        panel122.add(panel1225);

        panel1226.setName("panel1226"); // NOI18N
        panel1226.setLayout(new java.awt.GridLayout(1, 2));

        lb12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lb12.setText("   Status");
        lb12.setName("lb12"); // NOI18N
        panel1226.add(lb12);

        lbSStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbSStatus.setText(": Active");
        lbSStatus.setName("lbSStatus"); // NOI18N
        panel1226.add(lbSStatus);

        panel122.add(panel1226);

        panel12.add(panel122);

        panel1.add(panel12, java.awt.BorderLayout.LINE_END);

        panel13.setName("panel13"); // NOI18N

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon("C:\\aglets\\public\\mobileagent\\icon\\add.png")); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAdd.setMaximumSize(new java.awt.Dimension(133, 59));
        btnAdd.setMinimumSize(new java.awt.Dimension(133, 59));
        btnAdd.setName("btnAdd"); // NOI18N
        btnAdd.setPreferredSize(new java.awt.Dimension(135, 59));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        panel13.add(btnAdd);

        btnRemove.setBackground(new java.awt.Color(255, 255, 255));
        btnRemove.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemove.setIcon(new javax.swing.ImageIcon("C:\\aglets\\public\\mobileagent\\icon\\Recycle_Bin.png")); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRemove.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRemove.setMaximumSize(new java.awt.Dimension(133, 59));
        btnRemove.setMinimumSize(new java.awt.Dimension(133, 59));
        btnRemove.setName("btnRemove"); // NOI18N
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        panel13.add(btnRemove);

        btnReDesktop.setBackground(new java.awt.Color(255, 255, 255));
        btnReDesktop.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReDesktop.setIcon(new javax.swing.ImageIcon("C:\\aglets\\public\\mobileagent\\icon\\Remote-Desktop.png")); // NOI18N
        btnReDesktop.setText("Remote");
        btnReDesktop.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnReDesktop.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnReDesktop.setMaximumSize(new java.awt.Dimension(133, 59));
        btnReDesktop.setMinimumSize(new java.awt.Dimension(133, 59));
        btnReDesktop.setName("btnReDesktop"); // NOI18N
        btnReDesktop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReDesktopActionPerformed(evt);
            }
        });
        panel13.add(btnReDesktop);

        btnCapture.setBackground(new java.awt.Color(255, 255, 255));
        btnCapture.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCapture.setIcon(new javax.swing.ImageIcon("C:\\aglets\\public\\mobileagent\\icon\\camera.png")); // NOI18N
        btnCapture.setText("Capture");
        btnCapture.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCapture.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCapture.setMaximumSize(new java.awt.Dimension(133, 59));
        btnCapture.setMinimumSize(new java.awt.Dimension(133, 59));
        btnCapture.setName("btnCapture"); // NOI18N
        btnCapture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaptureActionPerformed(evt);
            }
        });
        panel13.add(btnCapture);

        btnChat.setBackground(new java.awt.Color(255, 255, 255));
        btnChat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnChat.setIcon(new javax.swing.ImageIcon("C:\\aglets\\public\\mobileagent\\icon\\Chat.png")); // NOI18N
        btnChat.setText("Chat");
        btnChat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnChat.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnChat.setMaximumSize(new java.awt.Dimension(133, 59));
        btnChat.setMinimumSize(new java.awt.Dimension(133, 59));
        btnChat.setName("btnChat"); // NOI18N
        btnChat.setPreferredSize(new java.awt.Dimension(135, 59));
        btnChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatActionPerformed(evt);
            }
        });
        panel13.add(btnChat);

        btnSystem.setBackground(new java.awt.Color(255, 255, 255));
        btnSystem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSystem.setIcon(new javax.swing.ImageIcon("C:\\aglets\\public\\mobileagent\\icon\\system-settings-icon.png")); // NOI18N
        btnSystem.setText("System");
        btnSystem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSystem.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSystem.setMaximumSize(new java.awt.Dimension(133, 59));
        btnSystem.setMinimumSize(new java.awt.Dimension(133, 59));
        btnSystem.setName("btnSystem"); // NOI18N
        btnSystem.setPreferredSize(new java.awt.Dimension(135, 59));
        btnSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSystemActionPerformed(evt);
            }
        });
        panel13.add(btnSystem);

        btnNoti.setBackground(new java.awt.Color(255, 255, 255));
        btnNoti.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNoti.setIcon(new javax.swing.ImageIcon("C:\\aglets\\public\\mobileagent\\icon\\noti.png")); // NOI18N
        btnNoti.setText("Notification");
        btnNoti.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNoti.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNoti.setMaximumSize(new java.awt.Dimension(133, 59));
        btnNoti.setMinimumSize(new java.awt.Dimension(133, 59));
        btnNoti.setName("btnNoti"); // NOI18N
        btnNoti.setPreferredSize(new java.awt.Dimension(135, 59));
        btnNoti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotiActionPerformed(evt);
            }
        });
        panel13.add(btnNoti);

        panel1.add(panel13, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(panel1, java.awt.BorderLayout.CENTER);

        panel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panel2.setName("panel2"); // NOI18N

        lbbottom.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lbbottom.setText("Design and code by Nguyễn Văn Cao & Đoàn Minh Cường");
        lbbottom.setName("lbbottom"); // NOI18N
        panel2.add(lbbottom);

        getContentPane().add(panel2, java.awt.BorderLayout.SOUTH);

        menuBar.setName("menuBar"); // NOI18N

        menuFile.setText("File");
        menuFile.setName("menuFile"); // NOI18N
        menuBar.add(menuFile);

        menuSettings.setText("Settings");
        menuSettings.setName("menuSettings"); // NOI18N
        menuBar.add(menuSettings);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            //Thông tin Aglet
            String agentName = showInputDialog("Agent Name", "Agent");
            if(agentName!=null){
                    String create_time = getTime();
                    //Tạo thể hiện contex
                    AgletContext context = agentServer.getAgletContext();
                    //Tạo mới Aglet
                    AgletProxy aProxy = (AgletProxy)context.createAglet(agentServer.getCodeBase(), "mobileagent.agent.AgentSlave",agentServer.getProxy()) ;
                    AgletID aID = aProxy.getAgletID();
                    System.out.println("Khoi tao aglet: "+aID);
                    //Lưu vào mảng
                    Agent objAgent = new Agent(aID, aProxy, agentName, create_time, aProxy.isActive()?"Active":"Invalid", "", "", "", "", "");
                    mListAgent.addRow(objAgent);
            }
        }catch (Exception ex) {
            System.out.println("Loi khi tao Aglets");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        try {
            //Thông tin Aglet
            String agentName = showInputDialog("Agent Name", "Agent");
            if(agentName!=null){
                    String create_time = getTime();
                    //Tạo thể hiện contex
                    AgletContext context = agentServer.getAgletContext();
                    //Tạo mới Aglet
                    AgletProxy aProxy = (AgletProxy)context.createAglet(agentServer.getCodeBase(), "mobileagent.agent.AgentRemote",agentServer.getProxy()) ;
                    AgletID aID = aProxy.getAgletID();
                    System.out.println("Khoi tao aglet: "+aID);
                    //Lưu vào mảng
                    Agent objAgent = new Agent(aID, aProxy, agentName, create_time, aProxy.isActive()?"Active":"Invalid", "", "", "", "", "");
                    mListAgent.addRow(objAgent);
            }
        }catch (Exception ex) {
            System.out.println("Loi khi tao Aglets");
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnReDesktopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReDesktopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReDesktopActionPerformed

    private void btnCaptureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaptureActionPerformed
         int index = tbListAgent.getSelectedRow(); 
         if(index!=-1){   
            try {
                Agent agent = (Agent)arAgent.get(index);   
                AgletProxy ap = agent.getaProxy();
                ap.sendMessage(new Message("capture", null));
            } catch (Exception ex) {
            }
        }else{
             JOptionPane.showMessageDialog(this, "Select one aglets!");
         }
    }//GEN-LAST:event_btnCaptureActionPerformed

    private void btnChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChatActionPerformed

    private void btnSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSystemActionPerformed
//        int index = tbListAgent.getSelectedRow(); 
//        Agent agent = mListAgent.getObject(index);   
//        AgletProxy ap = agent.getaProxy();
//        String [] days = { "Shutdown", "Restart", "Logout"};   
//        String input =  JOptionPane.showInputDialog (this,  "Choose an action",  " System ",  JOptionPane.QUESTION_MESSAGE,  null,  days, "").toString();
//        try{
//            switch(input){
//                  case "Shutdown": 
//                           ap.sendMessage(new Message("shutdown"));
//                           System.out.println("tat may trong 30s");
//                      break;
//                  case "Restart": 
//                            ap.sendMessage(new Message("restart"));
//                      break;
//                  case "Logout": 
//                             ap.sendMessage(new Message("Logout"));   
//                      break;
//                  default:
//                      break;
//              }
//        }catch(Exception ex){}
    }//GEN-LAST:event_btnSystemActionPerformed

    private void btnMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveActionPerformed
        try {
            int index = tbListAgent.getSelectedRow(); 
            if(index!=-1){
                Agent agent = (Agent)mListAgent.getObject(index);   
               String host = showInputDialog("IP Address", "localhost");
               String aPort = showInputDialog("Port", "4434");
               if((host!=null)&&(aPort!=null)){
                    String remoteContext = "atp://"+host+":"+aPort;
                    URL url = new URL(remoteContext);
                    AgletProxy ap =  agent.getaProxy().dispatch(url);
                    arAgent.get(index).setaProxy(ap);
               }
            }else{
                JOptionPane.showMessageDialog(this, "Select one aglets!");
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_btnMoveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnNotiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNotiActionPerformed

    public static void main(String args[]) {
        try {
            setLookAndFeel(new MetalLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            getLogger(ServerWindows.class.getName()).log(SEVERE, null, ex);
        }

        invokeLater(new Runnable() {
            public void run() {
                new ServerWindows().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCapture;
    private javax.swing.JButton btnChat;
    private javax.swing.JButton btnMove;
    private javax.swing.JButton btnNoti;
    private javax.swing.JButton btnReDesktop;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSystem;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lb10;
    private javax.swing.JLabel lb11;
    private javax.swing.JLabel lb12;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    private javax.swing.JLabel lb5;
    private javax.swing.JLabel lb6;
    private javax.swing.JLabel lb7;
    private javax.swing.JLabel lb8;
    private javax.swing.JLabel lb9;
    private javax.swing.JLabel lbAID;
    private javax.swing.JLabel lbALocal;
    private javax.swing.JLabel lbAName;
    private javax.swing.JLabel lbAServer;
    private javax.swing.JLabel lbAStatus;
    private javax.swing.JLabel lbATime;
    private javax.swing.JLabel lbSArch;
    private javax.swing.JLabel lbSIP;
    private javax.swing.JLabel lbSName;
    private javax.swing.JLabel lbSOS;
    private javax.swing.JLabel lbSStatus;
    private javax.swing.JLabel lbSVersion;
    private javax.swing.JLabel lbbottom;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuSettings;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel11;
    private javax.swing.JPanel panel111;
    private javax.swing.JPanel panel112;
    private javax.swing.JPanel panel12;
    private javax.swing.JPanel panel121;
    private javax.swing.JPanel panel1211;
    private javax.swing.JPanel panel1212;
    private javax.swing.JPanel panel1213;
    private javax.swing.JPanel panel1214;
    private javax.swing.JPanel panel1215;
    private javax.swing.JPanel panel1216;
    private javax.swing.JPanel panel122;
    private javax.swing.JPanel panel1221;
    private javax.swing.JPanel panel1222;
    private javax.swing.JPanel panel1223;
    private javax.swing.JPanel panel1224;
    private javax.swing.JPanel panel1225;
    private javax.swing.JPanel panel1226;
    private javax.swing.JPanel panel13;
    private javax.swing.JPanel panel2;
    private javax.swing.JScrollPane spListAgent;
    private javax.swing.JScrollPane spListHost;
    private javax.swing.JTable tbListAgent;
    private javax.swing.JTable tbListHost;
    // End of variables declaration//GEN-END:variables

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
    
    private int getPort() {
         return agentServer.getAgletContext().getHostingURL().getPort();
    }
    
    public String getTime(){
             DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
             Date date = new Date();
             return dateFormat.format(date);
    }
    
    public void setSystemInfo(Agent agent){
            int index =-1;
            for (Agent Objagent : arAgent) {
                    if(Objagent.getaId().toString().equals(agent.getaId().toString())){
                        System.out.println("aid= "+agent.getaId());
                        index = arAgent.indexOf(Objagent);
                        Objagent.setsName(agent.getsName());
                        Objagent.setsIp(agent.getsIp());
                        Objagent.setsArch(agent.getsArch());
                        Objagent.setsOs(agent.getsOs());
                        Objagent.setsVersion(agent.getsVersion());
//                        lbSName.setText(": "+agent.getsName());//" name");
//                        lbSIP.setText(": "+agent.getsIp());// location");
//                        lbSOS.setText(": "+agent.getsOs());//" window");
//                        lbSArch.setText(": "+agent.getsArch());//" architecture");
//                        lbSVersion.setText(": "+agent.getsVersion());//" version");
                        break;
                    }
             }
            setInfo(arAgent.get(index));
    }
    
    public void setInfo(Agent agent){
            lbAID.setText(": "+agent.getaId().toString()); // id
            lbAName.setText(": "+agent.getaName());  // name
            lbALocal.setText(": "+agent.getsIp());//locate
            lbAServer.setText(": "+getIP()+":"+getPort());//"Server");
            lbATime.setText(": "+agent.getaTime());//" time");
            lbAStatus.setText(": "+agent.getaStatus());//" status");
            lbSName.setText(": "+agent.getsName());//" name");
            lbSIP.setText(": "+agent.getsIp());// location");
            lbSOS.setText(": "+agent.getsOs());//" window");
            lbSArch.setText(": "+agent.getsArch());//" architecture");
            lbSVersion.setText(": "+agent.getsVersion());//" version");
  }
}

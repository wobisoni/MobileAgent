package mobileagent;

import java.awt.*;  
import javax.swing.JFrame;  
  
public class Photos extends Canvas{  
      
    public void paint(Graphics g) {  
  
        Toolkit t=Toolkit.getDefaultToolkit();  
        Image i=t.getImage("F:\\picture\\hinh-nen-may-tinh.jpg");  
       g.drawImage(i, 0, 0,getWidth(), getHeight(), this);
          
    }  
        public static void main(String[] args) {  
        Photos m=new Photos();  
        JFrame f=new JFrame();  
        f.add(m);  
        f.setSize(800,800);  
        f.setVisible(true);  
    }  
  
}   
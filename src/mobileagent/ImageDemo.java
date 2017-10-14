package mobileagent;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
*
* @author Joeng Anh
*/
public class ImageDemo extends JFrame {

    public ImageDemo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);//chieu rong va chieu cao cua frame
        setVisible(true);
        setLocation(500, 300);
        setResizable(false);//cho mo rong frame bang chuot.true= cho phep.false khoa
        JLabel label = new JLabel();
        add(label);
        label.setSize(350, 250);
        System.out.println("x : " + label.getSize().width + "y : " + label.getSize().height);
        setPicture(label, "F:\\picture\\hinh-nen-may-tinh.jpg");

    }
    public  void setPicture(  JLabel label ,String filename ){
          try {
            BufferedImage image = ImageIO.read(new File(filename));
            int x =label.getSize().width;
            int y =label.getSize().height;
            int ix =image.getWidth();
            int iy =image.getHeight();

            int dx=0;
            int dy=0;
            if(x /y > ix /iy){
                dy=y;
                dx=dy*ix /iy;
            }else{
                dx=x;
                dy=dx*iy/ix;
            }

            ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, BufferedImage.SCALE_SMOOTH));
            label.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(ImageDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        ImageDemo a1 = new ImageDemo();
    }
}
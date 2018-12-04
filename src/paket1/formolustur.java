
package paket1;

import java.awt.AWTEventMulticaster;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class formolustur extends JFrame{

    private  int width=400;
    private  int height=400;
     JPanel panelim;
     JLabel video_goruntusu;
      JButton kucult_buyult;
      JButton cift_tik;
      JButton sag_tik;
    public formolustur() throws HeadlessException {
                                super("TEAMEYE");
                                getinit();
    }

    private void getinit() {
        try {
            panelim=new JPanel();
            getContentPane().add(panelim);
            panelim.setLayout(null);
            panelim.setAutoscrolls(true);
           panelim.setEnabled(true);
           panelim.setFocusable(Boolean.TRUE);
           panelim.setBounds(0, 0, width, height);
           panelim.setBorder(BorderFactory.createLineBorder(Color.yellow));
           
            video_goruntusu=new JLabel();
            video_goruntusu.setEnabled(true);
            video_goruntusu.setBounds(33, 10, 320,182);
            video_goruntusu.setFocusable(Boolean.TRUE);
            video_goruntusu.setToolTipText("Video Acilacaktir");
            video_goruntusu.setText("Merhaba");
            video_goruntusu.setVisible(Boolean.TRUE);
            video_goruntusu.setBorder(BorderFactory.createLineBorder(Color.red));
            panelim.add(video_goruntusu);
            
            
            ImageIcon image = new ImageIcon("C:\\Users\\TugceNur\\Documents\\NetBeansProjects\\teameyes\\src\\paket1\\cift_tik.jpg");
            JButton cift_tik = new JButton();
            cift_tik.setIcon(image);
            panelim.add(cift_tik);
            cift_tik.setBounds(35, 200, 40, 30);
            panelim.add(cift_tik);
            
            ImageIcon image2 = new ImageIcon("C:\\Users\\TugceNur\\Documents\\NetBeansProjects\\teameyes\\src\\paket1\\sag_tik.jpg");
            JButton sag_tik = new JButton();
            sag_tik.setIcon(image2);
            panelim.add(sag_tik);
            sag_tik.setBounds(100, 200, 40, 30);
            panelim.add(sag_tik);
            
            JCheckBox tek_tik=new JCheckBox();            
            tek_tik.setBounds(32, 250, 400, 100);
            tek_tik.setText("Sistemdeki program/klasörlerin tek tık ile açılmasını sağlar.");
            panelim.add(tek_tik);
            
            
            
          kucult_buyult=new JButton();
           kucult_buyult.setBounds(275, 200, 80, 20);
           kucult_buyult.setForeground(Color.black);
           kucult_buyult.setText("KÜÇÜLT");
           kucult_buyult.setToolTipText("EKRANI KUCULTMEYE VE BUYULTMEYE YARAR.");  
           kucult_buyult.setActionCommand("kucult");
        kucult_buyult.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
               if (e.getActionCommand().equals("kucult")) {
                   try {
                        int genislik,yukseklik;
                      genislik=width-200;
                      yukseklik=height-220;
                      panelim.setBounds(0,0,genislik,yukseklik);
                      video_goruntusu.setBounds(20, 10, 160, 120);
                      kucult_buyult.setBounds(60,140, 80, 20);
                      getContentPane().setPreferredSize(new Dimension(genislik,yukseklik));
                    formolustur.this.pack();
                    String actioncom=e.getActionCommand();
                    actioncom="buyult";
                   }
                   catch (Exception e1) {
                       JOptionPane.showMessageDialog(null, e1.getMessage(),"Hata var",JOptionPane.WARNING_MESSAGE);
                   }
                   
                    }
               //şimdide büyütme işlemini gerçekleştirmen gerekiyo videonun okunan frame ayarlanıyını
               //değiştirmedim dogrudan kuculturken verdiğin değerleri silip yerine eski değerleri
               // yeniden yazman lşazım ama en sonunda this.pack() demeyi unutma bu şu işe yarıyo frame yenilemeni sağlıyo
               //bunun altına else if gelicek
                }
               
            });
            kucult_buyult.setEnabled(Boolean.TRUE);
            kucult_buyult.setVisible(Boolean.TRUE);
            panelim.add(kucult_buyult);
            
            
              setSize(width, height);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           // setLocation(new Point(1220, 450));
            setAlwaysOnTop(true);
            setBackground(Color.white);
            setLocationRelativeTo(null);
            setResizable(Boolean.FALSE);
            setEnabled(true);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Hata mesajı",JOptionPane.ERROR_MESSAGE);
        }
    }
    public  void  iconata(Image resiImage){
        ImageIcon icon=new ImageIcon();
        icon.setImage(resiImage);
        video_goruntusu.setIcon(icon);
        panelim.revalidate();
        
    }
  
}

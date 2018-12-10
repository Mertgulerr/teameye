
package paket1;

import java.awt.AWTEventMulticaster;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import  java.net.URL;
import javax.swing.JCheckBox;

public class formolustur extends JFrame{

    private  int width=400;
    private  int height=300;
     JPanel panelim;
     JLabel video_goruntusu;
      JButton kucult_buyult;
      JButton cift_tik;
      JButton sag_tik;
      JCheckBox tek_tikla_sistem;
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
           panelim.setBackground(new Color(217, 242, 242));
         //  panelim.setBorder(BorderFactory.createLineBorder(Color.yellow));
           
            video_goruntusu=new JLabel();
            video_goruntusu.setEnabled(true);
            video_goruntusu.setBounds(33, 10, 320,182);
            video_goruntusu.setFocusable(Boolean.TRUE);
            //video_goruntusu.setToolTipText("Video Acilacaktir");
          //  video_goruntusu.setText("Merhaba");
            video_goruntusu.setVisible(Boolean.TRUE);
           // video_goruntusu.setBorder(BorderFactory.createLineBorder(Color.red));
            panelim.add(video_goruntusu);
 
          kucult_buyult=new JButton();
           kucult_buyult.setBounds(275, 200, 80, 30);
           kucult_buyult.setForeground(Color.BLACK);
           kucult_buyult.setText("KÜÇÜLT");
           kucult_buyult.setFont(new Font("Arial Black",Font.PLAIN,10));
           kucult_buyult.setToolTipText("EKRANI KUCULTMEYE VE BUYULTMEYE YARAR.");  
           kucult_buyult.setActionCommand("kucult");
        kucult_buyult.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
               if (e.getActionCommand().equals("kucult")) {
                   try {
                        int genislik,yukseklik;
                      genislik=width-200;
                      yukseklik=height-100;
                      panelim.setBounds(0,0,genislik,yukseklik);
                      video_goruntusu.setBounds(20, 10, 160, 140);
                      kucult_buyult.setBounds(60,155, 80, 30);
                      getContentPane().setPreferredSize(new Dimension(genislik,yukseklik));
                    formolustur.this.pack();
                    String actioncom=e.getActionCommand();
                    actioncom="buyult";
                    kucult_buyult.setActionCommand(actioncom);
                    kucult_buyult.setText("BÜYÜLT");
                   }
                   catch (Exception e1) {
                       JOptionPane.showMessageDialog(null, e1.getMessage(),"Hata var",JOptionPane.WARNING_MESSAGE);
                   }
                    }
               else if (e.getActionCommand().equals("buyult")) 
               {
                   try {
                       panelim.setBounds(0, 0, width, height);
                        video_goruntusu.setBounds(33, 10, 320,182);
                         kucult_buyult.setBounds(275, 200, 80, 30);
                           getContentPane().setPreferredSize(new Dimension(width,height));
                    formolustur.this.pack();
                    String actioncommad1=e.getActionCommand();
                    actioncommad1="kucult";
                    kucult_buyult.setActionCommand(actioncommad1);
                    kucult_buyult.setText("KÜÇÜLT");
                       
                   } catch (Exception e2) {
                        JOptionPane.showMessageDialog(null, e2.getMessage(),"Hata var",JOptionPane.WARNING_MESSAGE);
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
            
            java.net.URL imgUrl=getClass().getResource("cift_tik.jpg");
            ImageIcon icon=new ImageIcon(imgUrl);
            cift_tik=new JButton();
            cift_tik.setIcon(icon);
            cift_tik.setActionCommand("cift_tiklama butonu");
            cift_tik.setBounds(35, 200, 40, 30);
            cift_tik.setCursor(Cursor.getDefaultCursor());
            cift_tik.setEnabled(Boolean.TRUE);
            cift_tik.setToolTipText("Fare ile Cift Tıklama yapmak icin kullan");
            cift_tik.setFocusable(Boolean.TRUE);
            panelim.add(cift_tik);
            
            java.net.URL imgUrl1=getClass().getResource("sag_tik.jpg");
            ImageIcon icon1=new ImageIcon(imgUrl1);
            sag_tik=new JButton();
            sag_tik.setIcon(icon1);
            sag_tik.setActionCommand("sag_tiklama butonu");
            sag_tik.setBounds(100, 200, 40, 30);
            sag_tik.setCursor(Cursor.getDefaultCursor());
            sag_tik.setEnabled(Boolean.TRUE);
            sag_tik.setToolTipText("Fare ile sag tiklam yapmak icin kullan");
            sag_tik.setFocusable(Boolean.TRUE);
            panelim.add(sag_tik);
            
            tek_tikla_sistem=new JCheckBox();
            tek_tikla_sistem.setText("Sistemi Tek Tıklama ile Kullanmak İstermisiniz?");
            tek_tikla_sistem.setBounds(32, 250, 350, 20);
            tek_tikla_sistem.setEnabled(Boolean.TRUE);
            tek_tikla_sistem.setSelected(Boolean.FALSE);
            tek_tikla_sistem.setFocusable(Boolean.TRUE);
            tek_tikla_sistem.setFont(new Font("Arial Black",Font.PLAIN,12));
//            java.net.URL imgUrl2=getClass().getResource("configuration.png");
//            ImageIcon icon2=new ImageIcon(imgUrl2);
//            tek_tikla_sistem.setIcon(icon2);
            panelim.add(tek_tikla_sistem);
            
              setSize(width, height);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           // setLocation(new Point(1220, 450));
            setAlwaysOnTop(true);
            setBackground(Color.white);
            setLocationRelativeTo(null);
            setResizable(Boolean.FALSE);
            setEnabled(true);
            addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    
                }

                @Override
                public void keyPressed(KeyEvent event) {
                System.out.print(event.getKeyChar()+"basıldı");
                    }
               
                @Override
                public void keyReleased(KeyEvent e) {
                  
                }
            });
            
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

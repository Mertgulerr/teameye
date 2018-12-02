
package paket1;

import java.awt.AWTEventMulticaster;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class formolustur extends JFrame{

    private  final int width=400;
    private final int height=450;
     JPanel panelim;
     JLabel video_goruntusu;
      JButton kucult_buyult;
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
            video_goruntusu.setText("Merhaba Mert");
            video_goruntusu.setVisible(Boolean.TRUE);
            video_goruntusu.setBorder(BorderFactory.createLineBorder(Color.red));
            panelim.add(video_goruntusu);
            
          kucult_buyult=new JButton();
           kucult_buyult.setBounds(300, 200, 80, 20);
           kucult_buyult.setForeground(Color.red);
           kucult_buyult.setText("KÜÇÜLT");
           kucult_buyult.setToolTipText("EKRANI KUCULTMEYE VE BUYULTMEYE YARAR.");
      // bunu bir metot olarak yazabiliriz sınıfa yarın bakıcam
        /*   kucult_buyult.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        
                    } catch (Exception e) {
                        
                    }
                }
            });*/
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

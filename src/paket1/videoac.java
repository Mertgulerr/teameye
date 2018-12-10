
package paket1;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import static org.opencv.core.Mat.eye;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import static org.opencv.highgui.HighGui.waitKey;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;
import org.opencv.objdetect.Objdetect;
import paket1.formolustur;


public class videoac {
    
 
    
    public static void main(String[] args) {
         System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
         CascadeClassifier cascadefaceclasifer=new CascadeClassifier("C:\\Users\\Mert\\Desktop\\opencv\\opencv\\build\\etc\\haarcascades\\haarcascade_frontalface_default.xml");
         formolustur yeni_form=new formolustur();
         yeni_form.setVisible(true);
         int goruntubuyutmekatsayisi=8;
         Mat kameraverisi=new Mat();
         Mat yataysimetri=new Mat();
         Mat kesilenresim=new Mat();
          VideoCapture videodevice=new VideoCapture();
        videodevice.open(0);
        if (videodevice.isOpened()) {
           videodevice.set(Videoio.CAP_PROP_FRAME_WIDTH, 320.0);
                  videodevice.set(Videoio.CAP_PROP_FRAME_HEIGHT, 240.0);
                         videodevice.set(Videoio.CAP_PROP_BRIGHTNESS,50);
                                 videodevice.set(Videoio.CAP_PROP_CONTRAST, 50);
                                       videodevice.set(Videoio.CAP_PROP_SATURATION, 50);
                                              videodevice.set(Videoio.CAP_PROP_HUE, 50);
                                                       videodevice.set(Videoio.CAP_PROP_IOS_DEVICE_WHITEBALANCE, 4500);
                                                       
            while (Boolean.TRUE) 
            {        
                    videodevice.read(kameraverisi);
                    Core.flip(kameraverisi, yataysimetri, 1);
                    MatOfRect faces=new MatOfRect();
                    Rect dikdortgen=new Rect();
                    cascadefaceclasifer.detectMultiScale(yataysimetri, faces);
              for(Rect rect:faces.toArray())
              {
                  Imgproc.putText(yataysimetri, "", new Point(rect.x,rect.y), 1, 2, new Scalar(0, 0,255));
                  Imgproc.rectangle(yataysimetri, new Point(rect.x,rect.y),new Point(rect.x+rect.width, rect.y+rect.height),new Scalar(0,0,0),3);
                  dikdortgen.x=rect.x;
                  dikdortgen.y=rect.y;
                 dikdortgen.width=rect.x+rect.width;
                dikdortgen.height=rect.y+rect.height;
                  System.out.println( dikdortgen.x+"---"+ dikdortgen.y+"---"+ dikdortgen.width+"----"+ dikdortgen.height);
                 
                  try {
                      kesilenresim=yataysimetri.submat(dikdortgen.x, dikdortgen.width, dikdortgen.y, dikdortgen.height);
                      Imgproc.resize(kesilenresim,kesilenresim,new Size(320,182),goruntubuyutmekatsayisi,goruntubuyutmekatsayisi,Imgproc.INTER_LINEAR);
                  } 
                  catch (org.opencv.core.CvException e) {
                      System.out.println(e.getMessage());
                  }
              }
              yeni_form.iconata(donustur(kesilenresim)); 
                }
            
            kameraverisi=null;
            yataysimetri=null;
            kesilenresim=null;
            System.gc();
            
            }
    }
    
    private static  BufferedImage donustur(Mat veri){
        MatOfByte bytematversi=new MatOfByte();
        Imgcodecs.imencode(".png", veri, bytematversi);
        byte[] bytearray=bytematversi.toArray();
        BufferedImage goruntu=null;
        try {
            InputStream inputStream=new ByteArrayInputStream(bytearray);
            goruntu=ImageIO.read(inputStream);
        } catch (IOException e) {
            return null;
        }
        return  goruntu;
    }
}

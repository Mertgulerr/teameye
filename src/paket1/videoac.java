
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
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;
import paket1.formolustur;
public class videoac {

    public static void main(String[] args) {
         System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
         formolustur yeni_form=new formolustur();
         yeni_form.setVisible(true);
         Mat kameraverisi=new Mat();
         Mat yataysimetri=new Mat();
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
            while (true) {        
              Boolean kararBoolean=videodevice.read(kameraverisi);
                if (kararBoolean) {
                     Core.flip(kameraverisi, yataysimetri, 1);
              yeni_form.iconata(donustur(yataysimetri));
                }
            }
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

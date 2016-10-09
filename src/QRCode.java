import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class QRCode {
    public static void main(String[] args) throws IOException, WriterException, NotFoundException {
        Encode(true);
        Decode();
    }

    private static void Encode(boolean hasLogo) throws WriterException, IOException {
        int x = 500;
        int y = 500;
        int onColor = 0xFF008AC9;
        int offColor = 0xFFCAE7F7;
        String str = "http://xhstormr.tk/";
        String format = "png";
        File out = new File("D:/123.png");

        HashMap<EncodeHintType, Object> map = new HashMap<>();
        map.put(EncodeHintType.CHARACTER_SET, "utf-8");
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        map.put(EncodeHintType.MARGIN, 1);
        BitMatrix encode = new MultiFormatWriter().encode(str, BarcodeFormat.QR_CODE, x, y, map);

        if (hasLogo) {
            BufferedImage qrCode = MatrixToImageWriter.toBufferedImage(encode, new MatrixToImageConfig(onColor, offColor));
            Graphics2D graphics = qrCode.createGraphics();

            BufferedImage logo = ImageIO.read(new File("D:/logo1.png"));
            graphics.drawImage(logo, (qrCode.getWidth() - logo.getWidth()) / 2, (qrCode.getHeight() - logo.getHeight()) / 2, null);
            graphics.dispose();
            logo.flush();
            ImageIO.write(qrCode, format, out);
            return;
        }

        MatrixToImageWriter.writeToPath(encode, format, out.toPath(), new MatrixToImageConfig(onColor, offColor));
    }

    private static void Decode() throws IOException, NotFoundException {
        File in = new File("D:/123.png");
        BufferedImage qrCode = ImageIO.read(in);

        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(qrCode)));

        HashMap<DecodeHintType, Object> map = new HashMap<>();
        map.put(DecodeHintType.CHARACTER_SET, "utf-8");
        Result decode = new MultiFormatReader().decode(binaryBitmap, map);

        System.out.println(decode);
    }
}

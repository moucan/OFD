package com.ofdbox.convertor;


import com.ofdbox.convertor.img.Ofd2Img;
import com.ofdbox.core.OFDReader;
import com.ofdbox.core.model.OFD;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test1 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        OFDReader reader = new OFDReader();
        OFD ofd = reader.read(new File("C:\\Users\\LENOVO\\Desktop\\chunks\\1.ofd"));
        Ofd2Img ofd2Img = new Ofd2Img();
        //转图片以页为单位
        BufferedImage image = ofd2Img.toImage(ofd.getDocuments().get(0).getPages().get(0), 20);
        ImageIO.write(image, "JPEG", new FileOutputStream("C:\\Users\\LENOVO\\Desktop\\chunks\\3.jpg"));
        long use = System.currentTimeMillis()-start;
        System.out.println("耗时："+use);
    }
}

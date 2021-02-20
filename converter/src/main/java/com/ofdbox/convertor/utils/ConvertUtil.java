package com.ofdbox.convertor.utils;

import com.ofdbox.convertor.img.Ofd2Img;
import com.ofdbox.core.OFDReader;
import com.ofdbox.core.model.OFD;
import com.ofdbox.core.model.page.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Slf4j
public class ConvertUtil {
    /**
     * 将ofd文件解析为图片
     * @param ofdPath ofd文件文件地址
     * @param imageFolder 解压图片地址
     */
    public static void decodeImage(String ofdPath,String imageFolder) throws IOException {
        OFDReader reader = new OFDReader();
        reader.getConfig().setValid(false);
        OFD ofd = reader.read(new File(ofdPath));
        Ofd2Img ofd2Img = new Ofd2Img();
        ofd2Img.getConfig().setDrawBoundary(false);
        int i = 1;
        for (Page page : ofd.getDocuments().get(0).getPages()) {
            BufferedImage image = ofd2Img.toImage(page, 30);
            try (FileOutputStream fileOutputStream = new FileOutputStream(new File(imageFolder, i + ".jpg"))){
                ImageIO.write(image, "JPEG", fileOutputStream);
                i++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testByte(String ofdPath) throws IOException {
        byte[] imageStream = getImageStream(ofdPath);
        String str1 = new String(imageStream, "ISO-8859-1");

        String str = new String(imageStream, "UTF-8");
        byte[] bytes = str.getBytes("UTF-8");
        String str7 = new String(imageStream, "ISO-8859-1");
        byte[] bytes6 = str1.getBytes("UTF-8");
        String str3 = new String(bytes6, "UTF-8");
        boolean e = str1.equals(str3);
        System.out.println("对比："+ e);
        byte[] bytes5 = str1.getBytes("ISO-8859-1");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IOUtils.copy(byteArrayInputStream, byteArrayOutputStream);

        boolean b1 = str.equals(str1);
        System.out.println("字符串对比："+ b1);
        System.out.println(str);
        System.out.println(str1);
        boolean b = Arrays.equals(imageStream, bytes5);
        System.out.println("是否相等："+b);

//        for (int i = 0; i < imageStream.length; i++) {
//            if (imageStream[i] != bytes[i]){
//                System.out.println(i+ "存在不同："+ imageStream[i]);
//            }
//        }

        String s2 = new String(imageStream);
        byte[] bytes2 = s2.getBytes();

        String base64 = Base64.getEncoder().encodeToString(imageStream);
        byte[] decode = Base64.getDecoder().decode(base64);

        List<String> list = decodeImage(imageStream);
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * 将ofd文件解析为图片
     * @param ofdPath ofd文件文件地址
     * @return base64返回数据
     */
    public static List<String> decodeImage(String ofdPath) throws IOException {
        OFDReader reader = new OFDReader();
        reader.getConfig().setValid(false);
        OFD ofd = reader.read(new File(ofdPath));
        return getResultByOFD(ofd);
    }

    /**
     * 将ofd文件解析为图片
     * @param fileByte 文件二进制流
     * @return base64返回数据
     */
    public static List<String> decodeImage(byte[] fileByte) throws IOException {
        OFDReader reader = new OFDReader();
        reader.getConfig().setValid(false);
        OFD ofd = reader.read(fileByte);
        return getResultByOFD(ofd);
    }

    private static List<String> getResultByOFD(OFD ofd){
        List<String> result = new ArrayList<>();
        Ofd2Img ofd2Img = new Ofd2Img();
        ofd2Img.getConfig().setDrawBoundary(false);
        for (Page page : ofd.getDocuments().get(0).getPages()) {
            BufferedImage image = ofd2Img.toImage(page, 30);
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()){
                ImageIO.write(image, "JPEG", outputStream);
                String base64 = Base64.getEncoder().encodeToString(outputStream.toByteArray());
                result.add(base64);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static byte[] getImageStream(String imageUrl) {

        byte[] buffer = null;
        File file = new File(imageUrl);
        FileInputStream fis;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            fis = new FileInputStream(file);
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public static String getString(String imageUrl) {
        byte[] buffer = null;
        File file = new File(imageUrl);
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(file)){
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            buffer = bos.toByteArray();
            return new String(buffer, "ISO-8859-1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

package com.ofdbox;

import com.ofdbox.convertor.utils.ConvertUtil;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.File;
import java.io.IOException;

public class Test2 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
//        File file = new File("C:\\Users\\LENOVO\\Desktop\\chunks\\1.ofd");
//        new ZipFile(file).extractAll("C:\\Users\\LENOVO\\Desktop\\chunks\\test");
        ConvertUtil.decodeImage("C:\\Users\\LENOVO\\Desktop\\chunks\\a.ofd","C:\\Users\\LENOVO\\Desktop\\chunks\\2");
//        ConvertUtil.testByte("C:\\Users\\LENOVO\\Desktop\\chunks\\a.ofd");
        System.out.println("耗时："+(System.currentTimeMillis()-start));
    }
}

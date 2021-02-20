package com.ofdbox.convertor.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 基于NIO方式执行zip的相关IO操作
 * @author moucan
 */
public class ZipNioUtil {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        packZip("C:\\Users\\LENOVO\\Desktop\\chunks\\test.zip","C:\\Users\\LENOVO\\Desktop\\chunks\\test");
        System.out.println("耗时："+ (System.currentTimeMillis() - start));
    }

    private static void packZip(String zipPath, String folderPath) {
        File zipFile = new File(zipPath);
        File sourceFile = new File(folderPath);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             WritableByteChannel writableByteChannel = Channels.newChannel(zipOut)) {
            compressZip(sourceFile, zipOut, writableByteChannel, sourceFile.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用NIO方式进行递归打包
     * @param sourceFile 传入文件
     * @param zipOut 输出流
     * @param writableByteChannel NIO Channel
     * @param name 当前递归名称
     * @throws IOException 异常
     */
    private static void compressZip(File sourceFile, ZipOutputStream zipOut, WritableByteChannel writableByteChannel, String name) throws IOException {
        if (sourceFile.isFile()) {
            zipOut.putNextEntry(new ZipEntry(name));
            try (FileChannel fileChannel = new FileInputStream(sourceFile).getChannel()){
                fileChannel.transferTo(0, sourceFile.length(), writableByteChannel);
            }
        } else {
            File[] listFiles = sourceFile.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                zipOut.putNextEntry(new ZipEntry(name + '/'));
            } else {
                for (File file : listFiles) {
                    compressZip(file, zipOut, writableByteChannel, name + '/' + file.getName());
                }
            }
        }
    }

}

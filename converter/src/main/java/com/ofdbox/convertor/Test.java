package com.ofdbox.convertor;

import org.ofdrw.converter.ConvertHelper;
import org.ofdrw.converter.GeneralConvertException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

    public static void main(String[] args) {
        // 1. 文件输入路径
        Path src = Paths.get("C:\\Users\\LENOVO\\Desktop\\chunks\\1.ofd");
        // 2. 转换后文件输出位置
        Path dst = Paths.get("C:\\Users\\LENOVO\\Desktop\\chunks\\1.pdf");
        try {
            // 3. OFD转换PDF
            ConvertHelper.toPdf(src, dst);
            System.out.println("生成文档位置: " + dst.toAbsolutePath());
        } catch (GeneralConvertException e) {
            // GeneralConvertException 类型错误表明转换过程中发生异常
            e.printStackTrace();
        }
    }
}

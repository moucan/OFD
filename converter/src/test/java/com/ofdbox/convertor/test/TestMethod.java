package com.ofdbox.convertor.test;

import com.ofdbox.convertor.utils.ConvertUtil;

import java.io.IOException;

/**
 * @description:
 * @author: 张家尧
 * @create: 2020/10/28 09:45
 */
public class TestMethod {
    public static void main(String[] args) throws IOException {
        ConvertUtil.decodeImage("C:\\Users\\LENOVO\\Desktop\\chunks\\1.ofd","C:\\Users\\LENOVO\\Desktop\\chunks");
//        List<String> list = ConvertUtil.decodeImage("C:\\Users\\LENOVO\\Desktop\\chunks\\1.ofd");
        System.out.println();
    }
}
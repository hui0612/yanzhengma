package com.yh.yangzhengma;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class VerificationCode {
    public String verificationCode(int width, int height, HttpServletResponse resp){
        //创建一个对象，在内存中代表一个图片
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //美化图片
        //2.1填充背景
        Graphics g = img.getGraphics();
        g.setColor(Color.pink); //设置画笔颜色
        g.fillRect(0,0,width,height);//填充矩形

        //2.2画边框
        g.setColor(Color.blue); //设置画笔颜色
        g.drawRect(0,0,width-1,height-1);

        //2.3写字
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789";
        StringBuffer sbuffer = new StringBuffer();
        String s1 = String.valueOf(sbuffer);
        Random ran = new Random();
        for (int i = 1; i <= 5; i++) {
            g.setColor(new Color(ran.nextInt(100),ran.nextInt(100),ran.nextInt(255)));
            int index = ran.nextInt(s.length());
            char ch = s.charAt(index);//获取字符
            sbuffer.append(ch);
            g.drawString(ch+"",width/6*i,height/2);//写字符
        }
        //添加干扰线
        g.setColor(Color.GREEN);
        for (int i = 0; i <10 ; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }
        //将图片输出出来
        try {
            ImageIO.write(img,"jpg",resp.getOutputStream());
        } catch (IOException e) {

        }
        return s1;
    }
}

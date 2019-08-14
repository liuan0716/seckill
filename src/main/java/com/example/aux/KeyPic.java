package com.example.aux;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

public class KeyPic {

    private static byte[] image;

    private static String createCode(Integer codeLength) {
        String chs="abcdefghijklmnopqrstuvwxyz"+"ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789";
        char[] code=new char[codeLength];
        Random r=new Random();
        for(int i=0;i<code.length;i++) {
            int index=r.nextInt(chs.length());
            code[i]=chs.charAt(index);
        }
        return new String(code);
    }

    public static byte[] createImage() throws IOException {
        String code=createCode(4);
        //创建图片,100*40个像素,一个像素3个byte,（b,g,r）
        BufferedImage img=new BufferedImage(120, 40, BufferedImage.TYPE_3BYTE_BGR);
        //设置每个像素点的颜色
        Random r=new Random();
        for(int i=0;i<500;i++) {
            img.setRGB(r.nextInt(img.getWidth()), r.nextInt(img.getHeight()),r.nextInt(0xffffff));
        }
        //利用api绘制验证码字符串
        Graphics2D g=img.createGraphics();
        Color c=new Color(r.nextInt(0xffffff));
        g.setColor(c);
        g.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,30));
        g.drawString(code,20,30);
        //画线
        for(int i=0;i<8;i++) {
            g.drawLine(r.nextInt(img.getWidth()), r.nextInt(img.getHeight()), r.nextInt(img.getWidth()), r.nextInt(img.getHeight()));
        }
        //建立输出管道
        ByteArrayOutputStream bao=new ByteArrayOutputStream();
        //将图片对象编码为png数据
        ImageIO.write(img, "png", bao);
        //将ByteArrayOutputStream流转为字节数组
        image=bao.toByteArray();
        return image;
    }

}

package com.fest.exam.img;

import org.apache.commons.lang3.SystemUtils;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.core.IdentifyCmd;
import org.im4java.process.ArrayListOutputConsumer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 图片处理工具类
 * window电脑需安装  GraphicsMagick
 * Created by yu.hb on 2019-09-03
 */
public class ImagesUtils {
    private static String imageMagickPath = SystemUtils.getEnvironmentVariable("imageMagickPath","C:\\Program Files\\GraphicsMagick-1.3.33-Q8");

    private static boolean is_windows = SystemUtils.IS_OS_WINDOWS;

    private static final String suffix_jpg = ".jpg";
    private static final long limitSize = 500 * 1024; // 500kb




    /**
     * 压缩图片 （不改变原图尺寸）
     * @param sourcePath 原图路径
     * @param targetPath 压缩图路径
     * @return 返回压缩图路径
     * @throws Exception
     */
    public static String compress(String sourcePath, String targetPath) throws Exception {
        long size = getSize(sourcePath);
        double q = getAccuracy(size);
        return zoomImage2(getWidth(sourcePath), getHeight(sourcePath), sourcePath,  targetPath, 1, (q*100)+"");
    }

    private static double getAccuracy(long size) {
        double accuracy;
        if (size < 900) {
            accuracy = 0.85;
        } else if (size < 2047) {
            accuracy = 0.6;
        } else if (size < 3275) {
            accuracy = 0.44;
        } else {
            accuracy = 0.4;
        }
        return accuracy;
    }
    /**
     *
     * @param width   缩放后的图片宽度
     * @param height  缩放后的图片高度
     * @param srcPath 源图片路径
     * @param newPath 缩放后图片的路径
     * @param type    1大小       2比例
     * @param quality 图片质量 1-100
     * @return
     * @throws Exception
     */
    public static String zoomImage2(int width, int height, String srcPath, String newPath, int type, String quality) throws Exception {
        IMOperation op = new IMOperation();
        op.addImage();
        String raw = "";
        if (type == 1) {  // 按像素大小
            raw = width + "x" + height + "^";
        } else {          // 按像素百分比
            raw = width + "%x" + height + "%";
        }
        ConvertCmd cmd = new ConvertCmd(true);
        op.addRawArgs("-sample", raw);
        op.addRawArgs("+profile", "*");// 去除Exif信息，可减小文件大小
        if ((quality != null && !quality.equals(""))) {
            op.addRawArgs("-quality", quality);
        }
        op.addImage();


        if (is_windows) {
            cmd.setSearchPath(imageMagickPath);
        }

        cmd.run(op, srcPath, newPath);
        return newPath;
    }

    public static int getWidth(String imagePath) throws InterruptedException, IOException, IM4JavaException {
        IMOperation op = new IMOperation();
        op.format("%w"); // 设置获取宽度参数
        op.addImage(1);
        return excuteCusotmerOp(op, imagePath);
    }

    public static long getSize(String imagePath) {
        return new File(imagePath).length();
    }



    private static Integer excuteCusotmerOp(IMOperation op,String imagePath) throws InterruptedException, IOException, IM4JavaException {
            IdentifyCmd identifyCmd = new IdentifyCmd(true);
            ArrayListOutputConsumer output = new ArrayListOutputConsumer();
            identifyCmd.setOutputConsumer(output);
            if (is_windows) {
                identifyCmd.setSearchPath(imageMagickPath);
            }
            identifyCmd.run(op, imagePath);
            ArrayList<String> cmdOutput = output.getOutput();
            assert cmdOutput.size() == 1;
            return Integer.parseInt(cmdOutput.get(0));
    }

    public static int getHeight(String imagePath) throws InterruptedException, IOException, IM4JavaException {
        IMOperation op = new IMOperation();
        op.format("%h"); // 设置获取高度参数
        op.addImage(1);
        return excuteCusotmerOp(op, imagePath);
    }

    public static void main(String[] args) {
        try {
            compress("D:\\bb.jpg","D:\\cc.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

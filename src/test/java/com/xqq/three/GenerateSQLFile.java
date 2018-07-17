package com.xqq.three;

import java.io.*;
import java.util.Random;

/**
 * @author xuqiangqiang
 * @Date: 2018/6/20 16:53
 * @Description:
 */
public class GenerateSQLFile {
   public static void main(String[] args) {
        try {
            File file = new File("d:" + File.separator + "test.sql");
            OutputStream out = new FileOutputStream(file, true); // 声明字节输出流

            // 通过子类实例化
//            int i = 1;
//            for (int j = 1; j <= 10000; j++) {
//                for (int k = 1; k <= 100; k++) {
//                    int temp = (int) (50 * Math.random() + 50);
//                    String str = "insert into  SC(sc_id,s_id,c_id,score) values(" + i++ + "," + j + "," + k + "," + temp + ");\r\n"; // 要输出的信息
//                    byte b[] = str.getBytes(); // 将String变为byte数组
//                    out.write(b); // 写入数据
//                }
//            }
            for (int i = 1; i <= 100; i++) {
                String str = "insert into  course(c_id,name) values(" + i + ",'课程" + i + "');\r\n"; // 要输出的信息
                byte b[] = str.getBytes(); // 将String变为byte数组
                out.write(b); // 写入数据
            }

            out.close(); // 关闭
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

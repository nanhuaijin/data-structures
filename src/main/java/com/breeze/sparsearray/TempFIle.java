package com.breeze.sparsearray;


import org.apache.http.entity.ContentType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author breeze
 * @date 2020/3/19
 *
 * file创建临时文件
 */
public class TempFIle {
    public static void main(String[] args) {

        //1.创建要变成临时文件的string，以及临时文件的名称
        String tempFileName = "ISSUE - 1456";
        String fileContent = "key = 1\nkey = 2\nkey = 3";
        File tempFile = null;
        FileOutputStream fos = null;
        FileInputStream fis = null;

        try {
            tempFile = File.createTempFile(tempFileName, ".txt");

            System.out.println("创建的临时文件的路径：" + tempFile.getCanonicalPath());
            fos = new FileOutputStream(tempFile);
            fos.write(fileContent.getBytes());

            fis = new FileInputStream(tempFile);

            MultipartFile multipartFile = new MockMultipartFile(tempFileName, tempFile.getName(),
                    ContentType.APPLICATION_OCTET_STREAM.toString(), fis);

            System.out.println(multipartFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            tempFile.deleteOnExit();
        }

    }
}

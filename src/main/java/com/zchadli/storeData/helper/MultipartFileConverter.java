package com.zchadli.storeData.helper;

import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

public class MultipartFileConverter {
    public static MultipartFile convert(String path, String fileName) throws IOException {
        File file = new File(path);
        byte[] fileContent = Files.readAllBytes(file.toPath());

        MultipartFile multipartFile = new MockMultipartFile(
                "file",
                fileName,
                "text/plain",
                fileContent
        );
        return multipartFile;
    }

    public static void downloadUsingStream(String urlStr, String file) throws IOException{
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1) {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

}
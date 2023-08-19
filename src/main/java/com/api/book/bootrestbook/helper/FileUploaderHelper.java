package com.api.book.bootrestbook.helper;

import java.io.File;

import java.nio.file.Files;

import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploaderHelper {
    public final String UPLOAD_DIR = "F:\\Java\\BootApi\\bootrestbook\\src\\main\\resources\\static\\image";

    public boolean UploadFile(MultipartFile multipartFile) {
        boolean f = false;
        try {
            // InputStream is = multipartFilef.getInputStream();
            // byte[] data = new byte[is.available()];
            // is.read(data);

            // //write opton

            // FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator +
            // multipartFilef.getOriginalFilename());
            // fos.write(data);
            // fos.close();
            Files.copy(multipartFile.getInputStream(),
                    Paths.get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;

    }

}

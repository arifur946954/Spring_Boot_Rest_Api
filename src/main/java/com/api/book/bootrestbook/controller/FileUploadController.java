package com.api.book.bootrestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.bootrestbook.helper.FileUploaderHelper;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploaderHelper fileUploaderHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> UploadFile(@RequestParam("file") MultipartFile file) {

        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file");

            }

            // if (!file.getContentType().equals("image/jpeg"))

            // {

            // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only
            // uplod jpeg file");
            // }
            boolean f = fileUploaderHelper.UploadFile(file);
            if (f) {
                // return ResponseEntity.ok("Upload file successfully ");
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/")
                        .path(file.getOriginalFilename()).toUriString());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong pls try it again");
    }

}

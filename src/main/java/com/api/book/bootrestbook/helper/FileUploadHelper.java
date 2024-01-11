package com.api.book.bootrestbook.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    //single / will get converted to \\ this.
    //In this folder our file will get uploaded. 
    public final String UPLOAD_DIR="E:\\Rest_Api\\bootrestbook\\src\\main\\resources\\static\\image";

    public boolean uploadFile(MultipartFile multipartFile){
        boolean f=false;
        try{
            //1st way to do this.
            //Doing this with the help of stream API which is in io package 
            // InputStream is = multipartFile.getInputStream();
            // byte data[]=new byte[is.available()];

            // //to read data
            // is.read(data);

            // //write
            // FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
            // fos.write(data);
            // fos.flush();
            // fos.close();
            // f=true;

            //2nd way of doing this.
            //we can do this with the help of NIO package.
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            f=true;
        }catch(Exception e){
            e.printStackTrace();
        }

        return f;
    }
}

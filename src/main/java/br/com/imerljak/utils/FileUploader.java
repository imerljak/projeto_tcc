package br.com.imerljak.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUploader {
    public static void save(MultipartFile[] files, UploadPath uploadPath) {

        List<MultipartFile> saved = new ArrayList<>();
        try {
            for (MultipartFile file : files) {
                save(file, uploadPath);
                saved.add(file);
            }
        } catch (IOException e) {
            saved.forEach(file -> remove(file, uploadPath));

            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private static boolean remove(MultipartFile multipartFile, UploadPath uploadPath) {
        final File newFile = new File(uploadPath.getPath() + multipartFile.getOriginalFilename());
        return newFile.delete();
    }

    private static void save(MultipartFile multipartFile, UploadPath uploadPath) throws IOException {
        final File newFile = new File(uploadPath.getPath() + multipartFile.getOriginalFilename());
        multipartFile.transferTo(newFile);
    }
}

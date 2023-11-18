package com.example.updownfile;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
@RequiredArgsConstructor
@Service
public class FileDownloadService {
    public InputStreamResource resource (String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        return new InputStreamResource(new FileInputStream(file));
    }
}
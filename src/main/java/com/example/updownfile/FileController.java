package com.example.updownfile;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequiredArgsConstructor
public class FileController {
    @Autowired
    private final FileDownloadService fileDownloadService;

    @GetMapping("/downloadPDF")
    public ResponseEntity<InputStreamResource> downloadPDF() throws IOException {
        // Đường dẫn tới file PDF trên server
        String filePath = "Innovation_book.pdf";

        File file = new File(filePath);
//        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        InputStreamResource resource = fileDownloadService.resource(filePath);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getName());

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(resource);
    }
}

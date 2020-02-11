package com.lvov.home;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class UploadController {
    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "text/html")
    @ResponseStatus(value= HttpStatus.OK)
    public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap ) throws IOException {
        System.out.println("upload: " + file.getOriginalFilename() + '\n');
        modelMap.addAttribute("file", file);
        byte [] bytes = file.getBytes();
        BufferedOutputStream stream =
                new BufferedOutputStream(new FileOutputStream(new File("C:\\data\\" + file.getOriginalFilename())));
        stream.write(bytes);
        stream.close();
        return "home/upload";
    }
}

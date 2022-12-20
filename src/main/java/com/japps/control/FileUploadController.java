package com.japps.control;

import com.japps.service.FileUploadService;
import com.japps.utils.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResultBean upload(String username, String path, MultipartFile file) {
        String res = fileUploadService.saveFile(username, path, file);
        if (res != null) {
            return new ResultBean<>(new Exception(res));
        }
        return new ResultBean<>();
    }

}

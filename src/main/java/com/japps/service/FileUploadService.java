package com.japps.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    /**
     * 保存文件，正确返回空，错误返回错误信息
     *
     * @param username 用户名
     * @param path     路径
     * @param file     文件
     * @return {@link String}
     */
    String saveFile(String username, String path, MultipartFile file);
}

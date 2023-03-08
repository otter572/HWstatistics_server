package com.japps.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    /**
     * 保存文件，返回缓存文件阈值
     *
     * @param username 用户名
     * @param path     路径
     * @param file     文件
     * @return int
     * @throws Exception 异常
     */
    int saveFile(String username, String path, MultipartFile file) throws Exception;
}

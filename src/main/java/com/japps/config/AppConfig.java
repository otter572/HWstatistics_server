package com.japps.config;

import com.japps.constants.FileConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class AppConfig {

    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setResolveLazily(true);
        // 文件放入临时文件夹的最小大小限制，低于此值，则保存在内存中，如高于此值，则生成硬盘上的临时文件
        // 10MB
        resolver.setMaxInMemorySize(10*FileConstant.MB);
        // 100MB
        resolver.setMaxUploadSize(100*FileConstant.MB);
        return resolver;
    }
}

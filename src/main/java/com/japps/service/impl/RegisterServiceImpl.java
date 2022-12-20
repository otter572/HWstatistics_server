package com.japps.service.impl;

import com.japps.model.dto.UserDto;
import com.japps.repository.UserRepository;
import com.japps.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {

    @Resource
    private UserRepository userRepository;

    @Override
    public String register(UserDto userDto) throws Exception {
        String username = userDto.getUsername();
        // 相同用户名校验
        if (userRepository.findUserByUsername(userDto.getUsername()) != null) {
            log.info("用户 {} 注册失败：用户名已存在", username);
            throw new Exception("用户名已存在");
        }
        // 添加新用户
        String id = userRepository.insertOneUser(userDto);
        if (id == null) {
            log.info("用户 {} 注册失败：数据库插入失败", username);
            throw new Exception("数据库插入失败");
        }
        log.info("用户 {} 注册成功，id为 {} ", username, id);
        return id;
    }
}

package com.japps.service.impl;

import com.japps.model.dto.UserDto;
import com.japps.model.entity.User;
import com.japps.repository.UserRepository;
import com.japps.service.UserService;
import com.japps.utils.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

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

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAllUser();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = new UserDto(user);
            String recentLogUpdateTime = userDto.getRecentLogUpdateTime();
            if ("0".equals(recentLogUpdateTime)) {
                userDto.setFromLastUpdate("user never upload");
            }
            else {
                userDto.setFromLastUpdate(TimeUtil.countDiffToPresent(recentLogUpdateTime));
            }
            String infoFileUpdateTime = userDto.getInfoFileUpdateTime();
            if ("0".equals(infoFileUpdateTime)) {
                userDto.setInfoFileUpdateTime("user never upload");
            }
            else {
                userDto.setInfoFileUpdateTime(TimeUtil.countDiffToPresent(infoFileUpdateTime));
            }
            userDtos.add(userDto);
        }
        // 排序返回
        // 1. info文件更新时间越近，排越上面
        // 2. 最近文件时间越晚，排越上面
        userDtos.sort((o1, o2) -> {
            String info1 = o1.getInfoFileUpdateTime();
            String info2 = o2.getInfoFileUpdateTime();
            if (info1.equals(info2)) {
                String update1 = o1.getFromLastUpdate();
                String update2 = o2.getFromLastUpdate();
                return TimeUtil.diffToHours(update1) - TimeUtil.diffToHours(update2);
            }
            return TimeUtil.diffToHours(info1) - TimeUtil.diffToHours(info2);
        });
        return userDtos;
    }

}

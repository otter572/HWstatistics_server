package com.japps.service;

import com.japps.model.dto.UserDto;

import java.util.List;

public interface UserService {

    /**
     * 新用户注册，返回用户id
     *
     * @param userDto 用户dto
     * @return {@link String}
     * @throws Exception 注册失败信息
     */
    String register(UserDto userDto) throws Exception;

    /**
     * 获得所有用户的信息
     *
     * @return {@link UserDto[]}
     */
    List<UserDto> getUsers();

    /**
     * 删除用户
     *
     * @param username 用户名
     * @return {@link String}
     * @throws Exception 异常
     */
    String deleteUser(String username) throws Exception;
}

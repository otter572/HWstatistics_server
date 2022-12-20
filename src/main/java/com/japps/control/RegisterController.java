package com.japps.control;

import com.japps.model.dto.UserDto;
import com.japps.model.vo.UserVo;
import com.japps.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.japps.utils.ResultBean;


@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;


    /**
     * 新用户注册
     *
     * @param userVo
     * @return {@link ResultBean}<{@link String}>
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultBean<String> register(@RequestBody UserVo userVo) {
        UserDto userDto = new UserDto(userVo);
        try {
            registerService.register(userDto);
        } catch (Exception e) {
            return new ResultBean<>(e);
        }
        return new ResultBean();
    }
}

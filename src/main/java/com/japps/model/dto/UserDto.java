package com.japps.model.dto;

import com.japps.model.vo.UserVo;
import lombok.Data;

@Data
public class UserDto {

    private String username;

    private String telephone;

    private String occupation;

    private String device;

    private String startFrom;

    public UserDto(UserVo userVo) {
        this.username = userVo.getUsername();
        this.telephone = userVo.getTelephone();
        this.occupation = userVo.getOccupation();
        this.device = userVo.getDevice();
        this.startFrom = userVo.getStartFrom();
    }
}

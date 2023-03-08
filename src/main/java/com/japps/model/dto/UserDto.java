package com.japps.model.dto;

import com.japps.model.entity.User;
import lombok.Data;

@Data
public class UserDto {

    private String username;

    private String recentLogUpdateTime;

    private String telephone;

    private String occupation;

    private String device;

    private String startFrom;

    private String fromLastUpdate;

    public UserDto(User user) {
        this.username = user.getUsername();
        this.recentLogUpdateTime = user.getRecent_log_update_time();
        this.telephone = user.getTelephone();
        this.occupation = user.getOccupation();
        this.device = user.getDevice();
        this.startFrom = user.getStart_from();
    }

}

package com.japps.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo implements Serializable {

    private String username;

    private String telephone;

    private String recentLogUpdateTime;

    @JsonIgnore
    private String occupation;

    @JsonIgnore
    private String device;

    @JsonIgnore
    private String startFrom;

    private String fromLastUpdate;

}

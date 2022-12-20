package com.japps.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserVo {

    private String username;

    private String telephone;

    private String occupation;

    private String device;

    private String startFrom;

}

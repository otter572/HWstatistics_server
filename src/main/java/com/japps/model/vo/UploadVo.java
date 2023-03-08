package com.japps.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UploadVo implements Serializable {

    private int pa_threshold;

}

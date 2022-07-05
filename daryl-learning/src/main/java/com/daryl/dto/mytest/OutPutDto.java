package com.daryl.dto.mytest;

import lombok.Data;

import java.util.HashMap;

/**
 * @author wl
 * @date 2022-06-29
 */
@Data
public class OutPutDto {
    private String name;

    private String identifier;

    private HashMap<String,Object> dataType;
}

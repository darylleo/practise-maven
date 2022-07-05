package com.daryl.dto.mytest;

import lombok.Data;

import java.util.HashMap;

/**
 * @author wl
 * @date 2022-06-29
 */
@Data
public class PropertyTypeDto {

    private String accessMode;

    private String desc;

    private String functionMode;

    private String functionType;

    private String identifier;

    private String name;

    private HashMap<String, Object> dataType;
}

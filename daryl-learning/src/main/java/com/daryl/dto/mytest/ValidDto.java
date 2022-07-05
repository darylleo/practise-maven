package com.daryl.dto.mytest;

import lombok.Data;

import java.util.HashMap;

/**
 * @author wl
 * @date 2022-06-29
 */
@Data
public class ValidDto {

    private String validation;

    private HashMap<String,Object> parameters;
}

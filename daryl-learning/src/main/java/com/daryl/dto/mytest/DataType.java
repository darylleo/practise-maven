package com.daryl.dto.mytest;

import lombok.Data;

import java.util.HashMap;

/**
 * @author wl
 * @date 2022-06-29
 */
@Data
public class DataType {

    private String type;

    private HashMap<String,Object> specs;
}

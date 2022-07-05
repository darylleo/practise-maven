package com.daryl.dto.mytest;

import lombok.Data;

import java.util.List;

/**
 * @author wl
 * @date 2022-06-29
 */
@Data
public class ServiceTypeDto {

    private String callType;

    private String functionMode;

    private String functionType;

    private String identifier;

    private String name;

    private List<InputDto> input;

    private List<OutPutDto> output;
}

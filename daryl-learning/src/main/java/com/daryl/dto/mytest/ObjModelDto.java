package com.daryl.dto.mytest;

import lombok.Data;

import java.util.List;

/**
 * @author wl
 * @date 2022-06-29
 */
@Data
public class ObjModelDto {

    private String pId;

    private String version;

    private List<EventTypeDto> events;

    private List<PropertyTypeDto> properties;

    private List<ServiceTypeDto> services;
}

package com.daryl.dto.mytest;

import lombok.Data;

import java.util.List;

/**
 * @author wl
 * @date 2022-06-29
 */
@Data
public class EventTypeDto {
    private String desc;

    private String eventType;

    private String functionMode;

    private String functionType;

    private String identifier;

    private String name;

    private List<OutPutData> outputData;
}

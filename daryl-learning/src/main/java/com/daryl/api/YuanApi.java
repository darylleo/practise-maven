package com.daryl.api;

import cn.hutool.json.JSONUtil;
import com.daryl.constant.DataTypeEnum;
import com.daryl.dto.mytest.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wl
 * @date 2022-06-29
 */
@RestController
@RequestMapping("/api/yuan")
public class YuanApi {

    @RequestMapping("/test1")
    public Object test1(@RequestBody ObjModelDto dto) {
        //pid
        String pid = dto.getPId();

        //version
        String version = dto.getVersion();
        List<MyValidDto> result = new ArrayList<>();
        //event
        List<EventTypeDto> events = dto.getEvents();
        for (EventTypeDto event : events) {
            List<OutPutData> outPutDataList = event.getOutputData();
            OutPutData outPutData = new OutPutData();
            if (!outPutDataList.isEmpty()) {
                outPutData = outPutDataList.get(0);
            }
            HashMap<String, Object> dataMap = outPutData.getDataType();
            result = getResult(dataMap, result, event.getIdentifier());
        }

        //properties
        List<PropertyTypeDto> properties = dto.getProperties();
        for (PropertyTypeDto property : properties) {
            HashMap<String, Object> propertyDataMap = property.getDataType();
            result = getResult(propertyDataMap, result, property.getIdentifier());
        }

        //services
        List<ServiceTypeDto> services = dto.getServices();
        for (ServiceTypeDto service : services) {
            List<InputDto> inputList = service.getInput();
            List<OutPutDto> outputList = service.getOutput();
            if (inputList != null && !inputList.isEmpty()) {
                InputDto inputDto = inputList.get(0);
                HashMap<String, Object> inputMap = inputDto.getDataType();
                result = getResult(inputMap, result, inputDto.getIdentifier());
            }

            if (outputList != null && outputList.size() != 0) {
                OutPutDto outPutDto = outputList.get(0);
                HashMap<String, Object> outputMap = outPutDto.getDataType();
                result = getResult(outputMap, result, outPutDto.getIdentifier());
            }
        }
        return result;
    }

    private List<MyValidDto> getResult(HashMap<String, Object> dataMap, List<MyValidDto> result, String identifier) {
        if (result == null) {
            result = new ArrayList<>();
        }
        if (dataMap != null) {
            MyValidDto myValidDto;
            String type = (String) dataMap.get("type");
            myValidDto = finalValidDto(dataMap, type);
            myValidDto.setParamName(identifier);
            result.add(myValidDto);
        }
        return result;
    }

    private MyValidDto finalValidDto(HashMap<String, Object> dataMap, String type) {
        switch (type) {
            case "struct":
                return getMyValidStruct(dataMap);
            case "array":
                return getMyValidArray(dataMap);
            default:
                return getMyValid(dataMap, type);
        }
    }

    private MyValidDto getMyValid(HashMap<String, Object> dataMap, String type) {
        MyValidDto myValidDto = new MyValidDto();
        ValidDto validDto = new ValidDto();
        validDto.setValidation(type);
        validDto.setParameters((HashMap<String, Object>) dataMap.get("specs"));
        myValidDto.setValidations(validDto);
        return myValidDto;
    }

    private MyValidDto getMyValidStruct(HashMap<String, Object> dataMap) {
        MyValidDto myValidDto = new MyValidDto();
        ValidDto validDto = new ValidDto();
        validDto.setValidation(DataTypeEnum.STRUCT.getType());
        HashMap<String, Object> parameter = new HashMap<>();
        ArrayList<MyValidDto> myValidDtos = new ArrayList<>();
        List<HashMap<String, Object>> specsList = (List<HashMap<String, Object>>) dataMap.get("specs");
        if (specsList != null) {
            for (HashMap<String, Object> map : specsList) {
                MyValidDto myValid = new MyValidDto();
                ValidDto valid = new ValidDto();
                String innerIdentifier = (String) map.get("identifier");
                HashMap<String, Object> innerDataMap = (HashMap<String, Object>) map.get("dataType");
                if (innerDataMap != null) {
                    valid.setValidation((String) innerDataMap.get("type"));
                    valid.setParameters((HashMap<String, Object>) innerDataMap.get("specs"));
                }
                myValid.setValidations(valid);
                myValid.setParamName(innerIdentifier);
                myValidDtos.add(myValid);
            }
            parameter.put("property", myValidDtos);
            validDto.setParameters(parameter);
        }
        myValidDto.setValidations(validDto);
        return myValidDto;
    }

    private MyValidDto getMyValidArray(HashMap<String, Object> dataMap) {
        MyValidDto myValidDto = new MyValidDto();
        ValidDto validDto = new ValidDto();

        HashMap<String, Object> element = new HashMap<>();
        HashMap<String, Object> specs = (HashMap<String, Object>) dataMap.get("specs");
        if (specs != null) {
            ValidDto valid = new ValidDto();
            valid.setValidation((String) specs.get("type"));
            valid.setParameters((HashMap<String, Object>) specs.get("specs"));
            element.put("max", specs.get("length"));
            element.put("element", valid);
            validDto.setParameters(element);
        }
        validDto.setValidation(DataTypeEnum.ARRAY.getType());
        myValidDto.setValidations(validDto);
        return myValidDto;
    }
}

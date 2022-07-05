package com.daryl.api;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.support.hsf.HSFJSONUtils;
import com.daryl.constant.DataTypeEnum;
import com.daryl.domain.ResponseResult;
import com.daryl.domain.Student;
import com.daryl.dto.Dto;
import com.daryl.dto.mytest.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author wl
 * @create 2022-02-09
 */
@RestController
@RequestMapping("/api")
public class WebTestApi {

    @RequestMapping("/test")
    public String jsonTest() {
        String s = "[{\"id\":\"5ebedcda-8b7e-4d7e-9d63-683852c34343\",\"menu\":\"加量\",\"column1\":\"1GHx1管\",\"column2\":\"10GHx1管\",\"column3\":\"100GHx1管\"},{\"id\":\"f79f4c2e-2c69-4f84-88f7-66a7a1e9a39a\",\"menu\":\"第一次\",\"column1\":\"1\",\"column2\":\"1\",\"column3\":\"1\"},{\"id\":\"2def51ae-b933-4ca5-84ea-0b3139118dc0\",\"menu\":\"第二次\",\"column1\":\"1\",\"column2\":\"1\",\"column3\":\"1\"},{\"id\":\"23e4861e-6da0-47c0-b5bb-2af08b4a478a\",\"menu\":\"平版分离\",\"column1\":\"1\",\"column2\":\"1\",\"column3\":\"1\"},{\"id\":\"f2bb5269-9e39-4de4-8c3f-c756b441dae5\",\"menu\":\"最总结果\",\"column1\":\"353\"}]";

        return s;
    }

    @RequestMapping("/test2")
    public ResponseResult<?> test2() {
        return new ResponseResult<>(Student.yan());
    }

    @RequestMapping("/test3")
    public String test3() {
        String s1 = " [\n" +
                "  { k: 'int32', v: 'int32(整数型)', f: [] },\n" +
                "  { k: 'int64', v: 'int64(长整数型)', f: [] },\n" +
                "  { k: 'float', v: 'float(单精度浮点型)', f: [] },\n" +
                "  { k: 'double', v: 'double(双精度浮点型)', f: [] },\n" +
                "  { k: 'enum', v: 'enum(枚举)', f: [] },\n" +
                "  { k: 'bool', v: 'bool(布尔)', f: [] },\n" +
                "  { k: 'string', v: 'string(字符串)', f: [] },\n" +
                "  { k: 'struct', v: 'struct(结构体)', f: [] },\n" +
                "  { k: 'bitMap', v: 'bitMap(位图)', f: [] },\n" +
                "  { k: 'date', v: 'date(时间)', f: [] },\n" +
                "  { k: 'array', v: 'array(数组)', f: [] },\n" +
                "];\n" +
                "\n" +
                "const ACCESS_MODE_DATA = [\n" +
                "  { k: 'r', v: '只读' },\n" +
                "  { k: 'rw', v: '读写' },\n" +
                "];\n" +
                "\n" +
                "const UNIT = [\n" +
                "  { k: '1', v: 'v/a' },\n" +
                "  { k: '2', v: 'v/2' },\n" +
                "];\n" +
                "\n" +
                "const EVENT_TYPE = [\n" +
                "  { k: 'info', v: '信息' },\n" +
                "  { k: 'warn', v: '警告' },\n" +
                "  { k: 'error', v: '故障' },\n" +
                "];\n" +
                "\n" +
                "const CALL_TYPE = [\n" +
                "  { k: 'sync', v: '同步' },\n" +
                "  { k: 'async', v: '异步' },\n" +
                "];\n" +
                "const data1 = [\n" +
                "  {\n" +
                "    key: 1,\n" +
                "    funtype: '属性',\n" +
                "    funName: '地理位置',\n" +
                "    symbol: 'GeoLocation',\n" +
                "    dataType: 'struct(结构体)',\n" +
                "    definition: '-',\n" +
                "  },\n" +
                "  {\n" +
                "    key: 2,\n" +
                "    funtype: '属性',\n" +
                "    funName: '漏电告警',\n" +
                "    symbol: 'LeakageError',\n" +
                "    dataType: 'bool（布尔值）',\n" +
                "    definition: '布尔值：1-告警；0-正常',\n" +
                "  },\n" +
                "  {\n" +
                "    key: 3,\n" +
                "    funtype: '属性',\n" +
                "    funName: '倾斜告警',\n" +
                "    symbol: 'OverTiltError',\n" +
                "    dataType: 'bool（布尔值）',\n" +
                "    definition: '布尔值：1-告警；0-正常',\n" +
                "  },\n" +
                "  {\n" +
                "    key: 4,\n" +
                "    funtype: '属性',\n" +
                "    funName: '欠压告警',\n" +
                "    symbol: 'UnderVoltError',\n" +
                "    dataType: 'bool（布尔值）',\n" +
                "    definition: '布尔值：1-告警；0-正常',\n" +
                "  },\n" +
                "  {\n" +
                "    key: 5,\n" +
                "    funtype: '属性',\n" +
                "    funName: '过压告警',\n" +
                "    symbol: 'OverVoltError',\n" +
                "    dataType: 'bool（布尔值）',\n" +
                "    definition: '布尔值：1-告警；0-正常',\n" +
                "  },\n" +
                "  {\n" +
                "    key: 6,\n" +
                "    funtype: '属性',\n" +
                "    funName: '过流告警',\n" +
                "    symbol: 'OverCurrentError',\n" +
                "    dataType: 'bool（布尔值）',\n" +
                "    definition: '布尔值：1-告警；0-正常',\n" +
                "  },\n" +
                "]";
        return s1;
    }

    @RequestMapping("/test4")
    public Object test4() {
        String s2 = " {\n" +
                "  pId: 'gSOCTHVzqJ',\n" +
                "  version: '1.0.0',\n" +
                "  properties: [\n" +
                "    {\n" +
                "      identifier: 'IDF',\n" +
                "      name: 'DF_3',\n" +
                "      functionType: 'u',\n" +
                "      accessMode: 'r',\n" +
                "      desc: '',\n" +
                "      dataType: { type: 'int32', specs: { max: '5', min: '1' } },\n" +
                "      functionMode: 'property',\n" +
                "    },\n" +
                "    {\n" +
                "      identifier: 'IDF4',\n" +
                "      name: 'DF_4',\n" +
                "      functionType: 'u',\n" +
                "      accessMode: 'rw',\n" +
                "      desc: '',\n" +
                "      dataType: { type: 'enum', specs: { 20000: 'two', 100000: 'one' } },\n" +
                "      functionMode: 'property',\n" +
                "    },\n" +
                "    {\n" +
                "      identifier: 'DF7',\n" +
                "      name: 'DF_7',\n" +
                "      functionType: 'u',\n" +
                "      accessMode: 'rw',\n" +
                "      desc: '',\n" +
                "      dataType: { type: 'bool', specs: { true: 'onetrue', false: 'fase1112' } },\n" +
                "      functionMode: 'property',\n" +
                "    },\n" +
                "    {\n" +
                "      identifier: 'df',\n" +
                "      name: 'DF_2',\n" +
                "      functionType: 'u',\n" +
                "      accessMode: 'rw',\n" +
                "      desc: '',\n" +
                "      functionMode: 'property',\n" +
                "      dataType: {\n" +
                "        type: 'struct',\n" +
                "        specs: [\n" +
                "          {\n" +
                "            name: 'name',\n" +
                "            identifier: 'i_name',\n" +
                "            dataType: { type: 'string', specs: { length: 3 } },\n" +
                "          },\n" +
                "          {\n" +
                "            name: 'version',\n" +
                "            identifier: 'i_version',\n" +
                "            dataType: { type: 'int32', specs: { max: '10', min: '0' } },\n" +
                "          },\n" +
                "        ],\n" +
                "      },\n" +
                "    },\n" +
                "    {\n" +
                "      identifier: 'DF6',\n" +
                "      name: 'DF_6',\n" +
                "      functionType: 'u',\n" +
                "      accessMode: 'rw',\n" +
                "      desc: '',\n" +
                "      dataType: {\n" +
                "        type: 'bitMap',\n" +
                "        specs: {\n" +
                "          length: 4,\n" +
                "          define: [\n" +
                "            { 0: '00', 1: '01', bit: 0 },\n" +
                "            { 0: '10', 1: '11', bit: 1 },\n" +
                "            { 0: '30', 1: '31', bit: 2 },\n" +
                "            { 0: '40', 1: '41', bit: 3 },\n" +
                "          ],\n" +
                "        },\n" +
                "      },\n" +
                "      functionMode: 'property',\n" +
                "    },\n" +
                "    {\n" +
                "      name: 'DF_5',\n" +
                "      identifier: 'DF5',\n" +
                "      functionMode: 'property',\n" +
                "      accessMode: 'rw',\n" +
                "      dataType: {\n" +
                "        type: 'array',\n" +
                "        specs: {\n" +
                "          length: '6',\n" +
                "          type: 'float',\n" +
                "          specs: { min: '0', max: '3', step: '0.1', unit: '伏特每米 / V/m' },\n" +
                "        },\n" +
                "      },\n" +
                "      functionType: 'u',\n" +
                "    },\n" +
                "  ],\n" +
                "  services: [\n" +
                "    {\n" +
                "      name: 'service',\n" +
                "      identifier: 'i_service',\n" +
                "      functionMode: 'service',\n" +
                "      callType: 'sync',\n" +
                "      input: [\n" +
                "        {\n" +
                "          identifier: 'aaa_in_i',\n" +
                "          name: 'aaa_in',\n" +
                "          dataType: { type: 'string', specs: { length: '30' } },\n" +
                "        },\n" +
                "      ],\n" +
                "      output: [\n" +
                "        {\n" +
                "          identifier: 'bbb_out_i',\n" +
                "          name: 'bbb_out',\n" +
                "          dataType: { type: 'string', specs: { length: '30' } },\n" +
                "        },\n" +
                "      ],\n" +
                "      functionType: 'u',\n" +
                "    },\n" +
                "  ],\n" +
                "  events: [\n" +
                "    {\n" +
                "      identifier: 'ievent',\n" +
                "      name: 'event',\n" +
                "      functionType: 'u',\n" +
                "      eventType: 'info',\n" +
                "      desc: '',\n" +
                "      outputData: [\n" +
                "        {\n" +
                "          identifier: 'ipower',\n" +
                "          name: 'power',\n" +
                "          dataType: { type: 'int32', specs: { max: '100', min: '0' } },\n" +
                "        },\n" +
                "      ],\n" +
                "      functionMode: 'event',\n" +
                "    },\n" +
                "  ],\n" +
                "}";

        return JSONUtil.parse(s2);
    }

    @RequestMapping("/test5")
    public String test5() {
        String s = "    {{\n" +
                "      identifier: 'IDF',\n" +
                "      name: 'DF_3',\n" +
                "      functionType: 'u',\n" +
                "      accessMode: 'r',\n" +
                "      desc: '',\n" +
                "      dataType: { type: 'int32', specs: { max: '5', min: '1' } },\n" +
                "      functionMode: 'property',\n" +
                "    }}";
        return s;
    }

    @RequestMapping("/use")
    public String test(@RequestBody Dto<?> dto) {
        String s = "success";
        String str = (String) dto.getUseData();
        //str = str.replace("[","{").replace("]","}");
        //str = StringUtils.removeEnd(StringUtils.removeStart(str,"["),"]");
        Object useData1 = dto.getUseData();
        List<List<String>> list = JSON.parseObject((String) str, new TypeReference<List<List<String>>>() {
        });
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(13));
        list.get(13).set(1, "change");
        System.out.println(list.toString());
        System.out.println(JSON.toJSONString(list));
        //Map useData = (HashMap<String, Object>)dto.getUseData();
        // useData;
        return s;
    }

    @RequestMapping("/test6")
    public Object test6(@RequestBody ObjModelDto dto) {
        //pid
        String pid = dto.getPId();

        //version
        String version = dto.getVersion();
        ArrayList<MyValidDto> result = new ArrayList<>();
        //event
        List<EventTypeDto> events = dto.getEvents();
        for (EventTypeDto event : events) {
            MyValidDto myValidDto = new MyValidDto();

            List<OutPutData> outPutDataList = event.getOutputData();
            OutPutData outPutData = new OutPutData();
            if (!outPutDataList.isEmpty()) {
                outPutData = outPutDataList.get(0);
            }

            ValidDto validDto = new ValidDto();
            HashMap<String, Object> dataMap = outPutData.getDataType();
            if (dataMap != null) {
                String type = (String) dataMap.get("type");
                validDto.setValidation(type);
                if (DataTypeEnum.STRUCT.getType().equals(type)) {
                    HashMap<String, Object> map = new HashMap<>();
                    ArrayList<MyValidDto> myValidDtos = new ArrayList<>();
                    List<HashMap<String, Object>> specs = (List<HashMap<String, Object>>) dataMap.get("specs");
                    if (specs != null) {
                        for (HashMap<String, Object> spec : specs) {
                            MyValidDto myValidDto1 = new MyValidDto();
                            ValidDto validDto1 = new ValidDto();
                            String identifier = (String) spec.get("identifier");
                            HashMap<String, Object> dataType = (HashMap<String, Object>) spec.get("dataType");
                            if (dataType != null) {
                                validDto1.setValidation((String) dataType.get("type"));
                                validDto1.setParameters((HashMap<String, Object>) dataType.get("specs"));
                            }
                            myValidDto1.setValidations(validDto1);
                            myValidDto1.setParamName(identifier);
                            myValidDtos.add(myValidDto1);
                        }
                    }
                    map.put("property", myValidDtos);
                    validDto.setParameters(map);
                } else if (DataTypeEnum.ARRAY.getType().equals(type)) {
                    Object specs = dataMap.get("specs");
                    System.out.println(specs);
                } else {
                    validDto.setParameters((HashMap<String, Object>) dataMap.get("specs"));
                }

//                map.put("specs", dataMap.get("specs"));
//                validDto.setParameters(map);
            }

            myValidDto.setParamName(outPutData.getIdentifier());
            myValidDto.setValidations(validDto);
            result.add(myValidDto);
        }

        //properties
        List<PropertyTypeDto> properties = dto.getProperties();
        for (PropertyTypeDto property : properties) {
            MyValidDto myValidDto = new MyValidDto();
            ValidDto validDto = new ValidDto();
            HashMap<String, Object> propertyDataMap = property.getDataType();
            if (propertyDataMap != null) {
                String type = (String) propertyDataMap.get("type");
                validDto.setValidation(type);

                if (DataTypeEnum.STRUCT.getType().equals(type)) {
                    HashMap<String, Object> map = new HashMap<>();
                    ArrayList<MyValidDto> myValidDtos = new ArrayList<>();
                    List<HashMap<String, Object>> specs = (List<HashMap<String, Object>>) propertyDataMap.get("specs");
                    if (specs != null) {
                        for (HashMap<String, Object> spec : specs) {
                            MyValidDto myValidDto1 = new MyValidDto();
                            ValidDto validDto1 = new ValidDto();
                            String identifier = (String) spec.get("identifier");
                            HashMap<String, Object> dataType = (HashMap<String, Object>) spec.get("dataType");
                            if (dataType != null) {
                                validDto1.setValidation((String) dataType.get("type"));
                                validDto1.setParameters((HashMap<String, Object>) dataType.get("specs"));
                            }
                            myValidDto1.setValidations(validDto1);
                            myValidDto1.setParamName(identifier);
                            myValidDtos.add(myValidDto1);
                        }
                    }
                    map.put("property", myValidDtos);
                    validDto.setParameters(map);
                } else if (DataTypeEnum.ARRAY.getType().equals(type)) {
                    HashMap<String, Object> element = new HashMap<>();
                    HashMap<String, Object> specs = (HashMap<String, Object>) propertyDataMap.get("specs");
                    if (specs != null) {
                        element.put("max", specs.get("length"));
                        ValidDto validDto1 = new ValidDto();
                        validDto1.setValidation((String) specs.get("type"));
                        validDto1.setParameters((HashMap<String, Object>) specs.get("specs"));
                        element.put("element", validDto1);
                        validDto.setParameters(element);
                    }
                } else {
                    validDto.setParameters((HashMap<String, Object>) propertyDataMap.get("specs"));
                }
            }

            myValidDto.setParamName(property.getIdentifier());
            myValidDto.setValidations(validDto);
            result.add(myValidDto);
        }

        //services
        List<ServiceTypeDto> services = dto.getServices();
        for (ServiceTypeDto service : services) {

            List<InputDto> inputList = service.getInput();
            List<OutPutDto> outputList = service.getOutput();
            if (inputList != null && !inputList.isEmpty()) {
                MyValidDto myValidDto = new MyValidDto();
                ValidDto validDto = new ValidDto();
                InputDto inputDto = inputList.get(0);
                HashMap<String, Object> inputMap = inputDto.getDataType();
                if (inputMap != null) {
                    String type = (String) inputMap.get("type");
                    validDto.setValidation(type);
                    if (DataTypeEnum.STRUCT.getType().equals(type)) {
                        HashMap<String, Object> map = new HashMap<>();
                        ArrayList<MyValidDto> myValidDtos = new ArrayList<>();
                        List<HashMap<String, Object>> specs = (List<HashMap<String, Object>>) inputMap.get("specs");
                        if (specs != null) {
                            for (HashMap<String, Object> spec : specs) {
                                MyValidDto myValidDto1 = new MyValidDto();
                                ValidDto validDto1 = new ValidDto();
                                String identifier = (String) spec.get("identifier");
                                HashMap<String, Object> dataType = (HashMap<String, Object>) spec.get("dataType");
                                if (dataType != null) {
                                    validDto1.setValidation((String) dataType.get("type"));
                                    validDto1.setParameters((HashMap<String, Object>) dataType.get("specs"));
                                }
                                myValidDto1.setValidations(validDto1);
                                myValidDto1.setParamName(identifier);
                                myValidDtos.add(myValidDto1);
                            }
                        }
                        map.put("property", myValidDtos);
                        validDto.setParameters(map);
                    } else if (DataTypeEnum.ARRAY.getType().equals(type)) {
                        Object specs = inputMap.get("specs");
                        System.out.println(specs);
                    } else {
                        validDto.setParameters((HashMap<String, Object>) inputMap.get("specs"));
                    }
                }
                myValidDto.setParamName(inputDto.getIdentifier());
                myValidDto.setValidations(validDto);
                result.add(myValidDto);
            }

            if (outputList != null && outputList.size() != 0) {
                MyValidDto myValidDto = new MyValidDto();
                ValidDto validDto = new ValidDto();
                OutPutDto outPutDto = outputList.get(0);
                HashMap<String, Object> outputMap = outPutDto.getDataType();
                if (outputMap != null) {
                    String type = (String) outputMap.get("type");
                    validDto.setValidation(type);
                    if (DataTypeEnum.STRUCT.getType().equals(type)) {
                        HashMap<String, Object> map = new HashMap<>();
                        ArrayList<MyValidDto> myValidDtos = new ArrayList<>();
                        List<HashMap<String, Object>> specs = (List<HashMap<String, Object>>) outputMap.get("specs");
                        if (specs != null) {
                            for (HashMap<String, Object> spec : specs) {
                                MyValidDto myValidDto1 = new MyValidDto();
                                ValidDto validDto1 = new ValidDto();
                                String identifier = (String) spec.get("identifier");
                                HashMap<String, Object> dataType = (HashMap<String, Object>) spec.get("dataType");
                                if (dataType != null) {
                                    validDto1.setValidation((String) dataType.get("type"));
                                    validDto1.setParameters((HashMap<String, Object>) dataType.get("specs"));
                                }
                                myValidDto1.setValidations(validDto1);
                                myValidDto1.setParamName(identifier);
                                myValidDtos.add(myValidDto1);
                            }
                        }
                        map.put("property", myValidDtos);
                        validDto.setParameters(map);
                    } else if (DataTypeEnum.ARRAY.getType().equals(type)) {
                        Object specs = outputMap.get("specs");
                        System.out.println(specs);
                    } else {
                        validDto.setParameters((HashMap<String, Object>) outputMap.get("specs"));
                    }
                }
                myValidDto.setParamName(outPutDto.getIdentifier());
                myValidDto.setValidations(validDto);
                result.add(myValidDto);
            }
        }
        return result;
    }

    private List<MyValidDto> getEventsValid(List<EventTypeDto> events) {
        ArrayList<MyValidDto> result = new ArrayList<>();
        if (events == null) {
            return result;
        }
        for (EventTypeDto event : events) {
            List<OutPutData> outputDataList = event.getOutputData();
            if (outputDataList != null && !outputDataList.isEmpty()) {
                OutPutData outPutData = outputDataList.get(0);
                HashMap<String, Object> dataMap = outPutData.getDataType();
                if (dataMap != null) {
                    MyValidDto myValidDto = new MyValidDto();
                    ValidDto validDto = new ValidDto();
                    String type = (String) dataMap.get("type");
                    validDto.setValidation(type);
                    if (DataTypeEnum.STRUCT.getType().equals(type)) {
                        // 结构体
                        HashMap<String, Object> parameter = new HashMap<>();
                        ArrayList<MyValidDto> myValidDtos = new ArrayList<>();
                        List<HashMap<String, Object>> specsList = (List<HashMap<String, Object>>) dataMap.get("specs");
                        if (specsList != null) {
                            for (HashMap<String, Object> map : specsList) {
                                MyValidDto myValid = new MyValidDto();
                                ValidDto valid = new ValidDto();
                                String identifier = (String) map.get("identifier");
                                HashMap<String, Object> innerDataMap = (HashMap<String, Object>) map.get("dataType");
                                if (innerDataMap != null) {
                                    valid.setValidation((String) innerDataMap.get("type"));
                                    valid.setParameters((HashMap<String, Object>) innerDataMap.get("specs"));
                                }
                                myValid.setParamName(identifier);
                                myValid.setValidations(valid);
                                myValidDtos.add(myValid);
                            }
                        }
                        parameter.put("property", myValidDtos);
                        validDto.setParameters(parameter);
                    } else if (DataTypeEnum.ARRAY.getType().equals(type)) {
                        //数组
                        HashMap<String, Object> element = new HashMap<>();
                        HashMap<String, Object> specs = (HashMap<String, Object>) dataMap.get("specs");
                        if (specs != null) {
                            element.put("max", specs.get("length"));
                            ValidDto validDto1 = new ValidDto();
                            validDto1.setValidation((String) specs.get("type"));
                            validDto1.setParameters((HashMap<String, Object>) specs.get("specs"));
                            element.put("element", validDto1);
                            validDto.setParameters(element);
                        }
                    } else {
                        //其他
                        validDto.setParameters((HashMap<String, Object>) dataMap.get("specs"));
                    }
                    myValidDto.setValidations(validDto);
                    myValidDto.setParamName(outPutData.getIdentifier());
                    result.add(myValidDto);
                }
            }
        }
        return result;
    }

    private List<MyValidDto> getPropertiesList(List<PropertyTypeDto> properties) {
        ArrayList<MyValidDto> result = new ArrayList<>();
        if (properties == null) {
            return result;
        }
        for (PropertyTypeDto property : properties) {
            HashMap<String, Object> dataMap = property.getDataType();
            if (dataMap != null) {
                MyValidDto myValidDto = new MyValidDto();
                ValidDto validDto = new ValidDto();
                String type = (String) dataMap.get("type");
                validDto.setValidation(type);
                if (DataTypeEnum.STRUCT.getType().equals(type)) {
                    HashMap<String, Object> parameter = new HashMap<>();
                    ArrayList<MyValidDto> myValidDtos = new ArrayList<>();
                    List<HashMap<String, Object>> specsList = (List<HashMap<String, Object>>) dataMap.get("specs");
                    if (specsList != null) {
                        for (HashMap<String, Object> map : specsList) {
                            MyValidDto myValid = new MyValidDto();
                            ValidDto valid = new ValidDto();
                            String identifier = (String) map.get("identifier");
                            HashMap<String, Object> innerDataType = (HashMap<String, Object>) map.get("dataType");
                            if (innerDataType != null) {
                                valid.setValidation((String) innerDataType.get("type"));
                                valid.setParameters((HashMap<String, Object>) innerDataType.get("specs"));
                            }
                            myValid.setValidations(valid);
                            myValid.setParamName(identifier);
                            myValidDtos.add(myValid);
                        }
                    }
                    parameter.put("property", myValidDtos);
                    validDto.setParameters(parameter);
                } else if (DataTypeEnum.ARRAY.getType().equals(type)) {

                } else {

                }
            }
        }

        return result;
    }

    private MyValidDto getMyValid(HashMap<String, Object> dataMap, String identifier) {
        MyValidDto myValidDto = new MyValidDto();
        ValidDto validDto = new ValidDto();
        String type = (String) dataMap.get("type");
        validDto.setValidation(type);
        validDto.setParameters((HashMap<String, Object>) dataMap.get("specs"));
        myValidDto.setParamName(identifier);
        myValidDto.setValidations(validDto);
        return myValidDto;
    }

    private MyValidDto getMyValidStruct(HashMap<String, Object> dataMap, String identifier) {
        MyValidDto myValidDto = new MyValidDto();
        ValidDto validDto = new ValidDto();
        String type = (String) dataMap.get("type");
        validDto.setValidation(type);
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
        myValidDto.setParamName(identifier);
        myValidDto.setValidations(validDto);
        return myValidDto;
    }

    private MyValidDto getMyValidArray(HashMap<String, Object> dataMap, String identifier) {
        MyValidDto myValidDto = new MyValidDto();
        ValidDto validDto = new ValidDto();
        String type = (String) dataMap.get("type");

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
        validDto.setValidation(type);
        myValidDto.setValidations(validDto);
        myValidDto.setParamName(identifier);
        return myValidDto;
    }
}

package com.daryl.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.daryl.dto.Dto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wl
 * @create 2022-02-09
 */
@RestController
@RequestMapping("/api")
public class WebTestApi {
    @RequestMapping("/test")
    public String jsonTest(){
        String s = "[{\"id\":\"5ebedcda-8b7e-4d7e-9d63-683852c34343\",\"menu\":\"加量\",\"column1\":\"1GHx1管\",\"column2\":\"10GHx1管\",\"column3\":\"100GHx1管\"},{\"id\":\"f79f4c2e-2c69-4f84-88f7-66a7a1e9a39a\",\"menu\":\"第一次\",\"column1\":\"1\",\"column2\":\"1\",\"column3\":\"1\"},{\"id\":\"2def51ae-b933-4ca5-84ea-0b3139118dc0\",\"menu\":\"第二次\",\"column1\":\"1\",\"column2\":\"1\",\"column3\":\"1\"},{\"id\":\"23e4861e-6da0-47c0-b5bb-2af08b4a478a\",\"menu\":\"平版分离\",\"column1\":\"1\",\"column2\":\"1\",\"column3\":\"1\"},{\"id\":\"f2bb5269-9e39-4de4-8c3f-c756b441dae5\",\"menu\":\"最总结果\",\"column1\":\"353\"}]";
        return s;
    }

    @RequestMapping("/use")
    public String test( @RequestBody Dto<?> dto){
        String s ="success";
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
        list.get(13).set(1,"change");
        System.out.println(list.toString());
        System.out.println(JSON.toJSONString(list));
        //Map useData = (HashMap<String, Object>)dto.getUseData();
        // useData;
        return s;
    }
}

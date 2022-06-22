package com.daryl.serviceimpl;

import com.daryl.mapper.LinkmanMapper;
import com.daryl.pojo.Linkman;
import com.daryl.service.LinkmanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author wl
 * @create 2022-01-05
 */
@Service
@Transactional(rollbackOn = {Exception.class})
public class LinkmanServiceImpl implements LinkmanService {

    @Resource
    private LinkmanMapper linkmanMapper;

    @Override
    public List<Linkman> findAll() {
       return linkmanMapper.findAll();
    }

    @Override
    public Linkman findById(Integer id) {
        return linkmanMapper.findById(id).get();
    }
}

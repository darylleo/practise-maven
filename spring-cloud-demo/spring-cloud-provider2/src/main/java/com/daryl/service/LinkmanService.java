package com.daryl.service;

import com.daryl.pojo.Linkman;

import java.util.List;

/**
 * @author wl
 * @create 2022-01-05
 */
public interface LinkmanService {
    List<Linkman> findAll();

    Linkman findById(Integer id);
}

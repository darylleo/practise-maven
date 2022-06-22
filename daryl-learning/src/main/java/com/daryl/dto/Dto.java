package com.daryl.dto;

/**
 * ClassDescription
 *
 * @author wl
 * @create 2022-05-10
 */
public class Dto<T> {
    private T useData;

    public T getUseData() {
        return useData;
    }

    public void setUseData(T useData) {
        this.useData = useData;
    }
}

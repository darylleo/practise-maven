package com.daryl.pojo;

import java.io.Serializable;

/**
 * @author wl
 * @create 2022-01-12
 */
public class Article implements Serializable {

    private long id;

    private String content;

    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

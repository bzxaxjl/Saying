package com.example.bzx.finalwork.model;

import cn.bmob.v3.BmobObject;

/**
 * Created by bzx on 2018/1/18.
 */

public class notification extends BmobObject {

    private String content;
    private String title;

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

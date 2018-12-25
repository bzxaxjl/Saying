package com.example.bzx.finalwork.model;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by bzx on 2018/1/18.
 */

public class article extends BmobObject {

    private String content;
    private String title;
    private String intro;
    private BmobFile image;

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

    public String getIntro() {
        return intro;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }

    public BmobFile getImage() {
        return image;
    }
    public void setImage(BmobFile image) {
        this.image = image;
    }

}

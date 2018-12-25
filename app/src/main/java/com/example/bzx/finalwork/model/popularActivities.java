package com.example.bzx.finalwork.model;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Created by bzx on 2018/11/15.
 */

public class popularActivities extends BmobObject {

    private String name;
    private BmobFile image;
    private BmobFile intro;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public BmobFile getImage() {
        return image;
    }
    public void setImage(BmobFile image) {
        this.image = image;
    }

    public BmobFile getIntro() {
        return intro;
    }
    public void setIntro(BmobFile intro) {
        this.intro = intro;
    }


}

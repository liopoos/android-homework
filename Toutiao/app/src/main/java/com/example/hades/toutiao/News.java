package com.example.hades.toutiao;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by hades on 2017/6/12.
 */

public class News implements Serializable {

    private String title;
    private String desc;
    private String img;
    private String content;
    private String pubDate;


    public News(String name, String age, String img, String content, String pubDate) {
        this.title = name;
        this.desc = age;
        this.img = img;
        this.content = content;
        this.pubDate = pubDate;
    }

    public void setDesc(String desc) {

        this.desc = desc;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public void setPhotoId(String img) {
        this.img = img;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDesc() {

        return desc;
    }

    public String getImg() {

        return img;
    }

    public String getTitle() {

        return title;
    }

    public String getContent() {
        return content;
    }

    public String getPubDate() {
        return pubDate;
    }
}

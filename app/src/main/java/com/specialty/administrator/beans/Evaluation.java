package com.specialty.administrator.beans;

/**
 * Created by 陈彬 on 2018/1/4.
 */

public class Evaluation {
    private int id ;
    private String name;
    private Integer img;
    private String content;
    private String time;

    public Evaluation(int id, String name, Integer img, String content, String time) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.content = content;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }



    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

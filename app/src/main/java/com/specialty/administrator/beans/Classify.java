package com.specialty.administrator.beans;

/**
 * Created by 陈彬 on 2018/1/2.
 */

public class Classify {
   private String classify;
   private  int isSelected;//0,未选中，1选中

    public Classify(int isSelected,String classify) {
        this.isSelected = isSelected;
        this.classify = classify;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public int getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(int isSelected) {
        this.isSelected = isSelected;
    }
}

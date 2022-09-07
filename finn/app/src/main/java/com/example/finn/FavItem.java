package com.example.finn;

import java.io.Serializable;

public class FavItem implements Serializable {

    private String item_title;
    private String item_place;
    private String item_link;
    private String item_des;
    private String key_id;
    private int item_image;

    public FavItem() {
    }

    public FavItem(String item_title, String item_place, String item_link, String item_des, String key_id, int item_image) {
        this.item_title = item_title;
        this.item_place = item_place;
        this.item_link = item_link;
        this.item_des = item_des;
        this.key_id = key_id;
        this.item_image = item_image;
    }

    public String getItem_title() {
        return item_title;
    }

    public void setItem_title(String item_title) {
        this.item_title = item_title;
    }

    public String getItem_place() {
        return item_place;
    }

    public void setItem_place(String item_place) {
        this.item_place = item_place;
    }

    public String getItem_link() {
        return item_link;
    }

    public void setItem_link(String item_link) {
        this.item_link = item_link;
    }

    public String getItem_des() {
        return item_des;
    }

    public void setItem_des(String item_des) {
        this.item_des = item_des;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public int getItem_image() {
        return item_image;
    }

    public void setItem_image(int item_image) {
        this.item_image = item_image;
    }
}

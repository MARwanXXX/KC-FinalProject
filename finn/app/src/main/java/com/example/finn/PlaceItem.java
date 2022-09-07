package com.example.finn;

import android.net.Uri;

import java.io.Serializable;

public class PlaceItem implements Serializable {

    private int imageRes;
    private String title;
    private String key_id;
    private String favStatus;
    private String place;
    private String link;
    private String des;

    public PlaceItem() {
    }

    public PlaceItem(int imageRes, String title, String key_id, String favStatus, String place, String link, String des) {
        this.imageRes = imageRes;
        this.title = title;
        this.key_id = key_id;
        this.favStatus = favStatus;
        this.place = place;
        this.link = link;
        this.des = des;
    }

    public PlaceItem(String parse, String name, String id, String favStatus, String place, String link, String des) {
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getFavStatus() {
        return favStatus;
    }

    public void setFavStatus(String favStatus) {
        this.favStatus = favStatus;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}

package com.example.finn.Types;

import java.io.Serializable;

public class Types implements Serializable {

    private String typeName;
    private int typeImg;

    public Types(String typeName, int typeImg) {
        this.typeName = typeName;
        this.typeImg = typeImg;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getTypeImg() {
        return typeImg;
    }

    public void setTypeImg(int typeImg) {
        this.typeImg = typeImg;
    }
}

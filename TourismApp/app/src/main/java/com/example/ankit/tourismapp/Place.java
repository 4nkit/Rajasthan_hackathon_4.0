package com.example.ankit.tourismapp;

/**
 * Created by Ankit on 15-03-2018.
 */

public class Place {
    String pName;
    String pId;
    String pDesc;
    String pImgurl;

    public Place(String pName, String pId, String pDesc, String pImgurl) {
        this.pName = pName;
        this.pId = pId;
        this.pDesc = pDesc;
        this.pImgurl = pImgurl;
    }

    public String getpName() {
        return pName;
    }

    public String getpId() {
        return pId;
    }

    public String getpDesc() {
        return pDesc;
    }

    public String getpImgurl() {
        return pImgurl;
    }
}

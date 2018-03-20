package com.example.ankit.tourismapp;

/**
 * Created by Ankit on 15-03-2018.
 */

public class CityAdd {
    String cName;
    String cId;
    String cPlace;
    String cImgurl;

    public CityAdd(String cName, String cId, String cPlace, String cImgurl) {
        this.cName = cName;
        this.cId = cId;
        this.cPlace = cPlace;
        this.cImgurl = cImgurl;
    }

    public String getcName() {
        return cName;
    }

    public String getcId() {
        return cId;
    }

    public String getcPlace(){
        return cPlace;
    }
    public String getcImgurl(){
        return cImgurl;
    }
}

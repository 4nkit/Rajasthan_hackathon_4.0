package com.example.ankit.tourismapp;

import android.widget.ImageView;

/**
 * Created by Ankit on 15-03-2018.
 */

public class StateAdd {
    String sName;
    String sId;
    String sTotalCity;
    String sCapital;
    String sImgurl;

    public StateAdd(String sName,String sId, String sTotalCity, String sCapital, String sImgurl) {
        this.sName = sName;
        this.sId = sId;
        this.sTotalCity = sTotalCity;
        this.sCapital = sCapital;
        this.sImgurl = sImgurl;
    }

    public String getsName() {
        return sName;
    }

    public String getsId() {
        return sId;
    }

    public String getsTotalCity() {
        return sTotalCity;
    }

    public String getsCapital() {
        return sCapital;
    }

    public String getsImgurl() {
        return sImgurl;
    }


}

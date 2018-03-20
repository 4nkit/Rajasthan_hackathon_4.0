package com.example.ankit.tourismapp;

/**
 * Created by Ankit on 15-03-2018.
 */

public class Add {
    String pName;
    String pId;
    String pdesc;

    public Add(String pName, String pId, String pdesc) {
        this.pName = pName;
        this.pId = pId;
        this.pdesc = pdesc;
    }

    public String getpName() {
        return pName;
    }

    public String getpId() {
        return pId;
    }

    public String getPdesc() {
        return pdesc;
    }
}

package com.ehighsun.popuwindowpractice;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2017/12/19 0019.
 */

public class Species {
    private Bitmap bm;
    private String name;

    public Species(Bitmap bm, String name) {
        this.bm = bm;
        this.name = name;
    }

    public Bitmap getBm() {
        return bm;
    }

    public void setBm(Bitmap bm) {
        this.bm = bm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

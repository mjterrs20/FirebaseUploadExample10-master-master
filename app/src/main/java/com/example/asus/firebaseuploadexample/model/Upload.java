package com.example.asus.firebaseuploadexample.model;

import com.google.firebase.database.Exclude;

public class Upload {
    private String mName;
    private String mImageUrl;
    private String mKey;
    private String mHarga;
    private String mDaerah;
    private String mDes;
    private int mPosition;

    public String getmHarga() {
        return mHarga;
    }

    public void setmHarga(String mHarga) {
        this.mHarga = mHarga;
    }

    public String getmDaerah() {
        return mDaerah;
    }

    public void setmDaerah(String mDaerah) {
        this.mDaerah = mDaerah;
    }


    public String getmDes() {
        return mDes;
    }

    public void setmDes(String mDes) {
        this.mDes = mDes;
    }

    public Upload() {

        //empty constructor needed
    }

    public int getmPosition() {
        return mPosition;
    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }

    public Upload (int position){
        mPosition = position;
    }
    public Upload(String name, String imageUrl ,String harga,String daerah,String Des) {
        if (name.trim().equals("")) {
            name = "No Name";
        }

        mName = name;
        mImageUrl = imageUrl;
        mHarga = harga;
        mDaerah = daerah;
        mDes = Des;

    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    @Exclude
    public String getKey() {
        return mKey;
    }

    @Exclude
    public void setKey(String key) {
        mKey = key;
    }
}
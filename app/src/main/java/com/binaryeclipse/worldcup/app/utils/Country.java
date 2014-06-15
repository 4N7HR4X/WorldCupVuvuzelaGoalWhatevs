package com.binaryeclipse.worldcup.app.utils;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kurt on 2014/06/15.
 */
public class Country implements Parcelable {
    public String name;
    public int flag; //flag resource id
    public int notification; //notification resource id (the round icon)

    public Country(){}

    public Country(String name, int flag,int notification) {
        this.name = name;
        this.flag = flag;
        this.notification = notification;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", flag=" + flag +
                ", notification=" + notification +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.flag);
        dest.writeInt(this.notification);
    }

    private Country(Parcel in) {
        this.name = in.readString();
        this.flag = in.readInt();
        this.notification = in.readInt();
    }

    public static Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
        public Country createFromParcel(Parcel source) {
            return new Country(source);
        }

        public Country[] newArray(int size) {
            return new Country[size];
        }
    };
}

package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class DataVO implements Parcelable {
    String title;
    int hit;

    public DataVO() {
    }

    protected DataVO(Parcel in) {
        title = in.readString();
        hit = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(hit);
    }

    public static final Creator<DataVO> CREATOR = new Creator<DataVO>() {
        @Override
        public DataVO createFromParcel(Parcel in) {
            return new DataVO(in);
        }

        @Override
        public DataVO[] newArray(int size) {
            return new DataVO[size];
        }
    };
    /* setter, getter �앸왂 */
}

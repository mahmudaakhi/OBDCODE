package com.akhi.obdcodeerror;

public class CarList {
    private String carName,cardes,mKey;

    public CarList() {
    }

    public CarList(String carName, String carImage, String mKey) {
        this.carName = carName;
        this.cardes = carImage;
        this.mKey = mKey;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarImage() {
        return cardes;
    }

    public void setCarImage(String carImage) {
        this.cardes = carImage;
    }

    public String getmKey() {
        return mKey;
    }

    public void setmKey(String mKey) {
        this.mKey = mKey;
    }

}

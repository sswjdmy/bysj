package com.example.pmsserver.bean;

/**
 * @Auther: wanjunyi
 * @Date: 2019/3/15 20:17
 * @Description:
 */
public class RespMedicine {
    private Medicine medicine;
    private String addTime;
    private MType mType;

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }


    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public MType getmType() {
        return mType;
    }

    public void setmType(MType mType) {
        this.mType = mType;
    }
}

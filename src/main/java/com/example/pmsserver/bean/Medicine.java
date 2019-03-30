package com.example.pmsserver.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @Auther: wanjunyi
 * @Date: 2019/3/15 18:03
 * @Description:
 */
public class Medicine {
    private Long id;
    private Long uid;
    private Long tid;
    private String medicineName;
    private boolean prescription;
    private BigDecimal charge;
    private String medicineDescribe;
    private int medicineNumber;
    private Timestamp addTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public boolean isPrescription() {
        return prescription;
    }

    public void setPrescription(boolean prescription) {
        this.prescription = prescription;
    }

    public BigDecimal getCharge() {
        return charge;
    }

    public void setCharge(BigDecimal charge) {
        this.charge = charge;
    }

    public String getMedicineDescribe() {
        return medicineDescribe;
    }

    public void setMedicineDescribe(String medicineDescribe) {
        this.medicineDescribe = medicineDescribe;
    }

    public int getMedicineNumber() {
        return medicineNumber;
    }

    public void setMedicineNumber(int medicineNumber) {
        this.medicineNumber = medicineNumber;
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }
}

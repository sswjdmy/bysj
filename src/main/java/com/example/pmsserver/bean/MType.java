package com.example.pmsserver.bean;

/**
 * @Auther: wanjunyi
 * @Date: 2019/3/11 10:56
 * @Description: 药品类型
 */
public class MType {
    private Long id;
    private String cateName;
    private Long uid;
    //该种类下药品数量
    private int subNumber;


    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public MType(String name, Long uId, int subNumber){
        this.cateName=name;
        this.uid = uId;
        this.subNumber = subNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        public int getSubNumber() {
        return subNumber;
    }

    public void setSubNumber(int subNumber) {
        this.subNumber = subNumber;
    }
}

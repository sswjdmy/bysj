package com.example.pmsserver.bean;

/**
 * @Auther: wanjunyi
 * @Date: 2019/3/11 10:56
 * @Description: 药品类型
 */
public class MType {
    private Long id;
    private String name;
    private Long uId;
    //该种类下药品数量
    private int subNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public int getSubNumber() {
        return subNumber;
    }

    public void setSubNumber(int subNumber) {
        this.subNumber = subNumber;
    }
}

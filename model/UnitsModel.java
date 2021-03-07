package com.example.algorithm.model;

import com.orm.SugarRecord;

public class UnitsModel extends SugarRecord {

    private String unitName;
    private int unitCode;
    private int section1;
    private int section2;

    public UnitsModel() {
    }

    public UnitsModel(String unitName, int unitCode, int section1, int section2) {
        this.unitName = unitName;
        this.unitCode = unitCode;
        this.section1 = section1;
        this.section2 = section2;
    }

    public int getSection1() {
        return section1;
    }

    public void setSection1(int section1) {
        this.section1 = section1;
    }

    public int getSection2() {
        return section2;
    }

    public void setSection2(int section2) {
        this.section2 = section2;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public int getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(int unitCode) {
        this.unitCode = unitCode;
    }


}

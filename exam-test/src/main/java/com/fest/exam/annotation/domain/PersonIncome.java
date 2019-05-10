package com.fest.exam.annotation.domain;

import com.fest.exam.annotation.annotation.ExportName;

import java.math.BigDecimal;

/**
 * @Author: yesitao
 * @Date: 2019/4/28 11:44
 * @Description: 个人收入实体
 */
public class PersonIncome {

    @ExportName(name = "名字")
    private String name;
    @ExportName(name = "身份证")
    private String idCard;
    @ExportName(name = "年")
    private String year;
    @ExportName(name = "月")
    private String month;
    @ExportName(name = "收入")
    private BigDecimal money;
    private BigDecimal personalTax;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getPersonalTax() {
        return personalTax;
    }

    public void setPersonalTax(BigDecimal personalTax) {
        this.personalTax = personalTax;
    }
}

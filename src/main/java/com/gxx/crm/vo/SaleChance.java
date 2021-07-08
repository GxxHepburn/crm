package com.gxx.crm.vo;

import lombok.Data;

import java.util.Date;

@Data
public class SaleChance {
    private Integer id;

    private String chanceSource;

    private String customerName;

    private Integer cgjl;

    private String overview;

    private String linkMan;

    private String linkPhone;

    private String description;

    private String createMan;

    private String assignMan;

    private Date assignTime;

    private Integer state;

    private Integer devResult;

    private Byte isValid;

    private Date createDate;

    private Date updateDate;
}
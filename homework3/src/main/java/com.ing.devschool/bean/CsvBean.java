package com.ing.devschool.bean;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class CsvBean {
    @CsvBindByName(column = "Date")
    private String Date;

    @CsvBindByName(column = "Time")
    private String time;

    @CsvBindByName(column = "Transaction")
    private Integer transaction;

    @CsvBindByName(column = "Item")
    private String item;
}

package com.ing.devschool.dto;

import lombok.Data;

import java.util.Map;

@Data
public class TransactionDto implements Comparable<TransactionDto>{
    private String date;
    private Integer transactionId;
    private Map<String, Integer> itemsSummary;

    public TransactionDto(Integer transactionId, String date, Map<String, Integer> itemsSummary) {
        this.transactionId = transactionId;
        this.date = date;
        this.itemsSummary = itemsSummary;
    }

    @Override
    public int compareTo(TransactionDto o) {
        return this.itemsSummary.size() - o.itemsSummary.size();
    }
}

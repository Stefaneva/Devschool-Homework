package com.ing.devschool.service;

import com.ing.devschool.bean.CsvBean;
import com.ing.devschool.bean.JsonBean;
import com.ing.devschool.dto.TransactionDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TransactionDtoTransformer {
    private List<TransactionDto> transactionDtos;
    public List<TransactionDto> csvBeansToTransactionDtos(List<CsvBean> csvBeans) {
        if (csvBeans != null) {
            List<TransactionDto> transactionDtos = new ArrayList<>();
            csvBeans.forEach(bean -> {
                Map<String, Integer> hashMap = new HashMap<>();
                hashMap.put(bean.getItem(), 1);
                if (transactionDtos.size() > 0) {
                    boolean checkTransactionId = false;
                    for (TransactionDto transaction : transactionDtos) {
                        if (transaction.getTransactionId().equals(bean.getTransaction())) {
                            transaction.setItemsSummary(
                                    updateItemSummary(transaction.getItemsSummary(), bean.getItem()));
                            checkTransactionId = true;
                        }
                    }
                    if (!checkTransactionId)
                        transactionDtos.add(new TransactionDto(bean.getTransaction(), bean.getDate(), hashMap));
                } else
                    transactionDtos.add(new TransactionDto(bean.getTransaction(), bean.getDate(), hashMap));
            });
            return transactionDtos;
        }
        return null;
    }

    private static Map<String, Integer> updateItemSummary(Map<String, Integer> itemSummary, String itemName) {
        for (String item : itemSummary.keySet()) {
            if (itemName.equals(item)) {
                itemSummary.replace(itemName, itemSummary.get(itemName) + 1);
                return itemSummary;
            }
        }
        itemSummary.put(itemName, 1);
        return  itemSummary;
    }

    public List<TransactionDto> jsonBeansToTransactionDtos(List<JsonBean> jsonBeans) {
        if (jsonBeans == null)
            return null;
        this.transactionDtos = new ArrayList<>();
        jsonBeans.stream().forEach(this::constructTransactionList);
        return this.transactionDtos;
    }

    private void constructTransactionList(JsonBean jsonBean) {
        Map<String, Integer> map = new HashMap<>();
        map.put(jsonBean.getItem(), 1);
        int check = 0;
        List<TransactionDto> filteredList= this.transactionDtos
                .stream()
                .filter(transactionDto -> transactionDto.getTransactionId().equals(jsonBean.getTransactionId()))
                .collect(Collectors.toList());
        if (filteredList.size() > 0)
            filteredList.forEach(transactionDto -> updateItemSummary(transactionDto.getItemsSummary(), jsonBean.getItem()));
        else
            this.transactionDtos.add(new TransactionDto(jsonBean.getTransactionId(), jsonBean.getDate(), map));

    }
}

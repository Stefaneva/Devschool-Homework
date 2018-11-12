package com.ing.devschool.dto;

import com.ing.devschool.bean.CsvBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionDtoTransformer {
    public List<TransactionDto> csvBeansToTransactionDtos(List<CsvBean> csvBeans) {
        if (csvBeans != null) {
            List<TransactionDto> transactionDtos = new ArrayList<>();
            csvBeans.forEach(bean -> {
                Map<String, Integer> hashMap = new HashMap<>();
                hashMap.put(bean.getItem(), 1);
                if (transactionDtos.size() > 0) {
                    boolean checkTransaction = false;
                    for (TransactionDto transaction : transactionDtos) {
                        if (transaction.getTransactionId().equals(bean.getTransaction())) {
                            transaction.setItemsSummary(
                                    updateItemSummary(transaction.getItemsSummary(), bean.getItem()));
                            checkTransaction = true;
                        }
                    }
                    if (!checkTransaction)
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
}

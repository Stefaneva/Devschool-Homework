package com.ing.devschool.dto;

import com.ing.devschool.bean.CsvBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransactionDtoTransformer {
    public List<TransactionDto> csvBeansToTransactionDtos(List<CsvBean> csvBeans) {
        if (csvBeans != null) {
            List<TransactionDto> transactionDtos = new ArrayList<>();
            csvBeans.forEach(bean -> {
                HashMap<String, Integer> hashMap = new HashMap<>();
                hashMap.put(bean.getItem(), 1);
                if (transactionDtos.size() > 0) {
                    boolean check = false;
                    for (TransactionDto transaction : transactionDtos) {
                        if (transaction.getTransactionId().equals(bean.getTransaction())) {
                            transaction.getItemsSummary().put(bean.getItem(), 1);
                            check = true;
                        }
                    }
                    if (!check)
                        transactionDtos.add(new TransactionDto(bean.getTransaction(), bean.getDate(), hashMap));
                } else
                    transactionDtos.add(new TransactionDto(bean.getTransaction(), bean.getDate(), hashMap));
            });
            return transactionDtos;
        }
        return null;
    }
}

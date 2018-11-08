package com.ing.devschool;

import com.ing.devschool.bean.CsvBean;
import com.ing.devschool.dto.TransactionDto;
import com.ing.devschool.dto.TransactionDtoTransformer;
import com.ing.devschool.service.CsvService;
import com.ing.devschool.service.JsonService;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final String csvResourcePath = "./homework3/src/main/resources/bakery-transactions.csv";
        final String jsonResourcePath = "./homework3/src/main/resources";

        CsvService csvService = new CsvService();
        JsonService jsonService = new JsonService();
        TransactionDtoTransformer transformer = new TransactionDtoTransformer();


        List<CsvBean> csvBeans = csvService.readCsv(csvResourcePath);
        List<TransactionDto> transactionDtos = transformer.csvBeansToTransactionDtos(csvBeans);
        if (transactionDtos != null) {
            Collections.sort(transactionDtos);
            transactionDtos.forEach(System.out::println);
            jsonService.writeJsonToFile(transactionDtos, jsonResourcePath, "bakery-summary.json");
        }
    }
}

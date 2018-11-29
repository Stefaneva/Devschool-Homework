package com.ing.devschool;

import com.beust.jcommander.JCommander;
import com.ing.devschool.args.HomeWorkFormat;
import com.ing.devschool.args.HomeWorkParams;
import com.ing.devschool.bean.CsvBean;
import com.ing.devschool.bean.JsonBean;
import com.ing.devschool.dto.TransactionDto;
import com.ing.devschool.service.TransactionDtoTransformer;
import com.ing.devschool.service.CsvService;
import com.ing.devschool.service.JsonService;
import java.util.Collections;
import java.util.List;

public class Main {
    private CsvService csvService = new CsvService();
    private JsonService jsonService = new JsonService();
    private TransactionDtoTransformer transformer = new TransactionDtoTransformer();

    public static void main(String[] args) {
//      Use these as args
        final String csvFilePath = "./homework3/src/main/resources/bakery-transactions.csv";
        final String csvTranscationsFilePath = "./homework3/src/main/resources/bakery-summary.json";
        final String jsonFilePath = "./homework3/src/main/resources/bakery-transactions.json";
        final String jsonTransactionsFilePath = "./homework3/src/main/resources/bakery-summary-from-json.json";
//      Example: --input-path ./homework3/src/main/resources/bakery-transactions.csv
//               --input-format csv
//               --output-path ./homework3/src/main/resources/bakery-summary.json

        HomeWorkParams inputParams = new HomeWorkParams();
//        inputParams.setInputFilePath(csvFilePath);
//        inputParams.setOutputFilePath(csvTranscationsFilePath);
//        inputParams.setInputFormat(HomeWorkFormat.CSV);
//        inputParams.setInputFilePath(jsonFilePath);
//        inputParams.setOutputFilePath(jsonTransactionsFilePath);
//        inputParams.setInputFormat(HomeWorkFormat.JSON);
        inputParams.setHelp(false);

        JCommander parser = JCommander.newBuilder()
                .addObject(inputParams)
                .build();

        // example --input-path asd --input-format csv --output-path dsa
        parser.parse(args);

        if (inputParams.isHelp()) {
            parser.usage();
            return;
        }

        new Main().process(inputParams);
    }

    public void process(HomeWorkParams inputParams) {
        System.out.println(inputParams);
        List<TransactionDto> transactionDtos;
        if (inputParams.getInputFormat() == HomeWorkFormat.CSV) {
            List<CsvBean> csvBeans = csvService.readCsv(inputParams.getInputFilePath());
            transactionDtos = transformer.csvBeansToTransactionDtos(csvBeans);
            if (transactionDtos != null) {
                Collections.sort(transactionDtos);
                transactionDtos.forEach(System.out::println);
                jsonService.writeJsonToFile(transactionDtos, inputParams.getOutputFilePath());
            }
        }
        else {
            List<JsonBean> jsonBeans = jsonService.readJsonFile(inputParams.getInputFilePath());
            transactionDtos = transformer.jsonBeansToTransactionDtos(jsonBeans);
            Collections.sort(transactionDtos);
            jsonService.writeJsonToFile(transactionDtos, inputParams.getOutputFilePath());
        }
    }
}

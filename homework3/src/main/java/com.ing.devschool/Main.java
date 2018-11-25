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
        final String resourcePath = "./homework3/src/main/resources";

        HomeWorkParams inputParams = new HomeWorkParams();
        inputParams.setInputFilePath(resourcePath);
        inputParams.setOutputFilePath(resourcePath);
        inputParams.setInputFormat(HomeWorkFormat.CSV);
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
            List<CsvBean> csvBeans = csvService.readCsv(inputParams.getOutputFilePath(), "bakery-transactions.csv");
            transactionDtos = transformer.csvBeansToTransactionDtos(csvBeans);
            if (transactionDtos != null) {
                Collections.sort(transactionDtos);
                transactionDtos.forEach(System.out::println);
                jsonService.writeJsonToFile(transactionDtos, inputParams.getOutputFilePath(), "bakery-summary.json");
            }
        }
        else {
            List<JsonBean> jsonBeans = jsonService.readJsonFile(inputParams.getOutputFilePath(),"bakery-transactions.json");
            transactionDtos = transformer.jsonBeansToTransactionDtos(jsonBeans);
            Collections.sort(transactionDtos);
            jsonService.writeJsonToFile(transactionDtos, inputParams.getOutputFilePath(), "bakery-summary-from-json.json");
        }
    }
}

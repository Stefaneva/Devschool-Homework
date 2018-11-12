package com.ing.devschool.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.devschool.dto.TransactionDto;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonService {
    public void writeJsonToFile(List<TransactionDto> transactionDtos, String filePath, String fileName) {
        File file = new File(filePath + "/" + fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        TransactionDto[] array = new TransactionDto[transactionDtos.size()];
        array = transactionDtos.toArray(array);
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

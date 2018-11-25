package com.ing.devschool.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.devschool.bean.CsvBean;
import com.ing.devschool.bean.JsonBean;
import com.ing.devschool.dto.TransactionDto;
import jdk.internal.org.objectweb.asm.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

    public List<JsonBean> readJsonFile(String filePath, String fileName) {
        File file = new File(filePath + "/" + fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        List<JsonBean> jsonBeans = null;
        try {
             jsonBeans = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, JsonBean.class));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonBeans;
    }
}

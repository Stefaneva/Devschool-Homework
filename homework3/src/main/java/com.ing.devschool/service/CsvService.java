package com.ing.devschool.service;

import com.ing.devschool.bean.CsvBean;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvService {
    public List<CsvBean> readCsv(String path, String fileName) {
        String filePath = path + "/" + fileName;
        try(Reader reader = Files.newBufferedReader(Paths.get(filePath))) {
            CsvToBean<CsvBean> csvBeans = new CsvToBeanBuilder<CsvBean>(reader)
                    .withType(CsvBean.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvBeans.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.ing.devschool.args;

import com.beust.jcommander.Parameter;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class HomeWorkParams {
    @Parameter(names = "--input-path", description = "Input file path, either relative or absolute")
    private String inputFilePath;

    @Parameter(names = "--input-format", description = "Input file format, regardless of input file suffix")
    private HomeWorkFormat inputFormat;

    @Parameter(names = "--output-path", description = "Output file path, either relative or absolute")
    private String outputFilePath;

    @Parameter(names = { "--help", "-h" }, help = true)
    private boolean help = false;
}

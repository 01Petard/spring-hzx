package com.hzx.lesson.common.utils;

import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
@Slf4j
public class CSVUtils {
    public static void writeDataToCSV(String fileName, String[] headers, List<String[]> data) {
        String filePath = "logs" + File.separator + fileName;
        boolean fileExists = new File(filePath).exists();

        try (
                FileWriter fw = new FileWriter(filePath, true);
                CSVWriter writer = (CSVWriter) new CSVWriterBuilder(fw)
                        .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                        .withQuoteChar(CSVWriter.DEFAULT_QUOTE_CHARACTER)
                        .withEscapeChar(CSVWriter.DEFAULT_ESCAPE_CHARACTER)
                        .withLineEnd(CSVWriter.DEFAULT_LINE_END)
                        .build()
        ) {
            if (!fileExists) {
                writer.writeNext(headers);
            }
            data.forEach(writer::writeNext);
        } catch (IOException e) {
            log.error("CSV 文件写入失败", e);
        }
    }

    private List<String[]> convertStringToList(String input) {
        List<String[]> data = new ArrayList<>();
        for (String line : input.split("\n")) {
            data.add(line.split(","));
        }
        return data;
    }

    /**
     * agv出入站日志
     * @param apiName
     * @param input
     */
    public void writeAgvEventEnterOutToCSV(String apiName, String input) {
        String fileName = apiName+DateHelper.getCurrentDate() + ".csv";
        String[] headers = {"eventType", "lineCode", "locationCode", "agvCode", "seat","status","time"};
        writeDataToCSV( fileName, headers,convertStringToList(input));
    }

    /**
     * agv产量日志
     * @param input
     */
    public void writeAgvEventQualifiedToCSV(String input) {
        String fileName = "agvQualified" + DateHelper.getCurrentDate() + ".csv";
        String[] headers = {"eventType", "lineCode", "agvCode", "seat","barcode","time"};
        writeDataToCSV( fileName, headers,convertStringToList(input));
    }
}

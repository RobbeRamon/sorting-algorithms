package com.robberamon.helper;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomFileWriter {
    public static void write(Map<Integer, Integer> data, String filename) {
        // default all fields are enclosed in double quotes
        // default separator is a comma
        List<String[]> formattedData = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : data.entrySet())
            formattedData.add(new String[]{entry.getKey().toString(), entry.getValue().toString()});

        String location = "../" + filename + ".csv";

        try (CSVWriter writer = new CSVWriter(new FileWriter(location))) {
            writer.writeAll(formattedData, false);
        } catch (IOException e) {
            System.out.println("Could not write " + filename + " to file");
        }
    }
}

package com.project.util;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CSVExporter {

    public static void export(List<List<String>> data, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (List<String> row : data) {
                for (int i = 0; i < row.size(); i++) {
                    writer.append(escapeSpecialCharacters(row.get(i)));

                    if (i != row.size() - 1) {
                        writer.append(",");
                    }
                }
                writer.append(System.lineSeparator());
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String escapeSpecialCharacters(String cellData) {
        if (cellData.contains(",") || cellData.contains("\"") || cellData.contains("\n")) {
            cellData = cellData.replace("\"", "\"\"");
            cellData = "\"" + cellData + "\"";
        }
        return cellData;
    }

    public static String formatDate(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }
}

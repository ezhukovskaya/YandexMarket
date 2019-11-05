package utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVFileWrite {
    /**
     * запись всех категорий в csv файл
     * @param allCat все категории
     * @param path путь к располодению файла
     */
    public void fileWrite(ArrayList<String> allCat, String path) {
        try {
            FileWriter writer = new FileWriter(path);
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
            for (String s : allCat) {
                csvPrinter.printRecord(s);
            }
            csvPrinter.flush();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

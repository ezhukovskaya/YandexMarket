package Utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVFileWrite {
    private static CSVFileWrite csvFileWrite;

    /**
     * метод записи всех категорий в файл
     * @param allCat
     * @throws IOException
     */
    public void fileWrite(ArrayList<String> allCat) throws IOException {
        PropertiesRead propertiesRead = new PropertiesRead();
        FileWriter writer = new FileWriter(propertiesRead.readFileRootFromPropertiesFile());
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        for (String s : allCat) {
            csvPrinter.printRecord(s);
        }
        csvPrinter.flush();
    }
}

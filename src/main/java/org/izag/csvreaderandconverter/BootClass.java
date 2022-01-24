package org.izag.csvreaderandconverter;

import java.util.List;

public class BootClass {

    public static void main(String[] args) {

        CsvReader csvReader = new CsvReader(args[0]);

        List<SimpleEntity> simpleEntityList = csvReader.readFromCsv();
        for(SimpleEntity simpleEntity : simpleEntityList) {
            System.out.println(simpleEntity);
        }
    }
}
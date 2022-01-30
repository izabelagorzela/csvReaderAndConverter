package org.izag.csvreaderandconverter;

import java.util.List;

public class BootClass {

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Required argument - file path");
            System.exit(0);
        }

        CsvReader csvReader = new CsvReader();
        List<SimpleEntity> simpleEntityList = csvReader.readFromCsv(args[0]);
        SimpleEntityPrinter simpleEntityPrinter = new SimpleEntityPrinter(new SimpleEntityFormater());
        simpleEntityPrinter.printEntities(simpleEntityList);
    }
}
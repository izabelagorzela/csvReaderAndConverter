package org.izag.csvreaderandconverter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CsvReader {

    private BufferedReader bufferedReader;
    private SimpleEntityConverter simpleEnityConverter;

    public CsvReader(String pathFile) {
        try{
            this.bufferedReader = new BufferedReader(new FileReader(pathFile));
        }catch(IOException exc) {
            System.err.println(exc.getMessage());
            System.exit(0);
        }
        this.simpleEnityConverter = new SimpleEntityConverter();
    }

    public List<SimpleEntity> readFromCsv() {
        int rowNumber = 0;
        String row;
        Optional<SimpleEntity> simpleEntityOptional;
        List<SimpleEntity> simpleEntitiesList = new ArrayList<>();
        try {
            while ((row = bufferedReader.readLine()) != null) {
                rowNumber++;
                simpleEntityOptional = simpleEnityConverter.convertToSimpleEntity(row);
                if(simpleEntityOptional.isPresent()) {
                    simpleEntitiesList.add(simpleEntityOptional.get());
                }
                else {
                    System.out.println("Row number " + rowNumber + " cannot be converted to required SimpleEntity object");
                    if(rowNumber == 1) {
                        System.out.println("That's header");
                    }
                }
            }
        } catch(IOException exc) {
            System.err.println(exc.getMessage());
            System.exit(0);
        }
        return simpleEntitiesList;
    }
}
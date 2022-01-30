package org.izag.csvreaderandconverter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CsvReader {

    private SimpleEntityConverter simpleEntityConverter;

    public CsvReader(){
        this.simpleEntityConverter = new SimpleEntityConverter();
    }

    public List<SimpleEntity> readFromCsv(String pathFile) {
        List<SimpleEntity> simpleEntityList = new ArrayList<>();
        String row;
        int rowNumber = 0;
        Optional<SimpleEntity> simpleEntityOptional;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile))){
            while((row = bufferedReader.readLine()) != null) {
                rowNumber++;
                simpleEntityOptional = simpleEntityConverter.convertToSimpleEntity(row);
                if(simpleEntityOptional.isPresent()) {
                   simpleEntityList.add(simpleEntityOptional.get());
                } else {
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
        return simpleEntityList;
    }
}
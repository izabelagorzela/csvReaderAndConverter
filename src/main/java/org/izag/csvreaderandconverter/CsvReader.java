package org.izag.csvreaderandconverter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CsvReader {

    private SimpleEntityConverter simpleEntityConverter;

    public CsvReader(SimpleEntityConverter simpleEntityConverter){
        this.simpleEntityConverter = simpleEntityConverter;
    }

    public List<SimpleEntity> readFromCsv(String pathFile) {
        List<SimpleEntity> simpleEntityList = new ArrayList<>();
        String row;
        Optional<SimpleEntity> simpleEntityOptional;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile))){
            while((row = bufferedReader.readLine()) != null) {
                simpleEntityOptional = simpleEntityConverter.convertToSimpleEntity(row);
                if(simpleEntityOptional.isPresent()) {
                   simpleEntityList.add(simpleEntityOptional.get());
                }
            }
        } catch(IOException exc) {
            System.err.println(exc.getMessage());
            System.exit(1);
        }
        return simpleEntityList;
    }
}
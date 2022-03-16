package org.izag.csvreaderandconverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CsvReader {

    private static Logger LOG = LoggerFactory
            .getLogger(CsvReader.class);

    private SimpleEntityConverter simpleEntityConverter;

    @Autowired
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
            LOG.error(exc.getMessage());
            System.exit(1);
        }
        return simpleEntityList;
    }
}
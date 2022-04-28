package org.izag.csvreaderandconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import static java.lang.System.exit;

@Component
public class RunClass implements CommandLineRunner{

    private static Logger LOG = LoggerFactory.getLogger(RunClass.class);

    private CsvReader csvReader;
    private SimpleEntityPrinter simpleEntityPrinter;

    @Autowired
    public RunClass(CsvReader csvReader, SimpleEntityPrinter simpleEntityPrinter) {
        this.csvReader = csvReader;
        this.simpleEntityPrinter = simpleEntityPrinter;
    }

    @Override
    public void run(String... args) {
        if(args.length == 0) {
            LOG.info("Required argument - file path");
            exit(1);
        }
        List<SimpleEntity> simpleEntityList =  csvReader.readFromCsv(args[0]);
        simpleEntityPrinter.printEntities(simpleEntityList);
    }
}
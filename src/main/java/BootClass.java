import java.util.List;

public class BootClass {

    public static void main(String[] args) {

        CsvReader csvReader = new CsvReader(args[0]);
        List<SimpleEntity>  simpleEntityList = new ConverterToSimpleEntity(csvReader.readFromCsv()).convertToSimpleEntity();

        for(SimpleEntity se : simpleEntityList) {
            System.out.println(se.getId() + " " + se.getName() + " " + se.getDate());
        }
    }
}
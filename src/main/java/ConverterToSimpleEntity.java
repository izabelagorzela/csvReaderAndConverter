import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ConverterToSimpleEntity {

    private List<String> rows;

    List<SimpleEntity> convertToSimpleEntity() {
        List<SimpleEntity> simpleEntityList = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++) {
            String[] data = rows.get(i).split(",");
            try {
                simpleEntityList.add(new SimpleEntity(Integer.valueOf(data[0]), data[1], LocalDate.parse(data[2], DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
            } catch (NumberFormatException exc) {
                int rowNumber = i + 1;
                System.out.println("Row number " + rowNumber + " cannot be converted to required SimpleEntity object");
                if(i == 0) {
                    System.out.println("That's header");
                }
            }
        }
        return simpleEntityList;
    }
}
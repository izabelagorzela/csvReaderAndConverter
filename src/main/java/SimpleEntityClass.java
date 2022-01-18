import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@AllArgsConstructor
public class SimpleEntityClass {

    private Integer id;
    private String name;
    private LocalDate date;
}
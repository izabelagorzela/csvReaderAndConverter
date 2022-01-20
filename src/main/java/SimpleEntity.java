import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class SimpleEntity {

    private Integer id;
    private String name;
    private LocalDate date;
}
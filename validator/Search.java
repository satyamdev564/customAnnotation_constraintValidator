

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import validator.PossibleDateTime;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Search {
 
    @PossibleDateTime(pattern = "yyyy-MM-dd", fallbackPatterns = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private String ArrivalDateTime;

}

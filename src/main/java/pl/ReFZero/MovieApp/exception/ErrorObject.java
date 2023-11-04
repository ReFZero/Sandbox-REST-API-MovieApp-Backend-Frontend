package pl.ReFZero.MovieApp.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorObject {
    private Integer statusCode;
    private String message;
    private Date timestamp;
}

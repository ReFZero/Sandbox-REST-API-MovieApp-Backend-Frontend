package pl.ReFZero.MovieApp.exception.customException;


public class MovieNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1;

    public MovieNotFoundException(String message){
        super(message);
    }
}

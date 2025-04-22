package pe.edu.upeu.sysalmacen.excepciones;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ModelNotFoundException extends RuntimeException{
    private HttpStatus status;

    public ModelNotFoundException(String message) {
        
    }

    public ModelNotFoundException(String message, HttpStatus status) {
        
    }
}
package br.com.inteliset.findserv.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class HandleExceptions {

    //ID invalido
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity handle404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity handle400Sql(SQLException ex){
        var error = ex.getMessage();
        System.out.println("Esse é o erro"+error);
        return ResponseEntity.badRequest().body(error);
    }//Melhorar a msg de retorno erro


    //Campos invalidos e devolvendo os campos que estão invalidos na resposta
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handle400(MethodArgumentNotValidException ex) {
        var error = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(error.stream().map(ValidationErrorDate::new).toList());
    }

    //criar metodo para tratar erro ao persistir um cpf ja cadastrado!!!
    private record ValidationErrorDate (String field, String message) {

        public ValidationErrorDate(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }


}


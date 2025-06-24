package com.github.tomitaaa.backend.exception;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import com.github.tomitaaa.backend.dto.RespostaErro;

@RestControllerAdvice
public class ExcecaoGlobal{
	//metodo global
     @ExceptionHandler(MethodArgumentNotValidException.class)
     public ResponseEntity<RespostaErro> validacao(MethodArgumentNotValidException ex, WebRequest request){
       List<String> erros = ex.getBindingResult().getFieldErrors()
         .stream().map(err -> err.getField() + ": " + err.getDefaultMessage()).collect(Collectors.toList());
         
          RespostaErro respostaErro = new RespostaErro(HttpStatus.BAD_REQUEST.value(),
         "Erro de Validação", "Campos Inválidos",request.getDescription(false),
          erros);
          return new ResponseEntity<>(respostaErro, HttpStatus.BAD_REQUEST);
     }
}
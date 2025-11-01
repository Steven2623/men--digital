package com.menudigital.menuapi.common;
import org.springframework.http.*; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiResponse<Object>> v(MethodArgumentNotValidException ex){
    Map<String,String> errors=new HashMap<>(); ex.getBindingResult().getFieldErrors().forEach(fe->errors.put(fe.getField(),fe.getDefaultMessage()));
    return ResponseEntity.badRequest().body(ApiResponse.builder().success(false).message("Validation error").data(errors).build());
  }
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResponse<Object>> other(Exception ex){
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.builder().success(false).message(ex.getMessage()).build());
  }
}

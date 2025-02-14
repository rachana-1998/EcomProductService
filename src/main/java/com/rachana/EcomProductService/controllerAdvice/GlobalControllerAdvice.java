package com.rachana.EcomProductService.controllerAdvice;

import com.rachana.EcomProductService.dto.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.ParseException;

@ControllerAdvice
public class GlobalControllerAdvice {

@ExceptionHandler(value= ParseException .class)
    public ResponseEntity<ErrorMessageDTO> handleNullointerException(Exception ex){
    ErrorMessageDTO errorMessageDTO=new ErrorMessageDTO();
        errorMessageDTO.setErrorCode(ex.getMessage());
        errorMessageDTO.setErrorCode("404");
        return new ResponseEntity<>(errorMessageDTO,HttpStatus.NOT_FOUND);
    }
}

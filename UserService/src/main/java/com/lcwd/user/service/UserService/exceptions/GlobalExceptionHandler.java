package com.lcwd.user.service.UserService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lcwd.user.service.UserService.payload.ApiResponse;



@RestControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ApiResponse> handlerResponseNotFoundException(ResourceNotFoundException ex)
{
	String message= ex.getMessage();
	ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	
//	ApiResponse response = new ApiResponse();
//	response.setMessage(message);
//	response.setSuccess(true);
//	response.setStatus(HttpStatus.NOT_FOUND);
//	return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

			}
}

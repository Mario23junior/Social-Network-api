package com.project.socialnetwork.fieldError;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.ws.rs.core.Response;

public class ResponseErro {

	public static final Integer DEFINICIAN_STATUS_RESPONSE = 422; 
	
	private String message;
	private Collection<FieldErro> erros;
	

	public ResponseErro(String message, Collection<FieldErro> erros) {
		super();
		this.message = message;
		this.erros = erros;
	}

	public static <T> ResponseErro createFromValidation(Set<ConstraintViolation<T>> violations) {
		List<FieldErro> errors = violations.stream()
				.map(cv -> new FieldErro(cv.getPropertyPath()
						.toString(),
						cv.getMessage()))
				.collect(Collectors.toList());

		String message = "Validation error";
		var responseErro = new ResponseErro(message, errors);

		return responseErro;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Collection<FieldErro> getErros() {
		return erros;
	}

	public void setErros(Collection<FieldErro> erros) {
		this.erros = erros;
	}
	
	public Response withStatusCode(int code) {
		return Response.status(code).entity(this).build();
		
	}

}

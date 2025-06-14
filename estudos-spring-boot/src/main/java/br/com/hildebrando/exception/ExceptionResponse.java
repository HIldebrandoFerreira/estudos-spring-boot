package br.com.hildebrando.exception;

import java.util.Date;

public record ExceptionResponse(Date timestemp, String message, String details) {}

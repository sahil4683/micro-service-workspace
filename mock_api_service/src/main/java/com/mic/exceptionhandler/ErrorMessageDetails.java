package com.mic.exceptionhandler;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public class ErrorMessageDetails {
	LocalDateTime timestamp;
	String message;
	String details;
	Object errors;
}
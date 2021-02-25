package com.joghar.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ResponsePayload {
	int status;
	String message;
	Object body;
}

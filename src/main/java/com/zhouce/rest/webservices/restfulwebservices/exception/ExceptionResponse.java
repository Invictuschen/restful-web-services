package com.zhouce.rest.webservices.restfulwebservices.exception;

import java.util.Date;

// it's an entity
public class ExceptionResponse {
	// timestamp that the exception happended 
			private Date timestamp;
			// message
			private String message;
			// detail
			private String detail;
			public ExceptionResponse(Date timestamp, String message, String detail) {
				super();
				this.timestamp = timestamp;
				this.message = message;
				this.detail = detail;
			}
			public Date getTimestamp() {
				return timestamp;
			}
			public String getMessage() {
				return message;
			}
			public String getDetail() {
				return detail;
			}
	
	 
	
}

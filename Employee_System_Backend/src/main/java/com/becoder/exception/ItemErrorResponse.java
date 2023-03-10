package com.becoder.exception;
/*
 
i taken this error handling exception code from.........
https://www.onlinetutorialspoint.com/spring-boot/spring-boot-exception-handling-rest-service-crud-operations.html
you can check it for more details 
 
 */
 
public class ItemErrorResponse {

//    private int status;
//
//    public ItemErrorResponse() {
//    }
//
//    private String message;
//    private  long timeStamp;
//
//    public ItemErrorResponse(int status, String message, long timeStamp) {
//        this.status = status;
//        this.message = message;
//        this.timeStamp = timeStamp;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public long getTimeStamp() {
//        return timeStamp;
//    }
//
//    public void setTimeStamp(long timeStamp) {
//        this.timeStamp = timeStamp;
//    }
	
	
	// printing only message 
	private String message;
	
	public ItemErrorResponse() {
	}
	
	public ItemErrorResponse(String message) {
		this.message=message;
	}
	
	public String getMessage() {
	  return message;
	}
	
	public void setMessage(String message) {
	  this.message = message;
	}
}
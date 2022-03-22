package com.cg.exception;

import java.time.LocalDateTime;

public class ErrorInfo 
{
  private String msg;
  private String url;
  private LocalDateTime date;
  private String validationMsg;
  /*
   * Here we created constructor for ErrorInfo class and getters and setters for all ErrorInfo variables.
   */
  public ErrorInfo(String msg, String url, LocalDateTime date) 
  {
	super();
	this.msg = msg;
	this.url = url;
	this.date = date;
 }
 public ErrorInfo(String msg, String url, LocalDateTime date, String validationMsg) 
 {
	super();
	this.msg = msg;
	this.url = url;
	this.date=date;
	this.validationMsg = validationMsg;
 }
 public String getMsg() 
 {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public String getValidationMsg() {
		return validationMsg;
	}
	public void setValidationMsg(String validationMsg) {
		this.validationMsg = validationMsg;
	}
	public void setDate(LocalDateTime date) 
	{
		this.date = date;
	}
}


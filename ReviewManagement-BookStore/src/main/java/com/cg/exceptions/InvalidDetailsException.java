package com.cg.exceptions;
/************************************************************************************
 *          @author          Vaishnavi Voorelli
 *          Description      It is a class that provides exception handling for necessary methods  
 *         Version             1.0
 *         Created Date     05-10-2020
 ************************************************************************************/

@SuppressWarnings("serial")
public class InvalidDetailsException extends Exception{
	public InvalidDetailsException(String error_Msg) {
		super(error_Msg);
	}
}
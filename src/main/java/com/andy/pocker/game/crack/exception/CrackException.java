/**
 * Project: crack
 * 
 * File Created at 2016年3月2日
 * andydu
 * 
 * Copyright 2015 Dafy Finance Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Dafy Finance Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with http://www.dafy.com.
 */
package com.andy.pocker.game.crack.exception;

/**
 * @author andy du
 * @since 2016年3月2日 下午3:29:27
 */
public class CrackException extends Exception{
	
	private static final long serialVersionUID = -123736039387541390L;

	public CrackException (String message) {
		super(message);
	}
	
	public CrackException(String message, Exception e) {
		super(message, e);
	}
}

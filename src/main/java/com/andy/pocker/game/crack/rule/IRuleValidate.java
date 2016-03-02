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
package com.andy.pocker.game.crack.rule;

import java.util.List;

import com.andy.pocker.game.crack.domain.Pocker;
import com.andy.pocker.game.crack.exception.CrackException;

/**
 * 规则接口
 * @author andy du
 * @since 2016年3月2日 下午3:04:55
 */
public interface IRuleValidate {
	
	public boolean isValid(List<Pocker> pockers) throws CrackException;
	
	/**
	 * 1 A > B 
	 * 0 A = B
	 * -1 A < B
	 * @param pockerA last turn 上乱出牌方，扑克
	 * @param pockerB current turn 本轮出牌方
	 * @return
	 */
	public int compareTwoPockers(List<Pocker> pockerA ,List<Pocker> pockerB) throws CrackException;
}

/**
 * Project: EighteenMess
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
package com.andy.pocker.game.crack.domain;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

/**
 * 打牌的人
 * @author andy du
 * @since 2016年3月2日 下午2:40:45
 */
@Setter
@Getter
public class Gambler {
	public Map<String,Pocker> pockers;
	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		Set<Entry<String, Pocker>> entrySet = pockers.entrySet();
		for( Entry<String, Pocker> entry: entrySet) {
			buf.append(entry.getValue().getColor() + "" + entry.getValue().getPoint() + ",");
		}
		return buf.toString();
	}
}

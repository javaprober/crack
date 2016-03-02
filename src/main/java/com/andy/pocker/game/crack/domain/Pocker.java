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

import com.andy.pocker.game.crack.constants.PockerColor;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author andy du
 * @since 2016年3月2日 下午2:32:54
 */
@Setter
@Getter
@ToString
public class Pocker {
	/**
	 * 扑克牌点数
	 */
	private Integer point;
	/**
	 * 扑克牌 花色
	 */
	private PockerColor color;
	
	public Pocker(Integer point , Integer color) {
		this.point = point;
		this.color = PockerColor.getPockerColor(color);
	}
	
	public Pocker() {
		
	}
}

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
package com.andy.pocker.game.crack.constants;

/**
 * @author andy du
 * @since 2016年3月2日 下午2:34:27
 */
public enum PockerColor {
	
	/** 黑桃 **/
	SPADE(1,"黑桃"),
	/** 红心 **/
	HEART(2,"红心"),
	/** 梅花 **/
	CLUB(3,"梅花"),
	/** 方块 **/
	DIAMOND(4,"方块");
	
	PockerColor(Integer tag , String desc) {
		this.tag = tag;
		this.desc = desc;
	}
	
	private String desc;
	private Integer tag;
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getTag() {
		return tag;
	}
	public void setTag(Integer tag) {
		this.tag = tag;
	}
	
	public static PockerColor getPockerColor(Integer tag) {
		for(PockerColor pc : values()) {
			if(pc.getTag() == tag) {
				return pc;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return this.desc;
	}
}

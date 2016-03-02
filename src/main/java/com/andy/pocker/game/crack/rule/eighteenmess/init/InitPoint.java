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
package com.andy.pocker.game.crack.rule.eighteenmess.init;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.andy.pocker.game.crack.domain.Gambler;
import com.andy.pocker.game.crack.domain.Pocker;

/**
 * @author andy du
 * @since 2016年3月2日 下午4:27:22
 */
public class InitPoint {

//	private static Integer [] aPoints = {1,1,11,11};
	private static Integer [] bPoints = {2,3,4,4,5,5,6,6,7,7,9,9,12,12,12,13,13,13};
	public static int b_nonius = 0;
	
	public static Gambler getGamerA() {
		Gambler ga = new Gambler();
		Map<String,Pocker> pockers = new HashMap<String, Pocker>();
		
		pockers.put("1_1", new Pocker(1,1));
		pockers.put("1_2", new Pocker(1,2));
		pockers.put("11_1", new Pocker(11,1));
		pockers.put("11_2", new Pocker(11,2));
		
		return ga;
	}
	
	public static Gambler getGamerB() {
		Gambler ga = new Gambler();
		Map<String,Pocker> pockers = new HashMap<String, Pocker>();
		int i = 0;
		for(Integer b : bPoints) {
			//求模
			int c_nonius = i * 4 ;
			//获取当前 与运算十六进制分割值  如: 11,1100,110000
			int m = (int) ((Math.pow(2,i*2)) + (Math.pow(2,i*2+1)));
			//进行当前位置color计算
			int result = 0 ;
			if(c_nonius == 0) {
				result = (m&b_nonius) + 1;
			} else {
				result = (m&b_nonius) / c_nonius + 1;
			}
			//递归获取 可用color，处理对子，三对情况下的问题
			Pocker pocker = getPocker(b, result, pockers);
			
			pockers.put(pocker.getPoint()+"_" +pocker.getColor().getTag(), pocker);
			i ++;
		}
		ga.setPockers(pockers);
		return ga;
	}
	
	/**
	 * @param ponit 当前点数
	 * @param color 当前花色
	 * @param pockers 已初始扑克
	 * @param m 求模
	 * @param n 进次数
	 * @return
	 */
	public static Pocker getPocker(Integer ponit , Integer color , Map<String,Pocker> pockers) {
		String key = ponit + "_" + color;
		Pocker pocker = pockers.get(key);
		if(pocker == null) {
			return new Pocker(ponit, color);
		} else {
			return getPocker(ponit,color+1, pockers);
		}
	}
	
	
	public static void main(String[] args) {
		Gambler gamerB = getGamerB();
		Map<String, Pocker> pockers = gamerB.getPockers();
		Set<Entry<String, Pocker>> entrySet = pockers.entrySet();
		int i = 0 ;
		for( Entry<String, Pocker> entry: entrySet) {
			i ++;
			System.out.println(i);
			System.out.println(entry.getValue());
		}
//		68 719 476 736
		System.out.println(Math.pow(2,36));
	}
}

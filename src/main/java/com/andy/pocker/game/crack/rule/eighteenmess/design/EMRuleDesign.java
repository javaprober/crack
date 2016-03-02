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
package com.andy.pocker.game.crack.rule.eighteenmess.design;

import java.util.Collections;
import java.util.List;

/**
 * @author andy du
 * @since 2016年3月2日 下午3:09:10
 */
public class EMRuleDesign {
	
	/**
	 * 打出扑克 合法校验
	 * @param pointArr
	 * @param colorArr
	 * @return
	 */
	public static boolean validate(List<Integer> pointArr, List<Integer> colorArr) {
		if(pointArr.size() == colorArr.size()) {
			
			if(pointArr.size() == 5) {
				//顺子、同花、3带对
				if(straightValidate(pointArr) || tierceValidate(colorArr) || pairValidate(pointArr)) {
					return true;
				}
			}
			if(pointArr.size() == 2) {
				if(pairValidate(pointArr)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 顺子校验
	 * @param pointArr
	 * @return
	 */
	public static boolean straightValidate(List<Integer> pointArr) {
		
		if(pointArr.size() == 5) {
			Collections.sort(pointArr);
			for(int i = 0 ; i < pointArr.size() - 1  ; i ++) {
				if(pointArr.get(i + 1) - pointArr.get(i) != 1) {
					return false;
				}
			}
			return true;
		}	
		
		return false;
	}
	
	/**
	 * 同花校验
	 * @param colorArr
	 * @return
	 */
	public static boolean tierceValidate(List<Integer> colorArr) {
		
		if(colorArr.size() == 5) {
			int first = colorArr.get(0);
			for(int i = 1 ; i < colorArr.size() ; i ++) {
				if(colorArr.get(i) != first) {
					return false;
				}
			}
			return true;
		}	
		return false;
	}
	
	/**
	 * 对子/3带 一对校验
	 * @param pointArr
	 * @param colorArr
	 * @return
	 */
	public static boolean pairValidate(List<Integer> pointArr) {
		if(pointArr.size() == 2) {
			//首先判断点数一样
			if(pointArr.get(0) == pointArr.get(1)) {
				return true;
			}
		}
		if(pointArr.size() == 5) {
			//判断3带 一对
			int a = -100;
			int b = -100;
			int n = 0 ; 
			for(Integer point : pointArr) {
				if(point < 0 || point > 13) {
					return false;
				}
				//首次
				if(a == -100 && b == -100) {
					a = point;
					n = n + 1;
				} 
				//a已赋值情况
				else if(a != -100 && b == -100) {
					if(a == point) {
						n = n + 1;
					} else {
						b = point;
						n = n + 2;
					} 
				} else {
					//a/b都已经赋值
					if(a == point) {
						n = n + 1;
					} else if ( b == point) {
						n = n + 2;
					} else {
						return false;
					}
				}
			}
			if( n == 8 || n == 7) {
				return true;
			}
		}
		
		return false;
	}
}

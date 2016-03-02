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
package com.andy.pocker.game.crack.rule.eighteenmess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.andy.pocker.game.crack.domain.Pocker;
import com.andy.pocker.game.crack.exception.CrackException;
import com.andy.pocker.game.crack.rule.IRuleValidate;
import com.andy.pocker.game.crack.rule.eighteenmess.design.EMRuleDesign;
import com.google.common.base.Function;
import com.google.common.collect.Maps;

/**
 * @author andy du
 * @since 2016年3月2日 下午3:06:54
 */
public class RuleValidateImpl implements IRuleValidate{
	
	
	public static Map<Integer, Pocker> wrapPocker(List<Pocker> pockers) {
	    return Maps.uniqueIndex(pockers, function());
	}
	 
	public static Function<Pocker, Integer> function() {
	    return new Function<Pocker, Integer>() {

	    	public Integer apply(Pocker pocker) {
	            return pocker.getPoint();
	        }
	        
	    };
	}
	
	public boolean isValid(List<Pocker> pockers) throws CrackException{
		if(pockers == null || pockers.size() <= 0) {
			return false;
		}
		Map<Integer, Pocker> pockersMap = RuleValidateImpl.wrapPocker(pockers);
		Set<Entry<Integer, Pocker>> entrySet = pockersMap.entrySet();
		List<Integer> pointArr = new ArrayList<Integer>();
		List<Integer> colorArr = new ArrayList<Integer>();
		for(Entry<Integer, Pocker> entry : entrySet) {
			Integer point = entry.getKey();
			pointArr.add(point);
			Pocker value = entry.getValue();
			colorArr.add(value.getPoint()); 
		}
		if(pointArr.size() != colorArr.size()) {
			throw new CrackException("扑克牌初始化 缺少花色或者缺少点数");
		}
		return EMRuleDesign.validate(pointArr, colorArr);
	}

	public int compareTwoPockers(List<Pocker> pockerA, List<Pocker> pockerB) throws CrackException{
		//前提:出牌方案已经确定合法
		//此处不再做校验
		
		//只校验2张和一张扑克大小
		if(pockerA.size() != pockerB.size()) {
			throw new CrackException("出牌结果不对照");
		}
		if(pockerA.size() > 2 || pockerA.size() == 0) {
			throw new CrackException("出牌数不符合规则");
		}
		
		if(pockerA.size() == 1) {
			Pocker a = pockerA.get(0);
			Pocker b = pockerB.get(0);
			if(a.getPoint() < 3 && b.getPoint() > 2) {
				return 1;
			}

			if(a.getPoint() > 2 && b.getPoint() < 3) {
				return -1;
			}

			if(a.getPoint() > b.getPoint()) {
				return 1;
			}
			if(a.getPoint() == b.getPoint()) {
				return 0;
			}
			if(a.getPoint() < b.getPoint()) {
				return -1;
			}
		}
		return 0;
	}

}

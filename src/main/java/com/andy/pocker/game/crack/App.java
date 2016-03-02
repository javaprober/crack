package com.andy.pocker.game.crack;

import com.andy.pocker.game.crack.domain.Gambler;
import com.andy.pocker.game.crack.rule.eighteenmess.init.InitPoint;

/**
 *
 */
public class App {
	
	
	
	public static void main(String[] args) {
		
		//初始化 双方,牌库
		InitPoint.b_nonius = 0;
		
		Gambler gamerA = InitPoint.getGamerA();
		Gambler gamerB = InitPoint.getGamerB();
		
		//出牌
		
		//赢牌过程
		
		System.out.println("Hello World!");
	}
}

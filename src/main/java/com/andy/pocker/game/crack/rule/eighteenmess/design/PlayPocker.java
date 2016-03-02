package com.andy.pocker.game.crack.rule.eighteenmess.design;

import com.andy.pocker.game.crack.domain.Gambler;
import com.andy.pocker.game.crack.domain.Pocker;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Set;

/**
 * Created by apple on 16/3/2.
 */
public class PlayPocker {

    public static void play(Gambler a ,Gambler b , int n) {
        Map<String, Pocker> aPockers = a.getPockers();
        Map<String, Pocker> bPockers = b.getPockers();


        Set<String> aKeySet = aPockers.keySet();
        Set<String> bKeySet = bPockers.keySet();
        //n 表示出几张扑克
        if( n == 1) {

        }
    }

//    public static
}



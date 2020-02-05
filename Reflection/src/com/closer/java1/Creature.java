package com.closer.java1;

import java.io.Serializable;

/**
 * <p>Creature</p>
 * <p>description</p>
 *
 * @author closer
 * @version 1.0.0
 * @date 2020-02-05 16:02
 */
public class Creature<T> implements Serializable {
    public char gender;
    private double weight;

    public Creature() {
        this.gender = 'm';
        this.weight = 90;
    }

    public void breath() {
        System.out.println("生物呼吸");
    }
    public void eat() {
        System.out.println("生物吃东西");
    }
}


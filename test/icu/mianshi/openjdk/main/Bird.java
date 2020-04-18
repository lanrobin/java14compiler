package icu.mianshi.openjdk.main;

import java.util.*;

import icu.mianshi.openjdk.ref.*;

public class Bird extends Animal {

    public Wing leftWing = new Wing();
    public Wing rightWing = new Wing();

    public List<Object> featherList = new ArrayList<>();
    @Override
    public void move() {
        System.out.println("I am bird, I can fly.");
    }

    @Override
    public float weight() {
        return 1.0f;
    }

    private Nest nest = null;

    public Bird() {
        nest = new Nest();
    }

    public void growFeather() {
        for(int i = 0; i < 10; i++) {
            featherList.add(new Feather());
        }
    }

    public static String MOVEMENT = "FLY";
}
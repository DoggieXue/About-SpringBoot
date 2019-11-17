package com.cloud.xue.other;

import java.util.Random;

/**
 * @version: v1.0.0
 * Created by xuexiao on 2018-07-09 12:22:35.
 */
public class PoliTest {

    public Parent generate(){
        Random random = new Random();
        int result = random.nextInt(3);
        switch (result){
            case 0:
                return new Child1();
            case 1:
                return new Child2();
            case 2:
                return new Child3();
        }

        return null;
    }

    public static void main(String[] args) {
        PoliTest pt = new PoliTest();
        Parent parent = pt.generate();
        parent.doSomething();
    }
}

class Parent{
    public void doSomething(){
        System.out.println("parent");
    }
}

class Child1 extends Parent {

    public void doSomething(){
        System.out.println("Child1");
    }
}

class Child2 extends Parent {

    public void doSomething(){
        System.out.println("Child2");
    }
}

class Child3 extends Parent {

    public void doSomething(){
        System.out.println("Child3");
    }
}

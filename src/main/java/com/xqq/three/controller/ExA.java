package com.xqq.three.controller;

/**
 * @author xuqiangqiang
 * @Date: 2018/6/15 15:59
 * @Description:
 */
public class ExA {
    static {
        System.out.println("1");
    }

    public ExA(int i) {
        System.out.println("7");
    }


    {
        System.out.println("3");
    }


}

class ExB extends ExA {
    static {
        System.out.println("4。");
    }

    {
        System.out.println("5。");
    }

    public ExB() {
        super(8);
        System.out.println("6。");
    }


    public static void main(String[] args) {
        new ExB();
    }
}

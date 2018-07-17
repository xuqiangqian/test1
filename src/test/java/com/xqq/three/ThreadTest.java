package com.xqq.three;

public class ThreadTest {

    public static void main(String[] args) {
        // 创建一个账户，里面有存款5000元
        Account account = new Account(5000);
        // 模拟取钱过程
        GetMoney getMoney = new GetMoney(account);
        new Thread(getMoney, "你").start();
        new Thread(getMoney, "你老婆").start();
    }
}

class GetMoney implements Runnable {

    private Account account;

    public GetMoney(Account account) {
        super();
        this.account = account;
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + "账户现在有"
                    + account.getMoney() + "元");
            // 使效果更明显，休眠10ms
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int money = account.getMoney() - 2000;
            account.setMoney(money);
            System.out.println(Thread.currentThread().getName() + "取了2000元，账户现在有"
                    + account.getMoney() + "元");
        }
    }

}




class Account {
    private int money;

    public Account(int money) {
        super();
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
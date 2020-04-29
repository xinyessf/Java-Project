package com.huanyu.fun.thread.communicate;

class InThrad extends Thread {
    private Res res;

    public InThrad(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (res) {
                if (count == 0) {
                    res.userName = "小张";
                    res.userSex = "男";
                } else {
                    res.userName = "小紅";
                    res.userSex = "女";
                }
                count = (count + 1) % 2;
            }
        }
    }
}

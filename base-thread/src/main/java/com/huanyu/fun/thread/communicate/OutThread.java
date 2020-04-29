package com.huanyu.fun.thread.communicate;

class OutThread extends Thread {
    private Res res;

    public OutThread(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (res) {
                System.out.println(res.userName + "--" + res.userSex);
            }
        }
    }

    public static void main(String[] args) {
        Res res = new Res();
        InThrad intThrad = new InThrad(res);
        OutThread outThread = new OutThread(res);
        intThrad.start();
        outThread.start();

    }
}

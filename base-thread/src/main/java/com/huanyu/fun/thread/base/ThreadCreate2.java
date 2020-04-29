package com.huanyu.fun.thread.base;

/**
 * @author
 * @version 1.0
 * @date
 */
public class ThreadCreate2 implements Runnable {
    private String name;

    public ThreadCreate2(String name) {
        this.name = name;
    }

    public ThreadCreate2() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println(Thread.currentThread().getName() + "==>" + i);
        }
    }

    public static void main(String[] args) {
        ThreadCreate2 rb = new ThreadCreate2();
        Thread t1 = new Thread(rb, "一号窗口");
        t1.start();
        Thread t2 = new Thread(rb, "二号窗口");
        t2.start();
    }

    /**
     * lambda方式创建
     *
     * @param
     * @return:
     * @author: sunsf
     * @date: 2020/4/23 22:32
     */
    static class LamdaDemo {
        public static void main(String[] args) {
            Runnable task = () -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Hello " + threadName);
            };

            task.run();
            Thread thread = new Thread(task);
            thread.start();

            System.out.println("Done!");
        }
    }


}

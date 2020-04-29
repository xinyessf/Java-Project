package com.huanyu.fun.thread.communicate1;


public class BaoZi  {

    public String xianer;

    public String pier;

    boolean  flag = false ;//包子资源 是否存在  包子资源状态

    public static void main(String[] args) {
        BaoZi baoZi = new BaoZi();
        BaoZiPu baoZiPu = new BaoZiPu("包子铺",baoZi);
        ChiHuo chiHuo = new ChiHuo("吃货",baoZi);

        baoZiPu.start();

        chiHuo.start();



    }
}
package TheGoldMiner;

import java.awt.*;

/**
 * @Description: 黄金类继承Object类、
 * @Title: Gold
 * @Package TheGoldMiner
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2023/10/24 22:32
 */
public class Gold extends Object{
    Gold(){
        this.x=(int)(Math.random()*700);
        this.y=(int)(Math.random()*550+300);
        this.m = 30;
        this.width = 52;
        this.height = 52;
        this.count = 4;
        this.img = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheGoldMiner/gold1.gif");
    }
}

class GoldMini extends Gold{
    GoldMini(){
        this.count = 2;
        this.m = 15;
        this.width = 36;
        this.height = 36;
        this.img = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheGoldMiner/gold0.gif");
    }
}

class GoldPlus extends Gold{
    GoldPlus(){
        this.count=8;
        this.x=(int)(Math.random()*650);
        this.m = 60;
        this.width = 105;
        this.height = 105;
        this.img = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheGoldMiner/gold2.gif");
    }
}

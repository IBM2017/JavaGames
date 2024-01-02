package TheGoldMiner;

import java.awt.*;

/**
 * @Description: 石头类
 * @Title: Rock
 * @Package TheGoldMiner
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2024/1/2 21:25
 */
public class Rock extends Object{
    Rock(){
        this.count=1;
        this.x=(int)(Math.random()*700);
        this.y=(int)(Math.random()*550+300);
        this.m=50;
        this.width = 71;
        this.height = 71;
        this.img = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheGoldMiner/rock1.png");
    }
}

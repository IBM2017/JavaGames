package TheGoldMiner;

import java.awt.*;

/**
 * @Description: 用来绘制游戏背景
 * @Title: Bg
 * @Package TheGoldMiner
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2023/10/23 22:23
 */
public class Bg {
     static int count=0;
     static int waterNum=3;
     static boolean waterFlag=false;
    Image bg = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheGoldMiner/bg.jpg");
    Image bgSky = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheGoldMiner/bg1.jpg");
    Image bgPeo = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheGoldMiner/peo.png");
    Image water = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheGoldMiner/water.png");

    void paintSelf(Graphics g){
        g.drawImage(bgSky,0,0,null);
        g.drawImage(bg,0,200,null);
        g.drawImage(bgPeo,310,50,null);
        drawShow(g,30,Color.BLACK,"积分:"+count,30,150);

        g.drawImage(water,450,40,null);
        drawShow(g,30,Color.BLACK,"*"+waterNum,510,70);

    }

    public static void drawShow(Graphics g,int size,Color color,String str,int x,int y){
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str,x,y);
    }

}

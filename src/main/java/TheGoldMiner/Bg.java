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
    Image bg = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheGoldMiner/bg.jpg");
    Image bgSky = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheGoldMiner/bg1.jpg");
    Image bgPeo = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheGoldMiner/peo.png");

    void paintSelf(Graphics g){
        g.drawImage(bgSky,0,0,null);
        g.drawImage(bg,0,200,null);
        g.drawImage(bgPeo,310,50,null);
    }

}

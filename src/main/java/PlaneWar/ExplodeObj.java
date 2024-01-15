package PlaneWar;

import java.awt.*;

/**
 * @Description: 爆炸类
 * @Title: ExplodeObj
 * @Package PlaneWar
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2024/1/15 23:19
 */
public class ExplodeObj extends GameObj{
    static Image[] pic = new Image[16];

    int explodeCount = 0;

    static {
        for (int i = 0; i < pic.length; i++) {
            pic[i]=Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/PlaneWar/explode/e"+(i+1)+".gif");
        }
    }

    @Override
    public void paintSelf(Graphics g) {
        if (explodeCount<16){
            img = pic[explodeCount];
            super.paintSelf(g);
            explodeCount++;
        }
    }

    public ExplodeObj(int x, int y) {
        super(x, y);
    }
}

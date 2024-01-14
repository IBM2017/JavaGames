package PlaneWar;

import java.awt.*;

/**
 * @Description: 背景类
 * @Title: BgObj
 * @Package PlaneWar
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2024/1/14 18:53
 */
public class BgObj extends GameObj{
    public BgObj(){

    }

    public BgObj(Image image,int x,int y,double speed) {
        super(image,x,y,speed);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        y+=speed;
        if (y>=0){
            y=-2000;
        }
    }
}

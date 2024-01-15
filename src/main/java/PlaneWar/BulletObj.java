package PlaneWar;

import java.awt.*;

/**
 * @Description: Boss子弹类
 * @Title: BulletObj
 * @Package PlaneWar
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2024/1/15 22:34
 */
public class BulletObj extends GameObj{
    public BulletObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        y+=speed;
//        敌方子弹与我方飞机碰撞检测
        if (this.getRec().intersects(this.frame.planeObj.getRec())){
            GameWin.state=3;
        }
//        敌方子弹越界消失 条件y>600 改变后的坐标为(-300,300)
        if (this.y>600){
            this.x=-300;
            this.y=300;
            GameUtils.removeList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}

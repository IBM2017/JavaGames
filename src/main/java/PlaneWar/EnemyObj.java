package PlaneWar;

import java.awt.*;

/**
 * @Description: 敌方飞机类
 * @Title: EnemyObj
 * @Package PlaneWar
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2024/1/14 21:54
 */
public class EnemyObj extends GameObj{
    public EnemyObj() {
        super();
    }

    public EnemyObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        y+=speed;
//        敌我飞机碰撞检测
        if (this.getRec().intersects(this.frame.planeObj.getRec())){
            GameWin.state=3;
        }
//        敌机越界消失 判断条件y>600 改变后的坐标(-200,-200)
        if (this.y>600){
            this.x = -200;
            this.y = 200;
            GameUtils.removeList.add(this);
        }
//        敌机消失前移动至（-200，-200） 我方子弹(-100,100)
        for (ShellObj shellObj:GameUtils.shellObjList) {
            if (this.getRec().intersects(shellObj.getRec())){
                ExplodeObj explodeObj = new ExplodeObj(x,y);
                GameUtils.explodeObjList.add(explodeObj);
                GameUtils.removeList.add(explodeObj);
                shellObj.setX(-100);
                shellObj.setY(100);
                this.x = -200;
                this.y = 200;
                GameUtils.removeList.add(shellObj);
                GameUtils.removeList.add(this);
                GameWin.score++;
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}

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
        for (ShellObj shellObj:GameUtils.shellObjList) {
            if (this.getRec().intersects(shellObj.getRec())){
                shellObj.setX(-100);
                shellObj.setY(100);
                this.x = -200;
                this.y = 200;
                GameUtils.removeList.add(shellObj);
                GameUtils.removeList.add(this);
            }
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}

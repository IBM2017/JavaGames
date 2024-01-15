package PlaneWar;

import java.awt.*;

/**
 * @Description: boss类
 * @Title: BossObj
 * @Package PlaneWar
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2024/1/15 22:26
 */
public class BossObj extends GameObj{

    int life = 10;
    public BossObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }


    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        if (x>550 || x<-50){
            speed=-speed;
        }
        x+=speed;
        for (ShellObj shellObj:GameUtils.shellObjList){
            if (this.getRec().intersects(shellObj.getRec())){
                shellObj.setX(-100);
                shellObj.setY(100);
                GameUtils.removeList.add(shellObj);
                life--;
            }
            if (life<=0){
                GameWin.state=4;
            }
        }

//        血条背景为白色
        g.setColor(Color.white);
        g.fillRect(20,40,100,10);
//        血条的绘制
        g.setColor(Color.red);
        g.fillRect(20,40,life*10,10);
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}

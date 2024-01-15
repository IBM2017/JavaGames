package PlaneWar;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Description: 创建飞机类
 * @Title: PlaneObj
 * @Package PlaneWar
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2024/1/14 20:59
 */
public class PlaneObj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public PlaneObj() {
        super();
    }

    public PlaneObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
        this.frame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
//                if (GameWin.state==1){
                    PlaneObj.super.x=e.getX()-11;
                    PlaneObj.super.y=e.getY()-16;
//                }
            }
        });
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
//        我方飞机与敌方boss的碰撞检测
        if (this.frame.bossObj!=null&&this.getRec().intersects(this.frame.bossObj.getRec())){
            GameWin.state=3;
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}

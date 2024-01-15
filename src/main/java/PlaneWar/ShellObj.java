package PlaneWar;

import java.awt.*;

/**
 * @Description: 子弹类
 * @Title: ShellObj
 * @Package PlaneWar
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2024/1/14 21:16
 */
public class ShellObj extends GameObj{
    @Override
    public Image getImg() {
        return super.getImg();
    }

    public ShellObj() {
        super();
    }

    public ShellObj(Image img, int x, int y, int width, int height, double speed, GameWin frame) {
        super(img, x, y, width, height, speed, frame);
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        y-=speed;
//        我方子弹的越界消失条件 y<0 改变后的坐标(-100,100);
        if(y<0){
            this.x=-100;
            this.y=100;
            GameUtils.removeList.add(this);
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}

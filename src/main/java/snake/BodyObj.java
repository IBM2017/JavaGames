package snake;

import java.awt.*;

/**
 * @Description: 蛇身体
 * @Title: BodyObj
 * @Package snake
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2024/1/11 22:17
 */
public class BodyObj extends GameObj{
    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
    }

    public BodyObj(Image image, int x, int y, GameWin frame) {
        super(image, x, y, frame);
    }
}

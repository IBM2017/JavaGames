package TheGoldMiner;

import java.awt.*;

/**
 * @Description: 绘制矿工爪子红线
 * @Title: Line
 * @Package TheGoldMiner
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2023/10/23 22:29
 */
public class Line {
    //起始坐标点
    int x = 380;
    int y = 180;

    //终点坐标点
    int endx = 500;
    int endy = 500;

    //线长
    double length = 100;
    //角度系数
    double n = 0;

    //方向
    int dir = 1;

    //红线状态：0 左右摇摆；1 伸长；2 收回
    int state = 0;
    void paintSelf(Graphics g){
        switch (state){
            case 0:
                if (n<0.1){
                    dir=1;
                } else if (n>0.9) {
                    dir=-1;
                }
                n+=(0.005*dir);
                break;
            case 1:
                if (length<500){
                    length+=10;
                }else {
                    state=2;
                }
                break;
            case 2:
                if (length>100){
                    length-=10;
                }else {
                    state=0;
                }
        }
        lines(g);
    }

    void lines(Graphics g){
        endx = (int) (x+length*Math.cos(n*Math.PI));
        endy = (int) (y+length*Math.sin(n*Math.PI));
        g.setColor(Color.red);
        g.drawLine(x,y,endx,endy);
    }
}

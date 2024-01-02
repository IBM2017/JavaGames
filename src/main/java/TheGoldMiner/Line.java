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

    Image hook = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheGoldMiner/hook.png");
    GameWin frame;
    Line(GameWin frame){
        this.frame=frame;
    }
    Object logic(){
        for (Object obj:this.frame.objectList) {
            if (endx>=obj.x&&endx<=obj.x+obj.width
                    && endy>=obj.y&&endy<=obj.y+obj.height){
                this.state=3;
                return obj;
            }
        }
        return null;
    }
    void paintSelf(Graphics g) throws InterruptedException {
        Object res = logic();
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
                if (endx>0&&endx<768&&endy<1000){
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
                break;
            case 3:
                if (length>100){
                    length-=10;
                    lines(g);
                    res.x = endx- res.getWidth()/2;
                    res.y = endy;
                    if (Bg.waterFlag){
                        if (res instanceof Gold){
                            res.m=1;
                        }
                        if (res instanceof Rock){
                            res.x = -150;
                            res.y = -150;
                            Bg.waterFlag =false;
                            state=2;
                            return;
                        }
                    }
                    //拉取缓慢效果
                    Thread.sleep(res.m);

                    return;
                }else {
                    res.x = -150;
                    res.y = -150;
                    Bg.waterFlag =false;
                    Bg.count+= res.count;
                    state=0;
                }

        }
        lines(g);
    }

    void lines(Graphics g){
        endx = (int) (x+length*Math.cos(n*Math.PI));
        endy = (int) (y+length*Math.sin(n*Math.PI));
        g.setColor(Color.red);
        g.drawLine(x-1,y,endx-1,endy);
        g.drawLine(x,y,endx,endy);
        g.drawLine(x+1,y,endx+1,endy);
        g.drawImage(hook,endx-36,endy-2,null);
    }


}

package snake;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 启动游戏
 * @Title: GameWin
 * @Package snake
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2024/1/8 22:29
 */
public class GameWin extends JFrame {

//    蛇头对象
    HeadObj headObj = new HeadObj(GameUtils.rightImg,30,600,this);
//    蛇的身体合集
    public List<BodyObj> bodyObjList = new ArrayList<>();
    public void launch(){
//        设置窗口是否可见
        this.setVisible(true);
//        设置窗口大小
        this.setSize(600,630);
//        设置窗口的位置是否为居中
        this.setLocationRelativeTo(null);
//        设置窗口的标题
        this.setTitle("贪吃蛇");
//        蛇身体的初始化
        bodyObjList.add(new BodyObj(GameUtils.bodyImg,30,570,this));
        bodyObjList.add(new BodyObj(GameUtils.bodyImg,0,570,this));

        while (true){
            repaint();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
//        设置背景色为灰色
        g.setColor(Color.gray);
        g.fillRect(0,0,600,630);
//        网格线
        g.setColor(Color.BLACK);

        for (int i = 0; i < 21; i++) {
            //        绘制横线
            g.drawLine(0,30*i,600,30*i);
            //        绘制竖线
            g.drawLine(30*i,0,30*i,630);
        }
//        绘制蛇的身体
        for (int i = bodyObjList.size()-1; i >=0; i--) {
            bodyObjList.get(i).paintSelf(g);
        }
//        绘制蛇头
        headObj.paintSelf(g);
//        super.paint(g);
    }

    public static void main(String[] args) {

        GameWin gameWin = new GameWin();
//        启动窗口
        gameWin.launch();
    }
}

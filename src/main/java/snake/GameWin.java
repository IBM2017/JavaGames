package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

//    分数
    public int score = 0;
//    游戏状态：0未开始 1游戏中 2暂停 3失败 4通关 5失败后重启
    public static int state = 0;
//    定义双缓存图片
    Image offScreenImage=null;
//    窗口宽高
    int winWidth = 800;
    int winHeight = 630;

//    蛇头对象
    HeadObj headObj = new HeadObj(GameUtils.rightImg,30,600,this);
//    蛇的身体合集
    public List<BodyObj> bodyObjList = new ArrayList<>();

//    食物
    FoodObj foodObj = new FoodObj().getFood();
    public void launch(){
//        设置窗口是否可见
        this.setVisible(true);
//        设置窗口大小
        this.setSize(winWidth,winHeight);
//        设置窗口的位置是否为居中
        this.setLocationRelativeTo(null);
//        设置窗口的标题
        this.setTitle("贪吃蛇");
//        蛇身体的初始化
        bodyObjList.add(new BodyObj(GameUtils.bodyImg,0,600,this));
        bodyObjList.add(new BodyObj(GameUtils.bodyImg,30,600,this));
//        键盘事件
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_SPACE){
                    switch (state){
//                        未开始
                        case  0:
                            state=1;
                            break;
//                        开始
                        case 1:
                            state=2;
                            repaint();
                            break;
//                        暂停
                        case 2:
                            state=1;
                            break;
//                        失败后重新开始
                        case 3:
                            state=5;
                            break;
                        default:
                            break;
                    }
                }
            }
        });
        while (true){
            if(state==1){
//                游戏中才调用
                repaint();
            }
//            失败重启
            if (state==5){
                state=0;
                resetGame();
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void paint(Graphics g) {
//        初始化双缓存图片
        if (offScreenImage==null){
            offScreenImage = this.createImage(winWidth,winHeight);
        }
//        获取图片对应的graphics对象
        Graphics sImage = offScreenImage.getGraphics();
//        设置背景色为灰色
        sImage.setColor(Color.gray);
        sImage.fillRect(0,0,winWidth,winHeight);
//        网格线
        sImage.setColor(Color.BLACK);

        for (int i = 0; i < 21; i++) {
            //        绘制横线
            sImage.drawLine(0,30*i,600,30*i);
            //        绘制竖线
            sImage.drawLine(30*i,0,30*i,630);
        }
//        绘制蛇的身体
        for (int i = bodyObjList.size()-1; i >=0; i--) {
            bodyObjList.get(i).paintSelf(sImage);
        }
//        绘制蛇头
        headObj.paintSelf(sImage);
//        绘制食物
        foodObj.paintSelf(sImage);
//        分数绘制
        GameUtils.drawWord(sImage,score+" 分",Color.BLUE,50,650,300);
//        绘制提示语
        sImage.setColor(Color.gray);
        prompt(sImage);
//        将双缓存图片绘制到窗口中
        g.drawImage(offScreenImage,0,0,null);
//        super.paint(g);
    }

//    绘制提示语
    void prompt(Graphics s){
//        未开始
        if (state==0){
            s.fillRect(120,240,400,70);
            GameUtils.drawWord(s,"按下空格开始游戏",Color.yellow,35,150,290);
        }
//        暂停
        if (state==2){
            s.fillRect(120,240,400,70);
            GameUtils.drawWord(s,"按下空格继续游戏",Color.yellow,35,150,290);
        }
//        失败
        if (state==3){
            s.fillRect(120,240,400,70);
            GameUtils.drawWord(s,"失败，按空格重新开始",Color.red,35,150,290);
        }
//        通关
        if (state==4){
            s.fillRect(120,240,400,70);
            GameUtils.drawWord(s,"达成条件，游戏通关",Color.green,35,150,290);
        }
    }

//    游戏重置
    void resetGame(){
//        关闭当前窗口
        this.dispose();
//        开启新的窗口
        String[] args = {};
        main(args);
    }
    public static void main(String[] args) {

        GameWin gameWin = new GameWin();
//        启动窗口
        gameWin.launch();
    }
}

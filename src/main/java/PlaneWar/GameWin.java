package PlaneWar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Description: 游戏运行主类
 * @Title: GameWin
 * @Package PlaneWar
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2024/1/14 17:51
 */
public class GameWin extends JFrame {

//    游戏状态 0未开始 1游戏中 2暂停 3通关失败 4通关成功
    static int state=0;

    Image offScreenImg = null;

//    重绘次数
    int count=1;
//    敌机数量
    int enemyCount = 0;
//    游戏得分
    static int score =0;

//    背景图对象
    BgObj bgObj = new BgObj(GameUtils.bgImg,0,-2000,2);

//    我方飞机对象
    PlaneObj planeObj = new PlaneObj(GameUtils.planeImg,290,550,20,30,0,this);

//    敌方BOSS对象
    BossObj bossObj = null;
//    游戏窗口宽度
    private static int GameWidth=600;
//    游戏窗口高度
    private static int Gameeheight=600;

    public void launch(){
        //    设置窗口是否可见
        this.setVisible(true);
        //    设置窗口大小
        this.setSize(GameWidth,Gameeheight);
        //    设置窗口位置
        this.setLocationRelativeTo(null);
        //    设置窗口标题
        this.setTitle("飞机大战");

        GameUtils.gameObjList.add(bgObj);
        GameUtils.gameObjList.add(planeObj);

//        鼠标点击事件
        this.addMouseListener(this.mouseAdapter());
//        空格键暂停功能
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==32){
                    switch (state){
                        case 1:
                            state=2;
                            break;
                        case 2:
                            state=1;
                            break;
                        default:
                            state=1;
                            break;
                    }
                }
            }
        });
//        重复绘制
        while (true){
//            System.out.println(2);
            if (state==1){
                createObj();
                repaint();
            }
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

//    鼠标点击事件
    public MouseAdapter mouseAdapter(){
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                游戏未开始时，点击鼠标左键启动游戏
                if (e.getButton()==1 && state==0){
                    state=1;
                }
            }
        };
    }

    @Override
    public void paint(Graphics g) {
        if (offScreenImg==null){
            offScreenImg = createImage(GameWidth,Gameeheight);

        }
        Graphics gImage = offScreenImg.getGraphics();
        gImage.fillRect(0,0,GameWidth,Gameeheight);
        if (state==0){
            gImage.drawImage(GameUtils.bgImg,0,0,null);
            gImage.drawImage(GameUtils.bossImg,220,120,null);
            gImage.drawImage(GameUtils.explodeImg,270,350,null);
            GameUtils.printStr(gImage,Color.YELLOW,"点击开始游戏",40,180,300);
        }
        if (state==1) {
            GameUtils.gameObjList.addAll(GameUtils.explodeObjList);
//            运行中
            for (int i = 0; i < GameUtils.gameObjList.size(); i++) {
                GameUtils.gameObjList.get(i).paintSelf(gImage);
            }
            GameUtils.gameObjList.removeAll(GameUtils.removeList);
        }
        if (state==3){
//            失败
            gImage.drawImage(GameUtils.explodeImg,planeObj.getX()-35,planeObj.getY()-50,null);
            GameUtils.printStr(gImage,Color.RED,"GAME OVER",50,180,300);
        }
        if (state==4){
//            通关
            gImage.drawImage(GameUtils.explodeImg,bossObj.getX()+30,bossObj.getY(),null);
            GameUtils.printStr(gImage,Color.green,"游戏通关",50,190,300);
        }
        GameUtils.printStr(gImage,Color.green,score+" 分",40,30,100);
        g.drawImage(offScreenImg,0,0,null);
        count++;

    }

    void createObj(){
//        我方子弹
        if (count%15==0){
            GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg,planeObj.getX()+3,planeObj.getY()-16,14,29,5,this));
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size()-1));
        }
//        创建敌机
        if (count%15==0){
            GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemyImg,(int)(Math.random()*12)*50,0,49,36,5,this));
            GameUtils.gameObjList.add(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size()-1));
            this.enemyCount++;
        }
        //        创建敌方boss子弹
        if (count%15==0&&bossObj!=null){
            GameUtils.bullletObjList.add(new BulletObj(GameUtils.bulletImg,bossObj.x+76,bossObj.y+85,15,25,5,this));
            GameUtils.gameObjList.add(GameUtils.bullletObjList.get(GameUtils.bullletObjList.size()-1));
        }

        if (this.enemyCount>1&&bossObj==null){
            bossObj = new BossObj(GameUtils.bossImg,250,35,155,100,5,this);
            GameUtils.gameObjList.add(bossObj);
        }
//        System.out.println(GameUtils.gameObjList.size());
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }

}

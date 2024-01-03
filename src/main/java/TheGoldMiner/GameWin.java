package TheGoldMiner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 游戏胜利界面
 * @Title: GameWin
 * @Package TheGoldMiner
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2023/10/23 21:34
 */
public class GameWin extends JFrame {
//    0未开始1运行中2商店3失败4胜利
    static int state;
    List<Object> objectList = new ArrayList<>();
    {
        outGold:for (int i = 0; i < 10; i++) {
            double random = Math.random();
            Gold gold = random<0.4?new Gold():random<0.7?new GoldMini():new GoldPlus();
            for (Object object:objectList){
                if(gold.getRec().intersects(object.getRec())){
                    i--;
                    continue outGold;
                }
            }
            objectList.add(gold);
        }
        outRock:for (int i = 0; i < 4; i++) {
            Rock rock = new Rock();
            for (Object object:objectList){
                if(rock.getRec().intersects(object.getRec())){
                    i--;
                    continue outRock;
                }
            }
            objectList.add(rock);
        }
    }
    Bg bg = new Bg();
    Line line = new Line(this);
//    Gold gold = new Gold();
    Image offScreenImage;
    void launch() throws InterruptedException {
        this.setVisible(true);
        this.setSize(768,1000);
        this.setLocationRelativeTo(null);
        this.setTitle("黄金矿工");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch (state){
                    case 0:
                        if (e.getButton()==3){
                            state=1;
                            bg.startTime = System.currentTimeMillis();
                        }
                        break;
                    case 1:
                        if (e.getButton()==1&&line.state==0){
                            line.state=1;
                        }
                        if (e.getButton()==3&&line.state==3&&!Bg.waterFlag&&Bg.waterNum>0){
                            Bg.waterFlag=true;
                            Bg.waterNum--;
                        }
                        break;
                    case 2:
                        if (e.getButton()==1){
                            bg.shop=true;
                        } else if (e.getButton()==3) {
                            state=1;
                            bg.startTime=System.currentTimeMillis();
                        }
                        break;
                    case 3:
                    case 4:
                        if (e.getButton()==1){
                            state=0;
                            bg.reGame();
                            line.reGame();
                        }
                        break;
                    default:
                }

            }
        });
        while (true){
            repaint();
            nextLevel();
            Thread.sleep(10);
        }
    }

    public void nextLevel() throws InterruptedException {
        //倒计时结束并且状态为运行时
        if (bg.gameTime()&&state==1) {
//            分数大于关卡分数进阶下一关，否则失败
            if (Bg.count>=bg.goal){
                if (Bg.level==5){
                    state=4;
                }else {
                    state=2;
                    Bg.level += 1;
                }
            }else {
                state=3;
            }
            dispose();
            GameWin gameWin = new GameWin();
            gameWin.launch();
        }
    }
    @Override
    public void paint(Graphics g) {
        offScreenImage = this.createImage(768,1000);
        Graphics gImage = offScreenImage.getGraphics();
        bg.paintSelf(gImage);
        if (state==1){
            for (Object obj: objectList) {
                obj.paintSelf(gImage);
            }
            try {
                line.paintSelf(gImage);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        g.drawImage(offScreenImage,0,0,null);
    }

    public static void main(String[] args) throws InterruptedException {
        GameWin gameWin=new GameWin();
        gameWin.launch();
    }
}

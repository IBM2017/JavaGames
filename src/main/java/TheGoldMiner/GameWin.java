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
    List<Object> objectList = new ArrayList<>();
    {
        out:for (int i = 0; i < 10; i++) {
            double random = Math.random();
            Gold gold = random<0.4?new Gold():random<0.7?new GoldMini():new GoldPlus();
            for (Object object:objectList){
                if(gold.getRec().intersects(object.getRec())){
                    i--;
                    continue out;
                }
            }
            objectList.add(gold);
        }
        for (int i = 0; i < 4; i++) {
            objectList.add(new Rock());
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
                if (e.getButton()==1&&line.state==0){
                    line.state=1;
                }
                if (e.getButton()==3&&line.state==3&&!Bg.waterFlag&&Bg.waterNum>0){
                    Bg.waterFlag=true;
                    Bg.waterNum--;
                }
            }
        });

        while (true){
            repaint();
            Thread.sleep(10);
        }
    }

    @Override
    public void paint(Graphics g) {
        offScreenImage = this.createImage(768,1000);
        Graphics gImage = offScreenImage.getGraphics();
        bg.paintSelf(gImage);

        for (Object obj: objectList) {
            obj.paintSelf(gImage);
        }
        try {
            line.paintSelf(gImage);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(offScreenImage,0,0,null);
    }

    public static void main(String[] args) throws InterruptedException {
        GameWin gameWin=new GameWin();
        gameWin.launch();
    }
}

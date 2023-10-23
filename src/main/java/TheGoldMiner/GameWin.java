package TheGoldMiner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @Description: 游戏胜利界面
 * @Title: GameWin
 * @Package TheGoldMiner
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2023/10/23 21:34
 */
public class GameWin extends JFrame {
    Bg bg = new Bg();
    Line line = new Line();
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
                if (e.getButton()==1){
                    line.state=1;
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
        bg.paintSelf(g);
        line.paintSelf(g);
    }

    public static void main(String[] args) throws InterruptedException {
        GameWin gameWin=new GameWin();
        gameWin.launch();
    }
}

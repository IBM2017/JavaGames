package snake;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * @Description: 蛇的头部
 * @Title: HeadObj
 * @Package snake
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2024/1/11 21:16
 */
public class HeadObj extends GameObj{
    //    方向 up down left right
    private  String direction = "right";

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

//    蛇的移动
    public void move(){
//        蛇身体的移动
        List<BodyObj> bodyObjList = this.frame.bodyObjList;
        for (int i = 1; i < bodyObjList.size(); i++) {
            bodyObjList.get(i).x=bodyObjList.get(i-1).x;
            bodyObjList.get(i).y=bodyObjList.get(i-1).y;
        }
        bodyObjList.get(0).x=this.x;
        bodyObjList.get(0).y=this.y;
//        蛇头的移动
        switch (direction){
            case "up":
                y-=height;
                break;
            case "down":
                y+=height;
                break;
            case "left":
                x-=width;
                break;
            case "right":
                x+=width;
                break;
        }
    }

    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
        move();
        //越界处理
        if (x<0){
            x=570;
        } else if (x>570) {
            x=0;
        } else if (y<30) {
            y=600;
        } else if (y>600) {
            y=30;
        }

    }

    public HeadObj(Image image, int x, int y, GameWin frame) {
        super(image, x, y, frame);
//        键盘监听事件
        this.frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                changeDirection(e);
            }
        });
    }

//    控制移动方向 w a d s
    public void changeDirection(KeyEvent e){
//        System.out.println(1);
        switch (e.getKeyCode()){
            case KeyEvent.VK_A:
                if (!"right".equals(direction)){
                    direction = "left";
                    image = GameUtils.leftImg;
                }
                break;
            case KeyEvent.VK_D:
                if (!"left".equals(direction)){
                    direction = "right";
                    image = GameUtils.rightImg;
                }
                break;
            case KeyEvent.VK_W:
                if (!"down".equals(direction)){
                    direction = "up";
                    image = GameUtils.upImg;
                }
                break;
            case KeyEvent.VK_S:
                if (!"up".equals(direction)){
                    direction = "down";
                    image = GameUtils.downImg;
                }
                break;
            default:
                break;

        }
    }

}


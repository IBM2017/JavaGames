package snake;

import java.awt.*;

/**
 * @Description: 游戏
 * @Title: GameObj
 * @Package snake
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2024/1/8 22:54
 */
public class GameObj {
//    图片
    Image image;
//    坐标
    int x;
    int y;
//    宽高
    int width = 30;
    int height = 30;
//窗口类的引用
    GameWin frame;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public GameWin getFrame() {
        return frame;
    }

    public GameObj(){

    }

    public GameObj(Image image, int x, int y, int width, int height, GameWin frame) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.frame = frame;
    }

    public void setFrame(GameWin frame) {
        this.frame = frame;
    }

    //物体绘制自身
    public void paintSelf(Graphics g){
        g.drawImage(image,x,y,null);
    }

    public GameObj(Image image, int x, int y, GameWin frame) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.frame = frame;
    }
}


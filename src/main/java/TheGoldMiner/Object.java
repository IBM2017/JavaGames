package TheGoldMiner;

import java.awt.*;

/**
 * @Description: 物体初始类
 * @Title: Object
 * @Package TheGoldMiner
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2023/10/23 23:24
 */
public class Object {
    //坐标
    int x,y;

    //宽高
    int width,height;

    //图片
    Image img;

    //质量
    int m;
    int count;

    void paintSelf(Graphics g){
        g.drawImage(img,x,y,null);
    }

    public int getWidth() {
        return width;
    }

    public Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }
}

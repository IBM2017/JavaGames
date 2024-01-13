package snake;

import java.awt.*;
import java.util.Random;

/**
 * @Description: 食物类
 * @Title: FoodObj
 * @Package snake
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2024/1/13 12:42
 */
public class FoodObj extends GameObj{
//    随机
    Random r = new Random();

    public FoodObj(){
        super();
    }
    public FoodObj(Image img,int x,int y,GameWin frame){
        super(img,x,y,frame);
    }
    //获取食物
    public FoodObj getFood(){
        return new FoodObj(GameUtils.foodImg,r.nextInt(20)*30,r.nextInt(20)*30+30,this.frame);
    }
    @Override
    public void paintSelf(Graphics g) {
        super.paintSelf(g);
    }
}

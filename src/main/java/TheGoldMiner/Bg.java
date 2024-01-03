package TheGoldMiner;

import java.awt.*;

/**
 * @Description: 用来绘制游戏背景
 * @Title: Bg
 * @Package TheGoldMiner
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2023/10/23 22:23
 */
public class Bg {
//    分数
     static int count=0;

//     等级
     static int level=1;

//     目标分数
     int goal=level*15;

//     药水数量
     static int waterNum=3;

//     使用药水状态
     static boolean waterFlag=false;

//     开始时间
     long startTime;

//     结束时间
     long endTime;

     //药水价格
     int price= (int) (Math.random()*10);

     //是否进入商店 f 不购买
     boolean shop = false;

//     绘制背景图：土地下层
    Image bg = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheGoldMiner/bg.jpg");

//    绘制背景图：土地上层
    Image bgSky = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheGoldMiner/bg1.jpg");

//    绘制旷工图片
    Image bgPeo = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheGoldMiner/peo.png");

//    绘制药水图片
    Image water = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheGoldMiner/water.png");

//    使用主界面画笔，绘制图片元素
    void paintSelf(Graphics g){

//        绘制天空和土地背景
        g.drawImage(bgSky,0,0,null);
        g.drawImage(bg,0,200,null);

//        根据游戏状态绘制图片和动作
        switch (GameWin.state){
//            当状态为开始前
            case 0:
//                绘制开始文字
                drawShow(g,80,Color.GREEN,"准备开始",200,400);
                break;
//            当状态为游戏进行时
            case 1:
//                绘制矿工
                g.drawImage(bgPeo,310,50,null);
//                绘制积分文字
                drawShow(g,30,Color.BLACK,"积分:"+count,30,150);
//                绘制药水图片
                g.drawImage(water,450,40,null);
//                绘制药水数量文字
                drawShow(g,30,Color.BLACK,"*"+waterNum,510,70);
//                绘制关卡数
                drawShow(g,20,Color.BLACK,"第"+level+"关",30,60);
//                绘制目标分数文字
                drawShow(g,30,Color.BLACK,"目标:"+goal,30,110);
//                统计结束时间
                endTime = System.currentTimeMillis();
//                使用结束时间减去开始时间制造20秒倒计时
                long tim = 20-(endTime-startTime)/1000;
//                绘制读秒文字
                drawShow(g,30,Color.BLACK,"时间:"+(tim>0?tim:0),520,150);
                break;
//            当状态为进入市场
            case 2:
//                绘制药水图片
                g.drawImage(water,300,400,null);
//                绘制药水价格和是否购买选择
                drawShow(g,30,Color.BLACK,"价格"+price,300,500);
                drawShow(g,20,Color.BLACK,"是否购买？",300,550);

                if (shop){
                    count = count-price;
                    waterNum++;
                    shop=false;
                    GameWin.state=1;
                    startTime=System.currentTimeMillis();
                }
                break;
            case 3:
                drawShow(g,80,Color.cyan,"失败",300,350);
                drawShow(g,80,Color.cyan,"积分:"+count,250,450);
                break;
            case 4:
                drawShow(g,80,Color.RED,"成功",300,350);
                drawShow(g,80,Color.RED,"积分:"+count,250,450);
                break;
            default:
        }
    }

//    t:倒计时完成 f:正在倒计时
    boolean gameTime(){
        long time = (endTime - startTime)/1000;
        if (time>20){
            return true;
        }
        return  false;
    }

//    重置元素
    void reGame(){
        count=0;
        level=1;
        goal=level*15;
        waterNum=3;
        waterFlag=false;
    }

//    绘制字符
    public static void drawShow(Graphics g,int size,Color color,String str,int x,int y){
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str,x,y);
    }

}

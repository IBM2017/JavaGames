package PlaneWar;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 游戏工具类
 * @Title: GameUtils
 * @Package PlaneWar
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2024/1/14 18:07
 */
public class GameUtils {
    //    背景图片
    public static Image bgImg = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/PlaneWar/bg.jpg");
    //    boss图片
    public static Image bossImg = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/PlaneWar/boss.png");
    //    爆炸图片
    public static Image explodeImg = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/PlaneWar/explode/e6.gif");
    //    我方战斗机图片
    public static Image planeImg = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/PlaneWar/plane.png");
    //    我方子弹图片
    public static Image shellImg = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/PlaneWar/shell.png");

    //    敌机图片
    public static Image enemyImg = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/PlaneWar/enemy.png");

    //    敌机子弹图片
    public static Image bulletImg = Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/PlaneWar/bullet.png");

    //    所有游戏物体的集合
    public static List<GameObj> gameObjList = new ArrayList<>();

//    我方子弹的集合
    public static List<ShellObj> shellObjList = new ArrayList<>();
    //    敌方子弹的集合
    public static List<BulletObj> bullletObjList = new ArrayList<>();

    //    敌机的集合
    public static List<EnemyObj> enemyObjList = new ArrayList<>();
    //    爆炸类的集合
    public static List<ExplodeObj> explodeObjList = new ArrayList<>();

    //    删除元素集合
    public static List<GameObj> removeList = new ArrayList<>();
    //    绘制字符串
    public  static void printStr(Graphics g,Color color,String str,int size,int x,int y){
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str,x,y);
    }

}

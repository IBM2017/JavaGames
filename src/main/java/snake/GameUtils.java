package snake;

import java.awt.*;

/**
 * @Description: 工具类
 * @Title: GameUtils
 * @Package snake
 * @Author: Mr Liu
 * @Copyright 版权归**企业（或个人）所有
 * @CreateTime: 2024/1/11 21:02
 */
public class GameUtils {
//    蛇头（四张图片）
    public static Image upImg=Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheSnake/up.png");
    public static Image leftImg=Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheSnake/left.png");
    public static Image downImg=Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheSnake/down.png");
    public static Image rightImg=Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheSnake/right.png");
//    蛇身
    public static Image bodyImg=Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheSnake/body.png");
//    食物
    public static Image foodImg=Toolkit.getDefaultToolkit().getImage("src/main/resources/imgs/TheSnake/food.png");
//    绘制文字
    public static void drawWord(Graphics g,String str,Color color,int size,int x,int y){
        g.setColor(color);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str,x,y);
    }
}

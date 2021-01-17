package xyz.threeaaa.model;

import xyz.threeaaa.info.Size;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏时背景
 * @author threeAAA
 * @date 2021/1/15
 */
public class GameBackground implements Component {
    /**背景图 */
    Image bgimage = new ImageIcon("resources/gbg.jpg").getImage();
    /**图容器长宽 */
    int width = Size.WIDTH.getSize(), height = Size.HEIGHT.getSize();
    /**背景图x坐标位置 */
    int index = 0;
    /**移动速度*/
    final static int SPEED = 10;

    /**
     * 绘制背景
     * @param g 系统画笔
     */
    public void printMap(Graphics g){
        //两同样背景图拼接
        g.drawImage(bgimage,width+index,0,width,height,null);
        g.drawImage(bgimage,index,0,width,height,null);

    }

    @Override
    public void printComponent(Graphics g) {
        printMap(g);
    }

    /**
     * 背景滑动效果
     */
    @Override
    public void step(){
        index-= SPEED;
        if (index <= -width){
            index = 0;
        }
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }


}

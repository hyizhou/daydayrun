package xyz.threeaaa.model;

import xyz.threeaaa.info.Score;

import javax.swing.*;
import java.awt.*;

/**
 * @author threeAAA
 * @date 2021/1/16
 * 分数
 */
public class Fraction implements Component{
    int x=10,y=10;
    /** 奔跑距离 */
    int grads = 0;
    /**记录分数的对象*/
    Score score;

    @Override
    public void printComponent(Graphics g) {
        Image image = new ImageIcon("resources/a12.png").getImage();
        g.drawImage(image,x,y,120,30,null);
        //添加分数显示
        String grads = "分数为"+score.getScore();
        Font f2 = new Font("宋体",Font.BOLD,18);
        g.setFont(f2);
        g.setColor(Color.white);
        g.drawString(grads,x+10,y+20);
    }

    @Override
    public void step() {
        grads++;
        score.setDistance(grads);
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
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void addScore(Score score){
        this.score = score;
    }
}

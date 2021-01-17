package xyz.threeaaa.model;

import xyz.threeaaa.info.Score;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author threeAAA
 * @date 2021/1/15
 */
public class Gold implements Collision{
    List<Image> images = new ArrayList<>();
    final int SPEED = GameBackground.SPEED;
    /*生成0-5随机数，用以取金币图像*/
    int randomImage = (int) (Math.random() * 6);
    int y,x;
    int width=50,height=50;
    private Score score;

    /**
     * 代表一个金币图案
     * 构造方法渲染出初始位置，后续帧的位置改变交给GoldList
     * @param x x轴位置
     * @param y y轴位置
     */
    public Gold(int x,int y){
        this.x = x;
        this.y = y;
        for (int i = 1; i < 7; i++) {
            images.add(new ImageIcon("resources/2"+i+".png").getImage());
        }

    }
    public void printGold(Graphics g){
        g.drawImage( images.get(randomImage),x, y,width,height,null);
    }

    @Override
    public Boolean isCollision(Person person){
        if (person.getX()+person.getWidth() > this.x &&
                person.getX()<this.x+this.width &&
                person.getY()+person.getHeight()>this.y&&
                person.getY()<this.y+this.height
        ){
            score.setCoin(score.getCoin() + 1);
            return true;
        }
        return false;
    }


    public void setX(int x){
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addScore(Score score){
        this.score = score;
    }
}

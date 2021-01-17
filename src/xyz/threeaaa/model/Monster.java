package xyz.threeaaa.model;

import xyz.threeaaa.info.Size;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author threeAAA
 * @date 2021/1/15
 */
public class Monster implements Collision,Component{
    Image image;
    List<Image> images = new ArrayList<>();
    int imageIndex=0, x = Size.WIDTH.getSize()+100,y=280;
    final int width =80, height =80;
    final int SPEED = GameBackground.SPEED;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public Monster(){
        images.add(new ImageIcon("resources/a2.png").getImage());
        images.add(new ImageIcon("resources/a4.png").getImage());

    }
    public void printMonster(Graphics g){
        g.drawImage(image, x,y, width, height,null);
    }


    @Override
    public void printComponent(Graphics g) {
        printMonster(g);
    }

    @Override
    public void step(){
        image =  images.get(imageIndex++/15%2);
        //防止超过int最大值
        if (imageIndex>Integer.MAX_VALUE-100) {
            imageIndex=0;
        }
        x -= SPEED;
        resetPosition();
    }

    /**
     * 怪物到窗口外后生成到新位置
     */
    private void resetPosition(){
        if (x <-180){
            int temp = Size.WIDTH.getSize();
            //新产生位置在显示屏幕外，窗口宽<位置<窗口宽x2
            x = (int) (Math.random() * temp + temp);
        }
    }

    @Override
    public Boolean isCollision(Person person) {
        return person.getY() + person.getHeight() > this.getY() + 40 &&
                person.getY() < this.getY() + this.getHeight() &&
                person.getX() + person.getWidth() > this.getX() + 30 &&
                person.getX() < this.getX() + this.getWidth();
    }
}

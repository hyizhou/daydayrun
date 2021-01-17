package xyz.threeaaa.model;

import xyz.threeaaa.info.Size;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author threeAAA
 * @date 2021/1/14
 */
public class Person implements Component{
    Image personImage;
    /**九张图 */
    List<Image> images;
    int index = 0;
    int x=50,y=230;
    int width =120, height =120;
    /** 跳起标志，若是-1则没有起跳，其他数在跳*/
    int jumping = -1;
    /** 分数或者叫过去的帧数*/
    int temp;

    public Person(){
        images = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            images.add(new ImageIcon("resources/"+i+".png").getImage());
        }
        personImage =  images.get(0);

    }

    @Override
    public void printComponent(Graphics g) {
        printPerson(g);
    }

    /**
     * 进入下一帧图
     */
    @Override
    public void step(){
        //刷新动作图，速度降低3倍
        personImage =  images.get(index);
        nextImage();
        //跳起状态
        if (jumping>=0){
            jump();
        }
    }

    /**
     * 调用本方法使index+1，但是不超过images大小
     */
    private void nextImage(){
        if (temp > Integer.MAX_VALUE-100){
            temp = 0;
        }else {
            temp++;
        }
        index = temp/3%images.size();
    }

    /**
     * 使小人跑动起来，每调用依次换一张小人图
     * @param g 系统图形类
     */
    public void printPerson(Graphics g){
        g.drawImage(personImage,x,y, width, height,null);
    }

    private void jump(){
        int[] yPath = {240,205,175,150,130,112,95,81,69,59,51,45,51,51,52,56,59,69,81,95,112,130,150,175,205,240};
        if (jumping>=0 && jumping<yPath.length){
            this.y = yPath[jumping];
            jumping++;
        }else {
            jumping = -1;
        }

    }
    public void setJumping(int j){
        if (jumping == -1){
            jumping=j;
        }

    }

    //前进
    public void goAhead(){
        //不能超出屏幕
        if (x > Size.WIDTH.getSize()-this.width){
            return;
        }
        x += 20;
    }
    //后退
    public void goBackward(){
        if (x < 0){
            return;
        }
        x -= 20;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}

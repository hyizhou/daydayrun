package xyz.threeaaa.model;

import java.awt.*;

/**
 * 供游玩界面上的组件继承，包含打印组件方法和步进方法
 * @author threeAAA
 * @date 2021/1/16
 */
public interface Component {
    /**
     * 打印组件使组件能显示在界面上
     * @param g 系统提供的画笔
     */
    void printComponent(Graphics g);

    /**
     * 相当于进入下一帧画面
     */
    void step();

    int getWidth();

    int getHeight();

    int getX();

    int getY();
}

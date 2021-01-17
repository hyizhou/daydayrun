package xyz.threeaaa.model;

import xyz.threeaaa.info.Score;

import java.awt.*;

/**
 * @author threeAAA
 * @date 2021/1/16
 */
public class GoldList implements Component {
    /**
     * 金币数
     */
    int goldNumber = 5;
    /**
     * 金币间间隔
     */
    int interval = 150;
    /**
     * 金币数组
     */
    Gold[] golds = new Gold[goldNumber];
    /**
     * x轴坐标表
     */
    int[] xs = new int[goldNumber];
    /**
     * y轴坐标表
     */
    int[] ys = new int[goldNumber];
    /**
     * 新生成x轴位置
     */
    int newX = 800;
    /**
     * 最后一个金币数组中坐标
     */
    int endIndex = goldNumber - 1;
    /**
     * 金币生成时x和y坐标范围
     */
    int maxY = 300, minY = 50;

    public GoldList() {
        int temp = newX;
        for (int i = 0; i < goldNumber; i++) {
            xs[i] = temp;
            temp += interval;
            ys[i] = randomY();
        }
        for (int i = 0; i < goldNumber; i++) {
            golds[i] = new Gold(xs[i], ys[i]);
        }
    }

    public void printGoldList(Graphics g) {
        printComponent(g);
    }

    @Override
    public void printComponent(Graphics g) {
        for (int i = 0; i < goldNumber; i++) {
            golds[i].printGold(g);
        }
    }

    /**
     * 下一帧
     * 图像移动到下一个位置，检查是否出界，出界图像重新生成位置
     */
    @Override
    public void step() {
        for (int i = 0; i < goldNumber; i++) {
            //和背景一起移动，速度一致
            xs[i] -= GameBackground.SPEED;
            golds[i].setX(xs[i]);
            //已出界，重置x和y位置
            if (xs[i] < -50) {
                rest(i);
            }
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

    private void rest(int i) {
        xs[i] = xs[endIndex] + interval;
        endIndex = i;
        golds[i].setX(xs[i]);
        ys[i] = randomY();
        golds[i].setY(ys[i]);
    }

    /**
     * 随机y坐标，范围由maxy和minY控制
     *
     * @return 随机y坐标
     */
    private int randomY() {
        return (int) (Math.random() * (maxY - minY) + minY);
    }

    /**
     * 碰撞检测
     *
     * @param person 人物
     */
    public void aaa(Person person) {
        for (int i = 0; i < goldNumber; i++) {
            if (golds[i].isCollision(person)) {
                rest(i);
            }
        }
    }

    /**
     * 存储分数
     * @param score 分数存储对象
     */
    public void addScore(Score score) {
        for (int i = 0; i < goldNumber; i++) {
            golds[i].addScore(score);
        }
    }
}

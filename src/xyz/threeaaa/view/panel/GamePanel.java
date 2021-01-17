package xyz.threeaaa.view.panel;

import xyz.threeaaa.info.Score;
import xyz.threeaaa.model.*;
import xyz.threeaaa.model.Component;
import xyz.threeaaa.view.GameFrame;
import xyz.threeaaa.view.GameOverFrame;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * 游戏界面，组合小人，背景，金币等多个组件
 * @author threeAAA
 * @date 2021/1/14
 */
public class GamePanel extends JPanel {
    List<Component> components = new LinkedList<>();
    /**人物类 */
    Person person;
    /**背景*/
    GameBackground map;
    /**怪物*/
    Monster monster ;
    /**金币*/
    GoldList gold;
    /**积分板*/
    Fraction fraction;
    /**主窗口Jframe*/
    GameFrame jFrame;
    Score score = new Score();


    public GamePanel(GameFrame jFrame){
        super();
        this.jFrame = jFrame;
        initComponents();
        gold.addScore(score);
        fraction.addScore(score);
    }

    /**
     * 初始化Components
     */
    private void initComponents(){
        this.map = new GameBackground();
        components.add(map);
        this.monster = new Monster();
        components.add(monster);
        this.gold = new GoldList();
        components.add(gold);
        this.fraction = new Fraction();
        components.add(fraction);
        this.person = new Person();
        components.add(person);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Component component : components) {
            component.printComponent(g);
        }
    }

    /**
     * 下一帧
     */
    public void nextFrame(){
        for(Component component: components){
            component.step();
        }
        //碰撞检测
        aaa();
    }

    private void aaa() {
        //检测碰撞怪物
        if (monster.isCollision(person)) {
            //gameover
            jFrame.over = true;
            jFrame.dispose();
            new GameOverFrame(score);
        }
        //检测碰撞金币
        gold.aaa(person);
    }

    /**
     * 人物跳跃
     */
    public void jump(){
        person.setJumping(0);
    }

    public void goAhead(){
        person.goAhead();
    }
    public void goBackward(){
        person.goBackward();
    }
}

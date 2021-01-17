package xyz.threeaaa.view;

import xyz.threeaaa.info.Score;
import xyz.threeaaa.info.Size;
import xyz.threeaaa.view.panel.BackgroudPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * @author threeAAA
 * @date 2021/1/16
 */
public class GameOverFrame extends JFrame{
    BackgroudPanel panel;
    Score score;
    /**全局字体样式*/
    Font font = new Font("微软雅黑",Font.PLAIN, 18);

    public GameOverFrame(Score score){
        this.score = score;

        initScore();
        initButton();
        try {
            panel = new BackgroudPanel("resources/endbg.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

        panel.setBounds(0,0, Size.WIDTH.getSize(),Size.HEIGHT.getSize());
        this.add(panel);


        //设置登录界面的基本属性
        this.setSize(Size.WIDTH.getSize(), Size.HEIGHT.getSize());
        //位置居中
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setUndecorated(false);

        //设置窗体的Logo图标
        this.setIconImage(new ImageIcon("resources/115.png").getImage());
        this.setVisible(true);
    }

    /**
     * 显示分数
     */
    private void initScore(){
        //分数显示3行
        int a = 3;
        int[] x = {650,660,660};
        int[] y = {270,346,395};
        for (int i = 0; i < a; i++) {
            JLabel label = new JLabel(String.valueOf(score.next()));
            label.setFont(font);
            label.setBounds(x[i], y[i], 100, 30);
            this.add(label);
        }

    }

    /**
     * 放置按钮
     */
    private void initButton(){
        JButton again = new JButton(new ImageIcon("resources/hh6.png"));
        again.setBounds(45,350,120,50);
        //设置按钮透明
        again.setContentAreaFilled(false);
        //取消边框
        again.setBorder(null);
        this.add(again);
        again.addActionListener(e->{
            dispose();
            new MainFrame();
        });
    }
}

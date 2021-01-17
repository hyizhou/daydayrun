package xyz.threeaaa.view;

import xyz.threeaaa.info.Size;
import xyz.threeaaa.view.panel.BackgroudPanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

/**
 *
 * 主界面，提供开始游戏帮助等功能
 * @author threeAAA
 * @date 2021/1/13
 */
public class MainFrame extends JFrame implements MouseListener {
    /**主界面背景*/
    JPanel mainPanel;
    /**使用label模拟按钮，分别是开始，帮助，退出按钮 */
    JLabel startButton,helpButton,exitButton;

    /**
     * 登录后跳转到此界面，称此界面为主界面，显示有开始，帮助，退出按钮
     */
    public MainFrame(){
        initStartButton();
        initExitButton();
        initHelpButton();
        if (!initBackgroud()){
            JOptionPane.showMessageDialog(null,"资源错误");
        }
        //设置窗口大小
        this.setSize(Size.WIDTH.getSize(),Size.HEIGHT.getSize());
        //设置图标
        this.setIconImage(new ImageIcon("resources/115.png").getImage());
        //设置默认关闭行为
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //位置居中
        this.setLocationRelativeTo(null);
        //设置可见
        this.setVisible(true);

    }

    /**
     * 初始化开始按钮
     */
    private void initStartButton(){
        startButton = new JLabel(new ImageIcon("resources/hh1.png"));
        startButton.setBounds(350,300,150,40);
        startButton.addMouseListener(this);
        this.add(startButton);
    }

    /**
     * 初始化帮助按钮
     */
    private void initHelpButton(){
        helpButton = new JLabel(new ImageIcon("resources/hh2.png"));
        helpButton.setBounds(350,350,150,40);
        helpButton.addMouseListener(this);
        this.add(helpButton);
    }

    /**
     * 初始化退出按钮
     */
    private void initExitButton(){
        exitButton = new JLabel(new ImageIcon("resources/hh3.png"));
        exitButton.setBounds(350,400,150,40);
        exitButton.addMouseListener(this);
        this.add(exitButton);
    }

    /**
     * 初始化背景
     * @return false背景路径错误
     */
    private Boolean initBackgroud(){
        try {
            this.mainPanel = new BackgroudPanel("resources/main.png");
        } catch (IOException e) {
            return false;
        }
        mainPanel.setBounds(0,0,Size.WIDTH.getSize(),Size.HEIGHT.getSize());
        this.add(mainPanel);
        return true;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(startButton)) {
            // 点击开始
            new LoadFrame();
            this.dispose();
        }else if (e.getSource().equals(helpButton)){
            //点击帮助
            new HelpFrame(this);
        }else if (e.getSource().equals(exitButton)){
            //点击退出
            exitButton.setEnabled(false);
            this.dispose();
        }

    }

    /**
     * 设定三个按钮按下松开时的反馈
     * 传入鼠标事件，用于找到当前互动的按钮，布尔值代表是按钮样式是启用还是按下
     * 本方法由对应的鼠标事件方法调用
     * @param e 鼠标事件
     * @param b true 样式为启用，false相反
     */
    private void setButtonEnabled(MouseEvent e, Boolean b){
        if (e.getSource().equals(startButton)){
            startButton.setEnabled(b);
        }else if (e.getSource().equals(helpButton)){
            helpButton.setEnabled(b);
        }else if (e.getSource().equals(exitButton)){
            exitButton.setEnabled(b);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        setButtonEnabled(e,false);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        setButtonEnabled(e,true);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

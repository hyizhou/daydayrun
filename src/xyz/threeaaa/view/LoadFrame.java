package xyz.threeaaa.view;

import xyz.threeaaa.view.panel.BackgroudPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * @author threeAAA
 * @date 2021/1/14
 */
public class LoadFrame extends JFrame {
    private JProgressBar progressBar;
    private final int width = 568, height=320;
    public LoadFrame(){
        if (!initBg()) {
            JOptionPane.showMessageDialog(null,"资源错误！");
        }
        initProgressBar();
        startProgress();
        this.setSize(width,height);
        //设定无装饰栏
        this.setUndecorated(true);
        //居中显示
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * 初始化背景图
     * @return 返回执行情况
     */
    private Boolean initBg(){
        JPanel bgPanel;
        try {
            bgPanel = new BackgroudPanel("resources/hbg.jpg",width,height);
        } catch (IOException e) {
            System.out.println("资源错误");
            return false;
        }
        bgPanel.setBounds(0,0,width,height);
        this.add(bgPanel);
        return true;
    }

    /**
     * 初始化进度条
     */
    private void initProgressBar(){
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        this.add(BorderLayout.SOUTH,progressBar);
    }

    /**
     * 创建单独线程用于控制进度条进度
     */
    private void startProgress(){
        Thread progress = new Progress(progressBar);
        progress.start();
    }

    /**
     * 用于展示进度条的多线程类
     */
    private class Progress extends Thread{
        private final JProgressBar progressBar;

        /**
         * 进度条多线程进行展示
         * @param progressBar 外部进度条组件
         */
        public Progress(JProgressBar progressBar){
            this.progressBar = progressBar;
        }
        @Override
        public void run() {
            //进度条终点
            int hundred = 100;
            for (int i = 0; i <= hundred; i++) {
                progressBar.setValue(i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            LoadFrame.this.dispose();
            new GameFrame();

        }
    }

}

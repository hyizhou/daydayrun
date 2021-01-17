package xyz.threeaaa.view;

import xyz.threeaaa.info.Size;
import xyz.threeaaa.view.panel.GamePanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author threeAAA
 * @date 2021/1/14
 */
public class GameFrame extends JFrame implements KeyListener {
    /**结束游戏标志*/
    public Boolean over = false;
    /**暂停标志*/
    public Boolean pause = false;
    /**键盘锁定标志*/
    private Boolean keyLock = false;
    private int FPS = 30;

    public GameFrame() {
        //设置界面的基本属性
        this.setSize(Size.WIDTH.getSize(), Size.HEIGHT.getSize());
        //位置居中
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(false);
        // 设置窗体的Logo图标
        this.setIconImage(new ImageIcon("resources/115.png").getImage());
        this.setVisible(true);

        draw();
    }
    GamePanel gamePanel;
    /**
     * 游戏画面绘制
     */
    private void draw(){
        //注册键盘监听
        addKeyListener(this);
        gamePanel = new GamePanel(this);
        gamePanel.setBounds(0,0,Size.WIDTH.getSize(), Size.HEIGHT.getSize());
        this.add(gamePanel);
        while(!over){
            //未暂停
            if (!pause){
                //渲染下一帧画面
                gamePanel.nextFrame();
                //刷新画面
                gamePanel.repaint();
                //键盘操作与帧同步的锁
                if (keyLock){
                    keyLock = false;
                }
            }

            try {
                Thread.sleep(1000/FPS);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * 监听键盘
     */
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        //空格和上
        if (e.getKeyCode() == 32 || e.getKeyCode()==38){
            gamePanel.jump();
        }
        //ESC
        if (e.getKeyCode() == 27){
            this.pause = !this.pause;
        }
        //后键
        if (e.getKeyCode()==37){
            if (!keyLock){
                gamePanel.goBackward();
                keyLock = !keyLock;
            }
        }
        //前
        if (e.getKeyCode()==39){
            //未锁定
            if (!keyLock){
                gamePanel.goAhead();
                keyLock = !keyLock;
            }

        }
        //下
        if (e.getKeyCode()==40){
            //空学来疯
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

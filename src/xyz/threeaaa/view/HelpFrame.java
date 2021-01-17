package xyz.threeaaa.view;

import xyz.threeaaa.info.Size;
import xyz.threeaaa.view.panel.BackgroudPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

/**
 * @author threeAAA
 * @date 2021/1/13
 */
public class HelpFrame extends JFrame{
    JFrame frame;

    /**
     * 弹出帮助窗口，传入父窗口，将使父窗口冻结
     * @param frame 父窗口
     */
    public HelpFrame(JFrame frame){
        this.frame = frame;
        frame.setEnabled(false);
        this.setSize(Size.WIDTH.getSize(), Size.HEIGHT.getSize());
        //作为顶层窗口
        this.setAlwaysOnTop(true);
        //设定右上角关闭什么也不做，以便后面修改其功能
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setIconImage(new ImageIcon("resources/115.png").getImage());
        //自定关闭按钮功能，使上层窗口重新可用，并关闭本窗口
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setEnabled(true);
                HelpFrame.this.dispose();
            }
        });
        //设置作为背景的帮助信息图
        try {
            JPanel helpImagePanel = new BackgroudPanel("resources/bzbg.png");
            helpImagePanel.setBounds(0,0,Size.WIDTH.getSize(), Size.HEIGHT.getSize());
            this.add(helpImagePanel);
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(null,"帮助缺失中");
        }
        this.setVisible(true);
    }
}

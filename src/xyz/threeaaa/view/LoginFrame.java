package xyz.threeaaa.view;

import xyz.threeaaa.info.Size;
import xyz.threeaaa.view.panel.BackgroudPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * @author threeAAA
 * @date 2021/1/12
 */
public class LoginFrame extends JFrame {
    /**以下分别是：账号和密码提示，输入框，登录与退出按钮*/
    JLabel userLabel, pswdLabel;
    JTextField userText, pswdText;
    JButton loginButton, cancelButton;
    /**全局字体样式*/
    Font font = new Font("微软雅黑",Font.PLAIN, 18);

    /**
     * 登录界面绘制
     */
    public LoginFrame(){
        //输入框
        userLabel = new JLabel("用户名");
        pswdLabel = new JLabel("密码");
        userLabel.setFont(font);
        pswdLabel.setFont(font);
        userLabel.setBounds(20, 220, 100, 30);
        pswdLabel.setBounds(20, 280, 100, 30);
        this.add(userLabel);
        this.add(pswdLabel);

        userText = new JTextField();
        pswdText = new JPasswordField();
        userText.setBounds(80, 220, 100, 30);
        pswdText.setBounds(80,280,100,30);
        this.add(userText);
        this.add(pswdText);

        // 登录与退出按钮
        loginButton = new JButton("登录");
        cancelButton = new JButton("返回");
        loginButton.addActionListener(e -> {
            String user = userText.getText();
            String password = pswdText.getText();
            if ("".equals(user)){
                JOptionPane.showMessageDialog(null, "用户名不能为空，请重新输入！");
            }else if ("".equals(password)){
                JOptionPane.showMessageDialog(null, "密码不能为空，请重新输入！");
            }else if (!login(user,password)){
                JOptionPane.showMessageDialog(null, "密码错误，请重新输入！");
            }else {
                //跳转到新页面
                new MainFrame();
                dispose();
            }
        });
        loginButton.setBounds(45,350,60,36);

        cancelButton.addActionListener(e-> dispose());
        cancelButton.setBounds(135,350,60,36);
        this.add(loginButton);
        this.add(cancelButton);
        //加载背景图
        if (!initBackground()){
            JOptionPane.showMessageDialog(null, "程序资源缺失！");
            dispose();
        }


        //设置登录界面的基本属性
        this.setSize(Size.WIDTH.getSize(), Size.HEIGHT.getSize());
        //位置居中
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(false);

        //设置窗体的Logo图标
        this.setIconImage(new ImageIcon("resources/115.png").getImage());
        this.setVisible(true);

    }

    /**
     * 验证登录密码
     * @param user 用户名
     * @param password 用户密码
     * @return 验证结果
     */
    public Boolean login(String user, String password){
        //TODO 这里还要添加验证用户与密码的代码
        return true;
    }

    /**
     * 初始化背景
     * @return 若false，则未获取到背景图片导致失败
     */
    private Boolean initBackground(){

        JPanel backPanel;
        try {
            backPanel = new BackgroudPanel("resources/login.jpg");
        } catch (IOException e) {
            return false;
        }


        backPanel.setBounds(0,0,Size.WIDTH.getSize(), Size.HEIGHT.getSize());
        this.add(backPanel);
        return true;
    }
}

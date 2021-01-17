package xyz.threeaaa.view.panel;

import xyz.threeaaa.info.Size;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author threeAAA
 * @date 2021/1/13
 * 提供给其他页面，设置背景
 */
public class BackgroudPanel extends JPanel {
    private Image imageFile;
    private int height,width;
    private int x=0,y=0;
    private BackgroudPanel(){
        super();
    }
    /**
     * 构造方法中添加了获取图片的代码，需要传入作为背景图的路径
     * @param path 背景图路径
     * @throws IOException 路径错误
     */
    public BackgroudPanel(String path) throws IOException {
        this();
        height = Size.HEIGHT.getSize();
        width = Size.WIDTH.getSize();
        this.imageFile = ImageIO.read(new File(path));
    }

    public BackgroudPanel(int x, int y, int width, int height, String path) throws IOException {
        this(path);
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;

    }

    public BackgroudPanel(String path, int width, int height) throws IOException {
        this.height = height;
        this.width = width;
        this.imageFile = ImageIO.read(new File(path));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.imageFile, x,y, width,height,null);
    }
}

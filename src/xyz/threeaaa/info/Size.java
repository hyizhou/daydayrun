package xyz.threeaaa.info;

/**
 * @author yizhou
 */

public enum Size{
    /**
     * 高和宽
     */
    HEIGHT(530),WIDTH(900);
    /**定义的长度*/
    private final int length;
    Size(int length) {
        this.length = length;
    }

    public int getSize(){
        return this.length;
    }
}

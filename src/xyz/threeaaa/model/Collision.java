package xyz.threeaaa.model;

/**
 * 是否与人物模型碰撞
 * @author ThreeAAA
 * @date 2021/1/16
 */
public interface Collision {
    /**
     * @param person 人物模型
     * @return 碰撞则返回true
     */
    Boolean isCollision(Person person);
}

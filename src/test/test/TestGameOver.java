package test.test;

import xyz.threeaaa.info.Score;
import xyz.threeaaa.view.GameOverFrame;

/**
 * @author threeAAA
 * @date 2021/1/16
 */
public class TestGameOver {
    public static void main(String[] args) {
        Score score = new Score();
        score.setScore(1000);
        score.setCoin(100);
        score.setDistance(1000);
        new GameOverFrame(score);
    }
}

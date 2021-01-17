package xyz.threeaaa.info;

/**
 * 存储游戏成绩
 * @author threeAAA
 * @date 2021/1/16
 */
public class Score {
    /**总分*/
    private int score;
    /*金币数*/
    private int coin;
    /*距离*/
    private int distance;

    private int mark = 0;

    public int getScore() {
        score = distance+coin*100;
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int next(){
        if (mark == 0){
            mark++;
            return getScore();
        }
        if (mark == 1){
            mark++;
            return getDistance();
        }
        if (mark == 2){
            mark = 0;
            return getCoin();
        }
        return 0;
    }
}

/*
 * @Author: Weidows
 * @Date: 2020-07-06 22:01:18
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-18 15:18:24
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\typesystem\dome\VideoGame.java
 */ 
package twenty.july.typesystem.dome;
public class VideoGame extends Item {
    private int numOfPlayers;

    public VideoGame(String title, int playingTime, boolean gotIt, String comment, int number) {
        super(title, playingTime, gotIt, comment);
        this.numOfPlayers = number;
    }

    @Override
    public void print() {
        super.print();
        System.out.println(
            "numOfPlayers" + numOfPlayers + "\t");
    }
    public static void main(String[] args) {
        
    }
}
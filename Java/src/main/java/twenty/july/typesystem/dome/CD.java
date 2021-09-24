package twenty.july.typesystem.dome;
/*
 * @Author: Weidows
 * @Date: 2020-07-05 22:16:23
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-18 15:17:58
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\typesystem\dome\CD.java
 */ 
public class CD extends Item {
    private String artist;
    private int numOfTracks;

    public CD(String title, String artist, int numOfTracks, int playingTime,Boolean gotIt, String comment) {
        super(title,playingTime,gotIt,comment);   //调用父类的构造函数(传参)
        this.artist = artist;
        this.numOfTracks = numOfTracks;
    }

    public void print() {
        super.print();
        System.out.println(
            "artist:"+artist+"\t"+
            "numOfTracks:"+numOfTracks+"\t");
    }
    public static void main(String[] args) {
        
    }
}
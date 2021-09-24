package twenty.july.typesystem.dome;
/*
 * @Author: Weidows
 * @Date: 2020-07-05 22:47:52
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-18 15:18:11
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\typesystem\dome\DVD.java
 */ 
public class DVD extends Item {
    private String director;

    public DVD(String title, String director, int playingTime, Boolean gotIt, String comment) {
        super(title, playingTime, gotIt, comment);
        this.director = director;
    }
    public void print() {
        super.print();
        System.out.println(
            "director:" + director + "\t");
    }

    public static void main(String[] args) {
        
    }
}
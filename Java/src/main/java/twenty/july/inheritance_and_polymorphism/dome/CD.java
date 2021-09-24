/*
* @Author: Weidows
* @Date: 2020-07-05 22:16:23
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-18 16:03:44
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\inheritance_and_polymorphism\dome\CD.java
*/ 
package twenty.july.inheritance_and_polymorphism.dome;
/**好像包名不能毫无意义的太长,比如这里不加下划线的话会出错 */
public class CD extends Item {
    // private String title;
    private String artist;
    private int numOfTracks;
    // private int playingTime;
    // private boolean gotIt;
    // private String comment;

    public CD(String title, String artist, int numOfTracks, int playingTime,Boolean gotIt, String comment) {
        /**
         * 自定义一个构造器,在new对象时可以输入对应参数直接初始化
         * 在子类的构造函数第一行可以用super()调用父类的构造函数,只能调用一次且只能在第一行
         */
        super(title,playingTime,gotIt,comment);   //调用父类的构造函数(传参)
        // this.title = title;
        this.artist = artist;
        this.numOfTracks = numOfTracks;
        // this.playingTime = playingTime;
        // this.comment = comment;
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
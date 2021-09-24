/*
 * @Author: Weidows
 * @Date: 2020-07-05 22:47:52
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-18 16:02:39
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\inheritance_and_polymorphism\dome\DVD.java
 */ 
package twenty.july.inheritance_and_polymorphism.dome;
public class DVD extends Item {
    /**
     * 继承:DVD扩展item,也就是DVD变成item一个子类(CD也是)
     * DVD继承Item类,Item中的成员会被继承到子类中
     * 如果子类中定义了与父类中相同名字的成员变量,则在这个子类中父类的成员变量被遮盖
     * 调用父类的成员变量需要用super.  (前提是父类开放权限)
     */
    // private String title;
    private String director;
    // private int playingTime;
    // private boolean gotIt;
    // private String comment;

    public DVD(String title, String director, int playingTime, Boolean gotIt, String comment) {
        super(title, playingTime, gotIt, comment);
        // this.title = title;
        this.director = director;
        // this.playingTime = playingTime;
        // this.comment = comment;
    }
    public void print() {
        super.print();
        System.out.println(
            "director:" + director + "\t");
    }

    public static void main(String[] args) {
        
    }
}
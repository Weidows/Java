/*
 * @Author: Weidows
 * @Date: 2020-07-06 09:42:15
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-18 15:25:03
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\Inheritanceandpolymorphism\dome\Item.java
 */
package twenty.july.inheritance_and_polymorphism.dome;
public class Item {
    /**
     * 因为DataBase中list()中有个item.print(),他是找的Item类中的成员函数
     * 即使这个函数是在子类中实现的,也需要在父类中进行"声明"
     * 父类中的所有非private子类都可以得到继承,也可以自定义修改继承的东西(比如print函数)
     * 继承过后子类的成员变量的访问权限也得到继承
     * 
     * #权限问题 public 对所有开放 protected
     * 只对包内其他类,本身和子类开放(由于多数情况下父类和子类不是在同一个包下,
     * 所以protected不常用,除非确定父类和子类一定在一个包下) 缺省
     * 只有包内其他类可以访问(即使是子类在包外也不能访问) private 只有自己可以访问
     * 
     * #初始化(先后顺序) 1.定义初始化 2.构造器初始化 3.先做父类的后子类
     * 4.子类根据super(传参)去父类找相应的构造函数,super()只能调用一次,且只能在第一行
     * 
     * 这里四个DVD和CD共性成员变量,需要在子类的构造函数中调用父类的构造函数来初始化这四个父类中的成员函数
     */

    private String title;
    private int playingTime;
    private boolean gotIt;
    private String comment;
    
    public Item(String title,int playingTime,boolean gotIt,String comment) {
        /**
         * 定义一个构造器(多个叫重构) 初始化父类中的成员变量
         * 因为这个父类的成员变量子类无权访问,只能通过super传参间接调用
         * 因为在new对象时用的是子类DVD,CD而不是父类Item,
         * 所以这个父类的构造函数需要在子类中实现
         */
        // super(); //本身就是父类用不到调用上级的构造函数
        this.title = title;
        this.playingTime = playingTime;
        this.gotIt=gotIt;
        this.comment=comment;
        
    }
    public void print() {
        System.out.print(
            "title:"+title+"\t"+
            "playingTime:"+playingTime+"\t"+
            "gotIt:"+gotIt+"\t"+
            "comment:"+comment+"\t");
    }
    public static void main(String[] args) {
        
    }
}
package twenty.july.typesystem.dome;
/*
 * @Author: Weidows
 * @Date: 2020-07-06 09:42:15
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-18 15:17:19
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\typesystem\dome\Item.java
 */ 
public class Item {
    private String title;
    private int playingTime;
    private boolean gotIt;
    private String comment;
    
    public Item(String title,int playingTime,boolean gotIt,String comment) {
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
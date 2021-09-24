package twenty.july.typesystem.dome;
import java.util.ArrayList;

/*
 * @Author: Weidows
 * @Date: 2020-07-05 22:14:19
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-08 10:56:22
 * @FilePath: \Weidows\src\twenty\july\e类型系统\dome\DataBase.java
 */ 
public class DataBase {
    private ArrayList<Item> listItem = new ArrayList<Item>();

    public void add(Item item) {
        listItem.add(item);
    }

    public void list() {
        for (Item item : listItem) {
            item.print();
        }
    }

    public static void main(String[] args) {
        // new DataBase对象
        DataBase db = new DataBase();
        //第一种add方法
            db.add(new CD("abc", "abc", 4, 60, true, "..."));
        // db.add(new CD("def", "def", 4, 60, true, "..."));
            Item cd_2 = new CD("def", "def", 4, 60, true, "...");
            db.add(cd_2);
            /**
             * 第二种方法,作用相同
             * .add()接收的是Item类的参数,传入的是子类CD类的,没问题
             */
        //多态与造型
            // db.add(new DVD("xxx", "aaa", 60, true, "..."));
            Item item = new DVD("xxx", "aaa", 60, true, "...");
            item = (Item) item; //子类造型成父类,向上造型
            db.add(item);
        //VideoGame
            db.add(new VideoGame("ddd", 10, true, "...", 4));
        db.list();  //输出所有
    }
}
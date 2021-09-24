package twenty.july.inheritance_and_polymorphism.dome;
import java.util.ArrayList;

/*
 * @Author: Weidows
 * @Date: 2020-07-05 22:14:19
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-18 16:02:30
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\inheritance_and_polymorphism\dome\DataBase.java
 */ 
public class DataBase {
    // private ArrayList<CD> listCD = new ArrayList<CD>();
    // private ArrayList<DVD> listDVD = new ArrayList<DVD>();
    private ArrayList<Item> listItem = new ArrayList<Item>();

    // public void add(CD cd) {
    //     listCD.add(cd);
    // }

    // public void add(DVD dvd) {
    //     listDVD.add(dvd);
    // }
    public void add(Item item) {
        listItem.add(item);
        /**
         * 相同名称的成员函数可以有多个,但其中参数不能相同(函数重构)
         */
    }

    public void list() {
        // for (CD cd : listCD) {
        //     cd.print();
        // }
        // for (DVD dvd : listDVD) {
        //     dvd.print();
        // }
        for (Item item : listItem) {
            item.print();
            /**
             * 因为main里面new对象是用子类new的,所以调用print首先去子类中找,
             * 找不到才会用子类继承父类的print(子类覆盖父类中的成员函数)
             * 涉及到函数调用的绑定:静态绑定 && 动态绑定(默认)
             */
        }
    }

    public static void main(String[] args) {
        // new DataBase对象
        DataBase db = new DataBase();
        /**
         * new无名的Item子类CD和DVD的对象传给DataBase的add()函数
         * 子类的对象可以当做父类的对象使用,如:
         *      1. Item item = new Item();
         *      2. Item cd   = new CD();
         *      3. Item dvd  = new DVD();
         *      父类的容器可以放子类的对象,比如这个Item类的ArrayList容器可以
         *      存放DVD和CD类的,但反过来不行
         * 
         * 多态:java的对象变量可以保存多种类型的的对象(本身类和子类)
         *      (比如Item类可以保存Item,DVD,CD三种类型的对象)
         *      声明类型(静态类型):其字面上的类型
         *      动态类型:运行时根据对象性质变化的对象变量
         * 
         * 两种造型:(当做另外一种类型看待,而不是真正改变了类型)
         *      向上造型:子类的对象赋给父类的变量(上面的2,3,这种造型不需要运算符,是安全的)
         *      造型:(非强转类型,数据不变的情况下改变类型).
         *          Vehicle v;
         *          Car c = new Car();
         *          v = c; 子类对象赋值给父类对象变量,可以
         *          c = v; 父类对象赋值给子类对象变量,编译错误
         *          c = (Car) v; 运用造型转换类型,编译通过
         *          但是造型不一定是安全的,取决于被造型对象当时的类型是否能变成目标类型
         *      注意点:
         *          这里"赋值"是指共享管理对象的权限,而不是字面意义的赋值,比如:
         *          String s = "HelloWorld";
         *          s = "bye";
         *          String s_1 = s;
         *          这里不是s管理的对象"HelloWorld"变化了,而是管理的目标对象变成了"bye"
         *          s_1也不是s赋值过来的,而是和s共同管理"bye"这个对象
         */ 
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
        db.list();  //输出所有
    }
}
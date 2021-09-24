/*
 * @Author: Weidows
 * @Date: 2020-07-04 18:51:22
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-18 16:43:21
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\hashmap\Coin.java
 */ 
package twenty.july.hashmap;
import java.util.HashMap;
import java.util.Scanner;

public class Coin {
    private HashMap<Integer, String> coinName = new HashMap<Integer, String>();
    /**
     * Integer是int的包裹类型,由首字母大写可以看出其比int高级,不能用int代替
     */
    public Coin() {
        /**
         * 与其他容器不同,HashMap添加元素调用的函数原型是put(key,string)
         */
        coinName.put(1, "penny");
        coinName.put(10, "dime");
        coinName.put(25, "quarter");
        coinName.put(50, "半美元");
        coinName.put(50, "half-dollar");//
    }

    public String getName(int amount) {
        /**
         * HashMap查找元素也是get(key),
         * 没找到的情况下返回值是NULL(每个Hash元素是一个对象,没有那个对象就是NULL)
         */
        if (coinName.containsKey(amount))
            return coinName.get(amount);
        else
            return "Not Found!";
    }

    public void printHashMap() {
        /**
         * HashMap有个成员函数keySet(),作用是把key组合成一个HashSet并返回
         * 于是这里就是:HashMap容器coinName调用keySet()返回一个HashSet,
         * 这个HashSet再调用size()返回大小(也等同于HashMap元素数量)
         * 
         * HashMap也可以直接print,与ArrayList和HashSet区别是HashMap是{}
         */
        System.out.println(coinName.keySet().size() + "\t" + coinName);
    }

    public void printHashMap_1() {/* 遍历HashMap方法 */
        for (Integer i : coinName.keySet()) {
            System.out.println(i + "\t" + coinName.get(i));
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Coin coin = new Coin();
        coin.printHashMap();
        in.close();
        // coin.printHashMap_1();
        
        // int amount = in.nextInt();
        // System.out.println(coin.getName(amount));
        
    }
}
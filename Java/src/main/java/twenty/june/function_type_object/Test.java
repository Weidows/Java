package twenty.june.function_type_object;

/*
 * @Author: Weidows
 * @Date: 2020-06-02 01:03:55
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-20 18:18:41
 * @FilePath: \Weidows\Java\src\main\java\twenty\june\function_type_object\Test.java
 * 
 * 
 * 函数&&类&&对象
 */
public class Test {
  public static boolean ifPrime(int i) { //举例的函数
    boolean isPrime = true;
    for (int j = 2; j < i; j++) {
      if (j % j == 0) {
        isPrime = false;
        break;
      }
    }
    return isPrime;
  }

  public static void main(String[] args) {
    VendingMachine vm = new VendingMachine();
    /**
     * 新建vm这个对象(管理者)比如VendingMachine vm1=vm;
     * 这样vm与vm1共同管理数据了,用同一个类new多个对象各自管理不同数据
     */
    vm.showPrompt();
    vm.showBalance();
    vm.insertMoney(100);
    vm.getFood();
    vm.showBalance();
  }
}

//外部类:定义了售货机这个类,可以写进test内部,功能相同
class VendingMachine {
  int price = 80, balance, total;

  /**
   * 定义在函数外的叫成员变量,内部的叫本地变量
   * 成员变量生存期是对象的生存期,作用域是类内部的成员函数
   * 另外一定要注意Java中本地变量如果没有初始化赋值那个变量是不能使用的(出错)
   * 但是类里面的成员变量默认初始值是0
   */

  void showPrompt() {
    System.out.println("Welcome");
  }

  void insertMoney(int amount) {
    balance += amount;
  }

  void showBalance() {
    System.out.println(balance);
  }

  void test(int price) { //测试函数
    this.price = price; //这里的this就是访问类内部(函数外部)的变量
  }

  //构造函数,不能带返回值,名字和类的名字一样在new对象时自动执行此函数
  VendingMachine() {
    total = 0;
  }

  VendingMachine(int price) {
    /**
     * 函数重载,构造函数可以有多个,但参数不能相同,new对象时程序根据传参判断调用哪个构造函数(需要注意如果参数类型不匹配int可以自动转换成double,但是double不能转换成int)
     */
    //调用哪个没参数的构造函数,且只能在构造函数第一行写,且只能用一次
    this();
    this.price = price;
  }

  void getFood() {
    if (balance >= price) {
      System.out.println("Here you are.");
      balance -= price;
      total += price;
    }
  }
}

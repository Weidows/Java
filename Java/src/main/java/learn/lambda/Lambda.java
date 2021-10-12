/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-18 18:14:54
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-19 01:02:31
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\lambda\Lambda.java
 * @Description:
 * @!: *********************************************************************
 */

package learn.lambda;

public class Lambda {
  public static void main(String[] args) {
    Lambda tester = new Lambda();

    // 类型声明
    MathOperation addition = (int a, int b) -> a + b;

    // 不用类型声明
    MathOperation subtraction = (a, b) -> a - b;

    // 大括号中的返回语句
    MathOperation multiplication = (int a, int b) -> {
      return a * b;
    };

    // 没有大括号及返回语句
    MathOperation division = (int a, int b) -> a / b;

    System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
    System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
    System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
    System.out.println("10 / 5 = " + tester.operate(10, 5, division));

    // 不用括号
    GreetingService greetService1 = message -> System.out.println("Hello " + message);

    // 用括号
    GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

    greetService1.sayMessage("Runoob");
    greetService2.sayMessage("Google");

  }

  private int operate(int a, int b, MathOperation mathOperation) {
    return mathOperation.operation(a, b);
  }

  /**
    10 + 5 = 15
    10 - 5 = 5
    10 x 5 = 50
    10 / 5 = 2
    Hello Runoob
    Hello Google
   */
}

interface MathOperation {
  int operation(int a, int b);
}

interface GreetingService {
  void sayMessage(String message);

  // void sayMessage1(String message, String message1); // 比如这里出现第二个抽象方法,这个接口就不是函数化接口了.无法使用lambda表达式
}

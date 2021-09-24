/*
 * @Author: Weidows
 * @Date: 2020-06-20 18:18:06
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-20 20:44:31
 * @FilePath: \Weidows\Java\src\main\java\twenty\june\object_interaction\display\Display.java
 * 
 * 
 * 对象交互&&访问属性&&包
 */
package twenty.june.object_interaction.display;

/**包名,包内的.java文件名可以首字母大写,名字随意 */
import twenty.june.object_interaction.clock.Clock;

/** 导入格式:包名+文件名(类名) */

public class Display {
  private int value = 0;
  private int limit = 0;

  public Display(int limit) { //构造函数,不能带返回值,可以写public或private
    this.limit = limit;
  }

  public void increase() {
    value++;
    if (value == limit) {
      value = 0;
    }
  }

  public int getvalue() {
    return value;
  }

  public static void main(String[] args) {/**不能用code runner跑,出错 */
    Clock clock = new Clock(); /**Clock()是Clock类中默认带有的构造函数 */
    clock.start();
  }
}

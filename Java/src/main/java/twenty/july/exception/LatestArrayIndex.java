/*
 * @Author: Weidows
 * @Date: 2020-07-29 23:06:22
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-21 18:28:18
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\exception\LatestArrayIndex.java
 */
package twenty.july.exception;

//! 父类(throw SmallException)
public class LatestArrayIndex {
  public LatestArrayIndex() throws BigException {
  }

  public void f() throws BigException, SmallException {
  }
}

/// 异常类(小的)
class SmallException extends OpenException {
  private static final long serialVersionUID = 1L;
}

/// 异常类(大的)
class BigException extends Exception {
  private static final long serialVersionUID = 1L;

  public BigException(String s) {
    super(s);
  }
}

//! 子类(Override, throw BigException)
class NewClass extends LatestArrayIndex {
  /**
   * *子类重写函数,throws不能超过父类中对应函数throws的范围(编写时会报错提示)
   * !构造函数相反,子类构造函数必须throws父类构造函数的所有Exception
   */
  //! @Override 子类不能继承构造方法,不能Override
  public NewClass() throws SmallException,BigException {
    throw new BigException("正常抛出的异常");//? 自定义异常信息
  }

  @Override
  public void f() throws SmallException {
  }
}

class Test {
  public static void main(String[] args) {
    /**
     *  main方法上也可以throw exception,但是会抛出到JVM上,无法处理异常导致Error
     */
    try {
      /**
       *  NewClass有异常(构造函数抛出的)
       * ! 很重要得一点是如果try{}里面某条语句catch到exception,则不会继续执行下面的语句(sysout(p))
       */
      LatestArrayIndex p = new NewClass();
      System.out.println(p);
    } catch (BigException | SmallException e) { //? 多异常的写法
      e.printStackTrace();
    }
  }
}

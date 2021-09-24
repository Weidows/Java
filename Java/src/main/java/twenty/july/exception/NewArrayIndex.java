/*
 * @Author: Weidows
 * @Date: 2020-07-27 23:17:36
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-20 22:41:47
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\exception\NewArrayIndex.java
 */
package twenty.july.exception;

public class NewArrayIndex {
  private static int open() {
    // int[] a = new int[10];
    // a[10] = 10;
    return -1;
  }

  /**
   * !如果需要在程序内部throw一个异常,则需要throws declaration或者放在try-catch里
   *  throws或catch的东西是一个继承自Throwable的一个子类(的对象)
   *  throws声明后也可以不throw异常(throws只是声明函数 "可能" 会存在异常)
   */
  public static void readFile() throws OpenException, CloseException {
    if (open() == -1) {
      throw new OpenException(); // ! 抛出异常
      /**
       * ! 可以throw的是任何继承了Throwable类的对象(比如异常Exception类)
       *    *java里所有异常类继承自Exception类,Exception继承自Throwable
       *      ?比如在catch()里写Exception/Throwable e,就可以捕捉任何异常
       *    throw new Exception();
       *    throw new Exception("String");
       *    Exception类带俩构造函数,所需参数如上.
       */
    }
  }

  public static void main(String[] args) {
    /**
     * 声明了throws的函数必须在try里调用,而且必须给全throws的对应catch
     * *catch exception是从上到下顺序,某异常捕捉到了就不会再次被捕捉
     * !父类的catch可以捕捉子类的exception,所以父类的catch不能写在子类上面
     */
    try {
      NewArrayIndex.readFile();
    } catch (NullPointerException e) {
      e.printStackTrace();
    } catch (OpenException e) {
      e.printStackTrace();
    } catch (CloseException e) {
      e.printStackTrace();
    } catch (Exception e) { //*可以捕捉任何异常(包括系统性异常),避免程序崩溃
      e.printStackTrace();
    } finally {
      /**
       * finally是无论有没有异常/异常有没有被处理都会被执行
       * 在文件IO && JDBC中经常使用
       */
      System.out.println("Running in finally");
    }
  }
}

/// 两个Exception类
class OpenException extends Throwable {
  private static final long serialVersionUID = 1760650211683836348L;
}

class CloseException extends Exception {
  private static final long serialVersionUID = -7771616778594864276L;
}

/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-28 11:08:57
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-28 11:18:49
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\reflection\Generic.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Generic {

  public void test01(Map<String, User> map, List<User> list) {
  }

  public Map<String, User> test02() {
    return null;
  }

  public static void main(String[] args) throws NoSuchMethodException {
    /**
     * 获取参数(map,list)的泛型参数(String,User)
     */
    Method method = Generic.class.getMethod("test01", Map.class, List.class);
    Type[] genericParameterTypes = method.getGenericParameterTypes();
    for (Type genericParameterType : genericParameterTypes) {
      System.out.println("范型参数" + genericParameterType);
      if (genericParameterType instanceof ParameterizedType) {
        Type[] actualTypeAnguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
        for (Type actualTypeAngument : actualTypeAnguments) {
          System.out.println("  实际参数范型" + actualTypeAngument);
        }
      }
    }

    System.out.println("--------------------------------------------");

    /**
     * 获取返回值的泛型参数
     */
    Method method1 = Generic.class.getMethod("test02", null);
    Type getGenericReturnType = method1.getGenericReturnType();
    if (getGenericReturnType instanceof ParameterizedType) {
      Type[] actualTypeArguments = ((ParameterizedType) getGenericReturnType).getActualTypeArguments();
      for (Type actualTypeArgument : actualTypeArguments) {
        System.out.println("返回值范型" + actualTypeArgument);
      }
    }
  }
  /**
    范型参数java.util.Map<java.lang.String, twenty_one.reflection.User>
    实际参数范型class java.lang.String
    实际参数范型class twenty_one.reflection.User
    范型参数java.util.List<twenty_one.reflection.User>
    实际参数范型class twenty_one.reflection.User
    --------------------------------------------
    返回值范型class java.lang.String
    返回值范型class twenty_one.reflection.User
   */
}

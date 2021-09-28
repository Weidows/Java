import com.wei.dao.UserDaoMySQL;
import com.wei.service.UserService;
import com.wei.service.UserServiceImpl;

/*
 * @Author: Weidows
 * @Date: 2020-11-07 10:32:43
 * @LastEditors: Weidows
 * @LastEditTime: 2020-11-07 11:10:09
 * @FilePath: \SpringBoot\Spring-1\src\test\java\Mytest.java
 * @Description:
 */
public class Mytest {
  public static void main(String[] args) {
    /**
     * 用户实际接触的是Service业务层,Dao层不需要接触
     * 使用.setUserDao()之后程序主动性交给用户,而不是写死在代码里
     */
    UserService userService = new UserServiceImpl();
    ((UserServiceImpl) userService).setUserDao(new UserDaoMySQL());
    userService.getUser();
  }
}

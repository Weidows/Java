package dao;

import org.apache.ibatis.annotations.*;
import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

  @Select("select * from mybatis.user")
  List<User> getUsers();

  /*
    基本类型的参数或者String类型，需要加上
    引用类型不需要加
    如果只有一个基本类型的话，可以忽略，但是建议都加上
    我们在SQL中引用的就是我们这里的@Param()中设定的属性名
    重要: 这里方法不能重载! 两个同名方法会使MyBatis运行报错(开发时JDK不会报错)
  */
  @Select("select * from mybatis.user where id = #{id}")
  User getUserById(int id);

  // 多个参数的情况下,必须加上@Param注解
  @Select("select * from mybatis.user where id = #{id} and name = #{name}")
  User getUserByIdAndName(@Param("id") int id, @Param("name") String name);

  @Insert("insert into mybatis.user(id,name,pwd) values (#{id},#{name},#{pwd})")
  int addUser(User user);

  //注意SQL格式,set 和 where顺序不能颠倒
  @Update("update mybatis.user set name = #{name},pwd = #{pwd} where id = #{id}")
  int updateUser(User user);

  @Delete("delete from mybatis.user where id = #{id}")
  int deleteUserById(int id);
}

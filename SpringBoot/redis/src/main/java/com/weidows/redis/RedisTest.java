/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-09-28 10:46:32
 * @LastEditors: Weidows
 * @LastEditTime: 2021-09-28 10:55:25
 * @FilePath: \Java\src\main\java\redis\RedisTest.java
 * @Description:
 * @!: *********************************************************************
 */
package redis;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

public class RedisTest {
  @Test
  public void redisTester() {
    RedisProperties.Jedis jedis = new RedisProperties.Jedis("localhost", 6379, 100000);
    int i = 0;
    try {
      long start = System.currentTimeMillis();// 开始毫秒数
      while (true) {
        long end = System.currentTimeMillis();
        if (end - start >= 1000) {// 当大于等于1000毫秒（相当于1秒）时，结束操作
          break;
        }
        i++;
        jedis.set("test" + i, i + "");
      }
    } finally {// 关闭连接
      jedis.close();
    }
    // 打印1秒内对Redis的操作次数
    System.out.println("redis每秒操作：" + i + "次");
  }
}

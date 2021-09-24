<!--
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2020-12-13 21:24:10
 * @LastEditors: Weidows
 * @LastEditTime: 2020-12-13 21:34:36
 * @FilePath: \Weidows\Java\src\main\java\twenty\november\thread\bank\README.md
 * @Description:
 * @!: *********************************************************************
-->

# 模拟银行

- 一个人只能有一个账户 Account
- 那个人可以同时在多个终端设备上访问 Account
  - 比如`微信`和`支付宝`同时操作

---

# 需求

- 数据由 Account 类操作,每个终端设备操作时开 User 类的线程
  - User 实现 Runnable 接口
- 设置同步锁,在某个终端操作数据时令另一个终端无法操作数据.

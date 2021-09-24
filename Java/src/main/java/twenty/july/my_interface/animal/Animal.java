/*
 * @Author: Weidows
 * @Date: 2020-07-20 14:25:10
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-25 17:40:28
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\my_interface\animal\Animal.java
 */
package twenty.july.my_interface.animal;

import java.util.ArrayList;

import twenty.july.my_interface.field.Location;

public abstract class Animal {
  private int ageLimit;
  private int breedableAge;
  private int age;
  private boolean isAlive = true;

  public Animal(int ageLimit, int breedableAge) {
    this.ageLimit = ageLimit;
    this.breedableAge = breedableAge;
  }

  protected int getAge() {
    return age;
  }

  protected double getAgePercent() {
    return (double) age / (double) ageLimit;
  }

  public abstract Animal breed();

  public void grow() {
    age++;
    if (age >= ageLimit)
      die();
  }

  public void die() {
    isAlive = false;
  }

  public boolean isAlive() {
    return isAlive;
  }

  public boolean isBreedable() {
    return (age >= breedableAge);
  }

  public Location move(Location[] freeAdj) {
    Location ret = null;
    if (freeAdj.length > 0 && Math.random() < 0.02) {
      ret = freeAdj[(int) (Math.random() * freeAdj.length)];
    }
    return ret;
  }

  @Override
  public String toString() {
    return "" + age + ":" + (isAlive ? "live" : "dead");
  }

  public Animal feed(ArrayList<Animal> neighbor) {
    return null;
  }

  protected void longerLife(int inc) {
    ageLimit += inc;
  }

}
/*
 * @Author: Weidows
 * @Date: 2020-07-20 14:25:10
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-25 14:33:39
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\control_inversion\animal\Animal.java
 */
package twenty.july.control_inversion.animal;

import java.util.ArrayList;

import twenty.july.control_inversion.field.Location;

public abstract class Animal {
  private int ageLimit;
  private int breedableAge;
  private int age;

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
  }

  public boolean isAlive() {
    return age < ageLimit;
  }

  public boolean isBreedable() {
    return age >= breedableAge;
  }

  public Location move(Location[] freeAdj) {
    Location ret = null;
    if (freeAdj.length > 0 && Math.random() < 0.12) {
      ret = freeAdj[(int) (Math.random() * freeAdj.length)];
    }
    return ret;
  }

  @Override
  public String toString() {
    return "" + age + ":" + (age > ageLimit ? "live" : "dead");
  }

  public Animal feed(ArrayList<Animal> neighbor) {
    return null;
  }

  protected void longerLife(int inc) {
    ageLimit += inc;
  }
}
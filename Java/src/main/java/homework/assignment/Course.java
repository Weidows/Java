package homework.assignment;

import java.io.Serializable;
import java.util.Objects;

public class Course implements Serializable {

  private String number;
  private String name;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Course course = (Course) o;
    return Objects.equals(number, course.number) && Objects.equals(name, course.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, name);
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

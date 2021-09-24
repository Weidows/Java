package assignment;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Student implements Serializable, Cloneable {
  private String surname;
  private String firstName;
  private String id;

  private LocalDate dob;
  private Course course;
  private Address address;

  @Override
  public Student clone() throws CloneNotSupportedException {
    //shadow clone
    Student student = (Student) super.clone();
    //deep clone
    student.address = (Address) this.address.clone();
    return student;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return Objects.equals(surname, student.surname) && Objects.equals(firstName, student.firstName) && Objects.equals(id, student.id) && Objects.equals(dob, student.dob) && Objects.equals(course, student.course) && Objects.equals(address, student.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(surname, firstName, id, dob, course, address);
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public LocalDate getDob() {
    return dob;
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}

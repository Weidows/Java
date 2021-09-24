package pojo;

public class People {
  private int id;
  private String name;
  private int age;
  private String address;

  public People() {
  }

  public People(int id, String name, int age, String address) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.address = address;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "People{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", address='" + address + '\'' +
        '}';
  }

  public static void main(String[] args) {
    new People(1, "秦疆1号", 3, "西安");
    new People(2, "秦疆2号", 3, "西安");
    new People(3, "秦疆3号", 3, "西安");
  }
}

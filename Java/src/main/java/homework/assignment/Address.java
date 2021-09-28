package homework.assignment;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable, Cloneable {
  private String town;
  private String street;
  private String postCode;
  private int houseNumber;

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Address address = (Address) o;
    return houseNumber == address.houseNumber && Objects.equals(town, address.town) && Objects.equals(street, address.street) && Objects.equals(postCode, address.postCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(town, street, postCode, houseNumber);
  }

  public String getTown() {
    return town;
  }

  public void setTown(String town) {
    this.town = town;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public int getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(int houseNumber) {
    this.houseNumber = houseNumber;
  }
}

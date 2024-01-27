package RideShareSystem;

import java.util.Objects;

/**
 * Class to represent a name. This class is immutable.
 */
public class Name {
  private String firstName;
  private String lastName;

  /**
   * Constructor for a name.
   * @param firstName The first name, as a String.
   * @param lastName The last name, as a String.
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Getter for the first name.
   * @return The first name, as a String.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   *  Getter for the last name.
   * @return The last name, as a String.
   */
  public String getLastName() {
    return lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name name = (Name) o;
    return Objects.equals(firstName, name.firstName) && Objects.equals(lastName,
        name.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  @Override
  public String toString() {
    return this.lastName + ", " + this.firstName;
  }
}

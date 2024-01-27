package RideShareSystem;

import java.time.LocalDate;

/**
 * Class to represent a driver's license. This class is immutable.
 */
public class DriversLicense {
  private final String licenseNumber;
  private final Name name;
  private final LocalDate birthDate;
  private final String Address;
  private final String stateOfIssue;
  private final String countryOfIssue;
  private final LocalDate issuanceDate;
  private final LocalDate expirationDate;

  /**
   * Constructor for a driver's license.
   * @param licenseNumber The license number, as a String.
   * @param name The name of the license holder, as a Name object.
   * @param birthDate The birthdate of the license holder, as a LocalDate object.
   * @param address The address of the license holder, as a String.
   * @param stateOfIssue  The state of issue of the license, as a String.
   * @param countryOfIssue The country of issue of the license, as a String.
   * @param issuanceDate The issuance date of the license, as a LocalDate object.
   * @param expirationDate The expiration date of the license, as a LocalDate object.
   */
  public DriversLicense(String licenseNumber, Name name, LocalDate birthDate, String address,
      String stateOfIssue, String countryOfIssue, LocalDate issuanceDate, LocalDate expirationDate) {
    this.licenseNumber = licenseNumber;
    this.name = name;
    this.birthDate = birthDate;
    this.Address = address;
    this.stateOfIssue = stateOfIssue;
    this.countryOfIssue = countryOfIssue;
    this.issuanceDate = issuanceDate;
    this.expirationDate = expirationDate;
  }

  /**
   * Getter for the issuance date of the license.
   * @return The issuance date of the license, as a LocalDate object.
   */
  public LocalDate getIssuanceDate() {
    return issuanceDate;
  }

  /**
   * Getter for the license number.
   * @return The license number, as a String.
   */
  public String getLicenseNumber() {
    return licenseNumber;
  }

  /**
   * Getter for the name of the license holder.
   * @return The name of the license holder, as a Name object.
   */
  public Name getName() {
    return name;
  }

  /**
   * Getter for the birthdate of the license holder.
   * @return The birthdate of the license holder, as a LocalDate object.
   */
  public LocalDate getBirthDate() {
    return birthDate;
  }

  /**
   * Getter for the address of the license holder.
   * @return The address of the license holder, as a String.
   */
  public String getAddress() {
    return Address;
  }

  /**
   * Getter for the state of issue of the license.
   * @return The state of issue of the license, as a String.
   */
  public String getStateOfIssue() {
    return stateOfIssue;
  }

  /**
   * Getter for the country of issue of the license.
   * @return The country of issue of the license, as a String.
   */
  public String getCountryOfIssue() {
    return countryOfIssue;
  }

  /**
   * Getter for the expiration date of the license.
   * @return The expiration date of the license, as a LocalDate object.
   */
  public LocalDate getExpirationDate() {
    return expirationDate;
  }
}

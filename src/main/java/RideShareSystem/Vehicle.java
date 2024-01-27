package RideShareSystem;

import java.time.LocalDate;
import java.util.Set;

/**
 * Class to represent a vehicle. This class is immutable.
 */

public class Vehicle {
  private final String make;
  private final String model;
  private final String year;
  private final String color;
  private final String licensePlate;
  private final LocalDate insuranceIssuanceDate;
  private final LocalDate insuranceExpirationDate;
  private final Name officialOwner;
  private final Set<Name> insuredDrivers;

  /**
   * Constructor for a vehicle.
   * @param make The make of the vehicle, as a String.
   * @param model The model of the vehicle, as a String.
   * @param year The year of the vehicle, as a String.
   * @param color The color of the vehicle, as a String.
   * @param licensePlate The license plate of the vehicle, as a String.
   * @param insuranceIssuanceDate The insurance issuance date of the vehicle, as a LocalDate object.
   * @param insuranceExpirationDate   The insurance expiration date of the vehicle, as a LocalDate object.
   * @param officialOwner    The official owner of the vehicle, as a Name object.
   * @param insuredDrivers  The insured drivers of the vehicle, as a Set of Name objects.
   */

  public Vehicle(String make, String model, String year, String color, String licensePlate, LocalDate insuranceIssuanceDate, LocalDate insuranceExpirationDate, Name officialOwner,
      Set<Name> insuredDrivers) {
    this.year = year;
    this.color = color;
    this.make = make;
    this.model = model;
    this.licensePlate = licensePlate;
    this.insuranceIssuanceDate = insuranceIssuanceDate;
    this.insuranceExpirationDate = insuranceExpirationDate;
    this.officialOwner = officialOwner;
    this.insuredDrivers = insuredDrivers;
  }

  /**
   * Getter for the make of the vehicle.
   * @return The make of the vehicle, as a String.
   */
  public String getMake() {
    return make;
  }
  /**
   * Getter for the model of the vehicle.
   * @return The model of the vehicle, as a String.
   */
  public String getModel() {
    return model;
  }

  /**
   * Getter for the year of the vehicle.
   * @return The year of the vehicle, as a String.
   */
  public String getYear() {
    return year;
  }

  /**
   * Getter for the color of the vehicle.
   * @return The color of the vehicle, as a String.
   */
  public String getColor() {
    return color;
  }

  /**
   * Getter for the license plate of the vehicle.
   * @return The license plate of the vehicle, as a String.
   */
  public String getLicensePlate() {
    return licensePlate;
  }

  /**
   * Getter for the insurance issuance date of the vehicle.
    * @return The insurance issuance date of the vehicle, as a LocalDate object.
   */

  public LocalDate getInsuranceIssuanceDate() {
    return insuranceIssuanceDate;
  }

  /**
   * Getter for the insurance expiration date of the vehicle.
   * @return The insurance expiration date of the vehicle, as a LocalDate object.
   */
  public LocalDate getInsuranceExpirationDate() {
    return insuranceExpirationDate;
  }

  /**
   * Getter for the official owner of the vehicle.
   * @return   The official owner of the vehicle, as a Name object.
   */

  public Name getOfficialOwner() {
    return officialOwner;
  }

  /**
   * Getter for the insured drivers of the vehicle.
   * @return The insured drivers of the vehicle, as a Set of Name objects.
   */
  public Set<Name> getInsuredDrivers() {
    return insuredDrivers;
  }

  @Override
  public String toString() {
    return this.year + " " +
        this.color + " " +
        this.make + " " +
        this.model + ", " +
        this.licensePlate;
  }
}

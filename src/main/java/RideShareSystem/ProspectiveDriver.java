package RideShareSystem;

import java.time.LocalDate;

/**
 * Class to represent a prospective driver. This class is immutable.
 */
public class ProspectiveDriver {
  private final Name name;
  private final Integer age;
  private final LocalDate birthDate;
  private final DriversLicense driversLicense;
  private final Vehicle vehicle;
  private final Crashes crashes;
  private final Violations violations;

  /**
   * Constructor for a prospective driver. This constructor is polymorphic,
   * and can be called with or without crashes and violations.
   * @param name The name of the prospective driver, as a Name object.
   * @param birthDate The birthdate of the prospective driver, as a LocalDate object.
   * @param driversLicense The driver's license of the prospective driver, as a DriversLicense object.
   * @param vehicle The vehicle of the prospective driver, as a Vehicle object.
   * @param crashes The crashes of the prospective driver, as a Crashes object.
   * @param violations The violations of the prospective driver, as a Violations object.
   */
  public ProspectiveDriver(Name name, LocalDate birthDate, DriversLicense driversLicense,
      Vehicle vehicle, Crashes crashes, Violations violations) {
    this.name = name;
    this.age = LocalDate.now().getYear() - birthDate.getYear();
    this.birthDate = birthDate;
    this.driversLicense = driversLicense;
    this.vehicle = vehicle;
    this.crashes = crashes;
    this.violations = violations;
  }

  /**
   * Constructor for a prospective driver. This constructor is for a driver with no crashes or violations.
   */
  public ProspectiveDriver(Name name, LocalDate birthDate, DriversLicense driversLicense,
      Vehicle vehicle) {
    this(name, birthDate, driversLicense, vehicle, null, null);
  }

  /**
   * Constructor for a prospective driver. This constructor is for a driver with no violations.
   */
  public ProspectiveDriver(Name name, LocalDate birthDate, DriversLicense driversLicense,
      Vehicle vehicle, Crashes crashes) {
    this(name, birthDate, driversLicense, vehicle, crashes, null);
  }

  /**
   * Constructor for a prospective driver. This constructor is for a driver with no crashes.
   */
  public ProspectiveDriver(Name name, LocalDate birthDate, DriversLicense driversLicense,
      Vehicle vehicle,Violations violations) {
    this(name, birthDate, driversLicense, vehicle, null, violations);
  }

  /**
   * Getter for the name of the prospective driver.
   * @return The name of the prospective driver, as a Name object.
   */
  public Name getName() {
    return name;
  }
  /**
   * Getter for the age of the prospective driver.
   * @return The age of the prospective driver, as an Integer.
   */
  public Integer getAge() {
    return age;
  }
  /**
   * Getter for the birthdate of the prospective driver.
   * @return The birthdate of the prospective driver, as a LocalDate object.
   */
  public LocalDate getBirthDate() {
    return birthDate;
  }
  /**
   * Getter for the driver's license of the prospective driver.
   * @return The driver's license of the prospective driver, as a DriversLicense object.
   */
  public DriversLicense getDriversLicense() {
    return driversLicense;
  }
  /**
   * Getter for the vehicle of the prospective driver.
   * @return The vehicle of the prospective driver, as a Vehicle object.
   */
  public Vehicle getVehicle() {
    return vehicle;
  }
  /**
   * Getter for the crashes of the prospective driver.
   * @return The crashes of the prospective driver, as a Crashes object.
   */
  public Crashes getCrashes() {
    return crashes;
  }
  /**
   * Getter for the violations of the prospective driver.
   * @return The violations of the prospective driver, as a Violations object.
   */
  public Violations getViolations() {
    return violations;
  }
}

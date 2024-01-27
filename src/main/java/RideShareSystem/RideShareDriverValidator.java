package RideShareSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class to validate a prospective driver's information based on the requirements of the ride-share system. This class includes a main method for execution.
 */
public class RideShareDriverValidator {
  private Set<AcceptedDriver> acceptedDrivers;

  /**
   * Constructor for the validator. The acceptedDrivers set is initialized to an empty HashSet.
   */

  public RideShareDriverValidator() {
    acceptedDrivers = new HashSet<>();
  }

  /**
   * Method to register a driver with the ride-share system. If the driver is successfully registered, the driver is added to the acceptedDrivers set.
   * @param prospectiveDriver The prospective driver to register, as a ProspectiveDriver object.
   * @param vehicle The vehicle of the prospective driver, as a Vehicle object.
   */
  public void registerDriver(ProspectiveDriver prospectiveDriver, Vehicle vehicle) {
    RegistrationValidator validator = new RegistrationValidator();
    if (validator.validate(prospectiveDriver, vehicle)) {
      AcceptedDriver acceptedDriver = new AcceptedDriver(prospectiveDriver);
      acceptedDrivers.add(acceptedDriver);
      System.out.println("Driver successfully registered!");
    } else {
      System.out.println("Driver registration failed. The driver doesn't meet the registration requirements.");
    }
  }

  /**
   * Method to provide information about registered drivers with a given last name. The output will be sorted by first name.
   * @param lastName The last name of the registered drivers to provide information about, as a String.
   */

  public void provideDriverInfo(String lastName) {
    List<AcceptedDriver> matchingDrivers = new ArrayList<>();
    for (AcceptedDriver driver : acceptedDrivers) {
      if (driver.getAcceptedDriver().getName().getLastName().equalsIgnoreCase(lastName)) {
        matchingDrivers.add(driver);
      }
    }

    if (matchingDrivers.isEmpty()) {
      System.out.println("No registered driver found");
    } else {
      // Sort matching drivers by first names
      Collections.sort(matchingDrivers, Comparator.comparing(
          driver -> driver.getAcceptedDriver().getName().getFirstName(),
          String.CASE_INSENSITIVE_ORDER
      ));

      for (AcceptedDriver driver : matchingDrivers) {
        System.out.println(driver.getAcceptedDriver().getName().toString());
        System.out.println("      " + driver.getAcceptedDriver().getVehicle().toString());
      }
    }
  }

  /**
   * Getter for the acceptedDrivers set.
   * @return The acceptedDrivers set, as a Set of AcceptedDriver objects.
   */


  public Set<AcceptedDriver> getAcceptedDrivers() {
    return acceptedDrivers;
  }

  /**
   * Main Method to work with the validator. uncomment the  main method below to test the validator.
   * Or go to test folder to run the test. (Recommended)
   */
//    public static void main(String[] args) {
//    RideShareDriverValidator validator = new RideShareDriverValidator();
//    Name name1 = new Name("Jim", "Thompson");
//    Name name2 = new Name("Bryant", "Thompson");
//
//    LocalDate birthDate1 = LocalDate.of(1993, 1, 1);
//    LocalDate birthDate2 = LocalDate.of(1990, 1, 1);
//
//    DriversLicense driversLicense1 = new DriversLicense("GG123", name1, LocalDate.of(1993, 1, 1),
//        "main st 10230", "WA", "USA", LocalDate.of(2023, 1, 1),LocalDate.of(2028,1,1) );
//    DriversLicense driversLicense2 = new DriversLicense("Ok123", name2, LocalDate.of(1990, 1, 1),
//        "main st 10230", "BC", "Canada", LocalDate.of(2020, 1, 1),LocalDate.of(2028,1,1) );
//
//    Set<Name> insuredDrivers = new HashSet<>();
//
//    insuredDrivers.add(name1);
//    insuredDrivers.add(name2);
//
//    Vehicle vehicle1 = new Vehicle("Toyota", "Camry", "2015", "Black", "ABC1234", LocalDate.of(2019, 1, 1), LocalDate.of(2025, 1, 1), name1, insuredDrivers);
//    Vehicle vehicle2 = new Vehicle("Telsa", "Model3", "2022", "Red", "SUPER00", LocalDate.of(2019, 1, 1), LocalDate.of(2026, 1, 1), name2, insuredDrivers);
//
//    Crashes crashes1 = new Crashes(name1, LocalDate.of(2021, 10, 1), CrashType.FENDER_BENDER);
//    Violations violations1 = new Violations(LocalDate.of(2019, 1, 1), List.of(Violations.MovingViolation.DRIVING_UNDER_INFLUENCE), List.of(Violations.NonMovingViolation.PARKING_VIOLATION));
//    ProspectiveDriver prospectiveDriver1 = new ProspectiveDriver(name1, birthDate1, driversLicense1, vehicle1, crashes1, null);
//    ProspectiveDriver prospectiveDriver2 = new ProspectiveDriver(name2, birthDate2, driversLicense2, vehicle2, null, violations1);
//    ProspectiveDriver prospectiveDriver3 = new ProspectiveDriver(name2, birthDate2, driversLicense2, vehicle2);
//    ProspectiveDriver prospectiveDriver4 = new ProspectiveDriver(name1, birthDate1, driversLicense2, vehicle1);
//    validator.registerDriver(prospectiveDriver1, vehicle1);
//    validator.registerDriver(prospectiveDriver2, vehicle2);
//    validator.registerDriver(prospectiveDriver3, vehicle1);
//    validator.registerDriver(prospectiveDriver4, vehicle1);
//    validator.provideDriverInfo("Thompson"); // two registered drivers with Last name Thompson in system
//    validator.provideDriverInfo("Hanks"); //no registered driver with Last name Hanks
//  }
}

package RideShareSystem;

import RideShareSystem.Crashes.CrashType;
import RideShareSystem.Violations.MovingViolation;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class to validate a prospective driver's information based on the requirements of the ride-share system.
 */
public class RegistrationValidator {

  /**
   * Method to validate a prospective driver's information based on the requirements of the
   * ride-share system.
   *
   * @param prospectiveDriver The prospective driver to validate, as a ProspectiveDriver object.
   * @param vehicle           The vehicle of the prospective driver, as a Vehicle object.
   * @return True if the driver information is valid, false otherwise.
   */
  public boolean validate(ProspectiveDriver prospectiveDriver, Vehicle vehicle) {
    //check age
    if (prospectiveDriver.getAge() < 21) {
      return false;
    }
    //check birthdate
    if (!prospectiveDriver.getDriversLicense().getBirthDate()
        .equals(prospectiveDriver.getBirthDate())) {
      return false;
    }
    //check name
    if (!prospectiveDriver.getDriversLicense().getName().equals(prospectiveDriver.getName())) {
      return false;
    }
    // check country of issue
    if (!prospectiveDriver.getDriversLicense().getCountryOfIssue().equals("USA")
        && !prospectiveDriver.getDriversLicense().getCountryOfIssue().equals("Canada")) {
      return false;
    }
    // check date of issue is more than six months ago
    if (!prospectiveDriver.getDriversLicense().getIssuanceDate()
        .isBefore(LocalDate.now().minusMonths(6))) {
      return false;
    }
    // check expiration date
    if (prospectiveDriver.getDriversLicense().getExpirationDate().isBefore(LocalDate.now())) {
      return false;
    }
    //check if the vehicle is older than 15 years
    if (Integer.parseInt(vehicle.getYear()) < LocalDate.now().getYear() - 15) {
      return false;
    }
    //check if the owner of the vehicle is the same as the driver or the driver is the insured driver
    if (!prospectiveDriver.getName().equals(vehicle.getOfficialOwner())
        && !vehicle.getInsuredDrivers().contains(prospectiveDriver.getName())) {
      return false;
    }
    //check if the insurance is expired
    if (vehicle.getInsuranceExpirationDate().isBefore(LocalDate.now())) {
      return false;
    }
    //check if the driver has moving violations, if yes, do those including DUIs, reckless driving, or speeding, or driving without a  valid license
    if (prospectiveDriver.getViolations() != null) {
      for (Violations.MovingViolation violation : prospectiveDriver.getViolations()
          .getMovingViolations()) {
        if (violation.equals(MovingViolation.DRIVING_UNDER_INFLUENCE) || violation.equals(
            Violations.MovingViolation.RECKLESS_DRIVING) || violation.equals(
            Violations.MovingViolation.SPEEDING) || violation.equals(
            MovingViolation.Driving_Without_a_License_or_Insurance)) {
          return false;
        }
      }
    }
    //check any crashes or moving violations committed with this vehicle in the last six months? If yes, then prospective driver should not be accepted as a driver.
    if (prospectiveDriver.getCrashes() != null) {
      if (prospectiveDriver.getCrashes().getCrashDate().isAfter(LocalDate.now().minusMonths(6))) {
        return false;
      }
    }
      return true; // Return true if the driver information is valid
  }
}
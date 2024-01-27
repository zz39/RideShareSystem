package RideShareSystem;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * Class to represent a violation event that a driver has been involved in. This class is immutable.
 */

public class Violations {
  private final LocalDate violationDate;
  private final List<MovingViolation> movingViolations;
  private final List<NonMovingViolation> nonMovingViolations;

  /**
   * Constructor for a violation event.
   * @param violationDate The date of the violation, as a LocalDate object.
   * @param movingViolations The moving violations of the driver, as a List of MovingViolation enums.
   * @param nonMovingViolations The non-moving violations of the driver, as a List of NonMovingViolation enums.
   */
  public Violations(LocalDate violationDate, List<MovingViolation> movingViolations, List<NonMovingViolation> nonMovingViolations) {
    this.violationDate = violationDate;
    this.movingViolations = movingViolations;
    this.nonMovingViolations = nonMovingViolations;
  }

  /**
   * Constructor for a violation event with no moving violations.
   * @param violationDate The date of the violation, as a LocalDate object.
   * @param nonMovingViolations The non-moving violations of the driver, as a List of NonMovingViolation enums.
   */



  /**
   * Getter for the date of the violation.
   * @return The date of the violation, as a LocalDate object.
   */
  public List<MovingViolation> getMovingViolations() {
    return movingViolations;
  }

  /**
   * Getter for the moving violations of the driver.
   * @return The moving violations of the driver, as a List of MovingViolation enums.
   */
  public List<NonMovingViolation> getNonMovingViolations() {
    return nonMovingViolations;
  }

  /**
   * Getter for the non-moving violations of the driver.
   * @return The non-moving violations of the driver, as a List of NonMovingViolation enums.
   */
  public LocalDate getViolationDate() {
    return violationDate;
  }

  /**
   * Enum to represent the type of moving violation.
   */

  public enum MovingViolation {
    DISTRACTED_DRIVING,
    RECKLESS_DRIVING,
    SPEEDING,
    DRIVING_UNDER_INFLUENCE,
    FAILURE_TO_RESPECT_TRAFFIC_SIGNS,
    Driving_Without_a_License_or_Insurance
  }

  /**
   * Enum to represent the type of non-moving violation.
   */
  public enum NonMovingViolation {
    PARKING_VIOLATION,
    PAPERWORK_ISSUES,
    PROBLEMS_WITH_INSURANCE
  }

}

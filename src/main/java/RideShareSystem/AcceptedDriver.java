package RideShareSystem;

import java.util.List;

/**
 * Class to represent a driver who has been accepted into the rideshare system.
 */
public class AcceptedDriver{
  private final ProspectiveDriver acceptedDriver;

  /**
   * Constructor for an accepted driver.
   * @param prospectiveDriver The driver who has been accepted, as a ProspectiveDriver object.
   */
  public AcceptedDriver(ProspectiveDriver prospectiveDriver) {
    this.acceptedDriver = prospectiveDriver;
  }

  /**
   * Getter for the driver who has been accepted.
   * @return The driver who has been accepted, as a ProspectiveDriver object.
   */
  public ProspectiveDriver getAcceptedDriver() {
    return acceptedDriver;
  }
}
package RideShareSystem;

import java.time.LocalDate;

/**
 * Class to represent a crash event that a driver has been involved in.
 */
public class Crashes {
  private final LocalDate crashDate;
  private final Name offendingDriver;
  private final CrashType crashType;

  /**
   * Constructor for a crash event.
   * @param offendingDriver The driver who caused the crash, as a Name object.
   * @param crashDate The date of the crash, as a LocalDate object.
   * @param crashType The type of crash, as a CrashType enum.
   */
  public Crashes(Name offendingDriver, LocalDate crashDate, CrashType crashType) {
    this.offendingDriver = offendingDriver;
    this.crashDate =  crashDate;
    this.crashType = crashType;
  }

  /**
   * Getter for the date of the crash.
   * @return The date of the crash, as a LocalDate object.
   */
  public LocalDate getCrashDate() {
    return crashDate;
  }
  /**
   * Getter for the type of crash.
   * @return The type of crash, as a CrashType enum.
   */

  public CrashType getCrashType() {
    return crashType;
  }

  /**
   * Enum to represent the type of crash.
   */
  public enum CrashType {
    FENDER_BENDER,
    CRASH_With_Bodily_Injuries,
    CRASH_Without_Bodily_Injuries
  }

  /**
   * Getter for the driver who caused the crash.
   * @return The driver who caused the crash, as a Name object.
   */
  public Name getOffendingDriver() {
    return offendingDriver;
  }
}

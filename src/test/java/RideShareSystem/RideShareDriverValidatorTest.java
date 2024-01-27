package RideShareSystem;

import static org.junit.jupiter.api.Assertions.*;

import RideShareSystem.Crashes.CrashType;
import RideShareSystem.Violations.MovingViolation;
import RideShareSystem.Violations.NonMovingViolation;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RideShareDriverValidatorTest {
  private RideShareDriverValidator validator;
  private RegistrationValidator verify = new RegistrationValidator();

  private Name name;
  private LocalDate birthDate;
  private DriversLicense driversLicense;
  private Set<Name> insuredDrivers;
  private Vehicle vehicle;
  private Crashes crashes;
  private Violations violations;
  @BeforeEach
  void setUp() {
    validator = new RideShareDriverValidator();

    name = new Name("Peter", "Parker");
    birthDate = LocalDate.of(1993, 1, 1);

    driversLicense = new DriversLicense(
        "pparker1993", name, birthDate, "main st 10230", "WA", "USA",
        LocalDate.of(2023, 1, 1), LocalDate.of(2028, 1, 1)
    );

    insuredDrivers = new HashSet<>();
    insuredDrivers.add(name);

    vehicle = new Vehicle(
        "Toyota", "Camry", "2015", "Beige", "ABC123",
        LocalDate.of(2019, 1, 1), LocalDate.of(2024, 1, 1), name, insuredDrivers
    );

    crashes = new Crashes(name, LocalDate.of(2021, 10, 1), CrashType.FENDER_BENDER);

    violations = new Violations(
        LocalDate.of(2019, 1, 1),
        List.of(Violations.MovingViolation.DRIVING_UNDER_INFLUENCE),
        List.of(Violations.NonMovingViolation.PARKING_VIOLATION)
    );

  }

  @Test
  void registerDriver() {
    ProspectiveDriver prospectiveDriver = new ProspectiveDriver(name, birthDate, driversLicense, vehicle, crashes);
    ProspectiveDriver prospectiveDriver1 = new ProspectiveDriver(name, birthDate, driversLicense, vehicle, violations);
    ProspectiveDriver prospectiveDriver2 = new ProspectiveDriver(name, birthDate, driversLicense, vehicle);

    validator.registerDriver(prospectiveDriver, vehicle);
    assertEquals(1, validator.getAcceptedDrivers().size());
    assertEquals(LocalDate.of(2019, 1, 1), violations.getViolationDate());
    assertEquals(List.of(Violations.MovingViolation.DRIVING_UNDER_INFLUENCE), violations.getMovingViolations());
    assertEquals(List.of(NonMovingViolation.PARKING_VIOLATION), violations.getNonMovingViolations());
    assertEquals("Toyota", vehicle.getMake());
    assertEquals("Camry", vehicle.getModel());
    assertEquals("Beige", vehicle.getColor());
    assertEquals("ABC123", vehicle.getLicensePlate());
    assertEquals(LocalDate.of(2019, 1, 1), vehicle.getInsuranceIssuanceDate());
    assertEquals(LocalDate.of(2024, 1, 1), vehicle.getInsuranceExpirationDate());
    assertEquals(name, vehicle.getOfficialOwner());
    assertEquals(insuredDrivers, vehicle.getInsuredDrivers());
    assertEquals("pparker1993", prospectiveDriver.getDriversLicense().getLicenseNumber());
    assertEquals("main st 10230", prospectiveDriver.getDriversLicense().getAddress());
    assertEquals("WA", prospectiveDriver.getDriversLicense().getStateOfIssue());
    assertEquals(name, prospectiveDriver.getCrashes().getOffendingDriver());
    assertEquals(CrashType.FENDER_BENDER, prospectiveDriver.getCrashes().getCrashType());
    assertEquals("Peter", prospectiveDriver.getName().getFirstName());
    assertEquals(name, name);

  }

  @Test
  void registerInvalidDriver() {
    ProspectiveDriver prospectiveDriver = new ProspectiveDriver(
        name, LocalDate.now().minusYears(20), driversLicense, vehicle, crashes);

    validator.registerDriver(prospectiveDriver, vehicle);
    assertTrue(validator.getAcceptedDrivers().isEmpty());
  }

  @Test
  void registerWrongBirthdate(){
    ProspectiveDriver prospectiveDriver = new ProspectiveDriver(
        name, LocalDate.of(1997,1,1), driversLicense, vehicle, crashes);
    assertFalse(verify.validate(prospectiveDriver, vehicle));
  }

  @Test
  void registerWrongName(){
    ProspectiveDriver prospectiveDriver = new ProspectiveDriver(
        new Name("Fake", "Name"), LocalDate.of(1993,1,1), driversLicense, vehicle, crashes);
    assertFalse(verify.validate(prospectiveDriver, vehicle));
  }

  @Test
  void WrongPlaceOfRegistration() {
    DriversLicense foreignLicense = new DriversLicense(
        "zhou123", name, birthDate, "main st 10230", "WA", "Germany",
        LocalDate.of(2023, 10, 1), LocalDate.of(2025, 1, 1)
    );
    ProspectiveDriver prospectiveDriver = new ProspectiveDriver(name, birthDate, foreignLicense, vehicle, crashes);
    assertFalse(verify.validate(prospectiveDriver, vehicle));
  }

  @Test
  void InvalidLicenseIssuedWithinSixMonths() {
    DriversLicense expiredLicense = new DriversLicense(
        "zhou123", name, birthDate, "main st 10230", "WA", "USA",
        LocalDate.of(2023, 10, 1), LocalDate.of(2025, 1, 1)
    );
    ProspectiveDriver prospectiveDriver = new ProspectiveDriver(name, birthDate, expiredLicense, vehicle, crashes);
    assertFalse(verify.validate(prospectiveDriver, vehicle));
  }
  @Test
  void validateInvalidExpiredLicense() {
    DriversLicense expiredLicense = new DriversLicense(
        "zhou123", name, birthDate, "main st 10230", "WA", "USA",
        LocalDate.of(2022, 1, 1), LocalDate.of(2023, 1, 1)
    );
    ProspectiveDriver prospectiveDriver = new ProspectiveDriver(name, birthDate, expiredLicense, vehicle, crashes);
    assertFalse(verify.validate(prospectiveDriver, vehicle));
  }

  @Test
  void VehicleTooOld() {
    Vehicle uninsuredVehicle = new Vehicle(
        "Toyota", "Camry", "2000", "Beige", "ABC123",
        LocalDate.of(2019, 1, 1), LocalDate.of(2023, 1, 1), name, new HashSet<>()
    );
    ProspectiveDriver prospectiveDriver = new ProspectiveDriver(name, birthDate, driversLicense, uninsuredVehicle, crashes);
    assertFalse(verify.validate(prospectiveDriver, uninsuredVehicle));
  }

  @Test
  void DriverNotOwnerAndNotInsured() {
    Vehicle invalidVehicle = new Vehicle(
        "Toyota", "Camry", "2015", "Beige", "ABC123",
        LocalDate.of(2019, 1, 1), LocalDate.of(2023, 1, 1), new Name("Real", "Owner"), new HashSet<>(
        List.of(new Name("Insured", "Driver")))
        );
    ProspectiveDriver prospectiveDriver = new ProspectiveDriver(name, birthDate, driversLicense, invalidVehicle, crashes);
    assertFalse(verify.validate(prospectiveDriver, invalidVehicle));
  }

  @Test
  void ExpiredInsurance() {
    Vehicle invalidVehicle = new Vehicle(
        "Toyota", "Camry", "2015", "Beige", "ABC123",
        LocalDate.of(2019, 1, 1), LocalDate.of(2020, 1, 1), name, insuredDrivers
    );
    ProspectiveDriver prospectiveDriver = new ProspectiveDriver(name, birthDate, driversLicense, invalidVehicle, crashes);
    assertFalse(verify.validate(prospectiveDriver, invalidVehicle));
  }

  @Test
  void DUIViolation() {
    violations = new Violations(
        LocalDate.of(2019, 1, 1),
        List.of(Violations.MovingViolation.DRIVING_UNDER_INFLUENCE),
        List.of(Violations.NonMovingViolation.PARKING_VIOLATION)
    );
    ProspectiveDriver prospectiveDriver = new ProspectiveDriver(name, birthDate, driversLicense, vehicle, violations);
    assertFalse(verify.validate(prospectiveDriver, vehicle));
  }
  @Test
  void SpeedingViolation() {
    violations = new Violations(
        LocalDate.of(2019, 1, 1),
        List.of(MovingViolation.SPEEDING),
        List.of(Violations.NonMovingViolation.PARKING_VIOLATION)
    );
    ProspectiveDriver prospectiveDriver = new ProspectiveDriver(name, birthDate, driversLicense, vehicle, violations);
    assertFalse(verify.validate(prospectiveDriver, vehicle));
  }
  @Test
  void NoLicenseViolation() {
    violations = new Violations(
        LocalDate.of(2019, 1, 1),
        List.of(MovingViolation.Driving_Without_a_License_or_Insurance, MovingViolation.SPEEDING, MovingViolation.DRIVING_UNDER_INFLUENCE, MovingViolation.RECKLESS_DRIVING),
        List.of(Violations.NonMovingViolation.PARKING_VIOLATION)
    );
    ProspectiveDriver prospectiveDriver = new ProspectiveDriver(name, birthDate, driversLicense, vehicle, violations);
    assertFalse(verify.validate(prospectiveDriver, vehicle));
  }


  @Test
  void registerInvalidDriverWithCrashesWithinLastSixMonths() {
    crashes = new Crashes(name, LocalDate.now().minusMonths(3), CrashType.FENDER_BENDER);
    ProspectiveDriver prospectiveDriver = new ProspectiveDriver(name, birthDate, driversLicense, vehicle, crashes);
    assertFalse(verify.validate(prospectiveDriver, vehicle));
  }







  @Test
  void provideDriverInfo() {
    ProspectiveDriver prospectiveDriver = new ProspectiveDriver(name, birthDate, driversLicense, vehicle, crashes);
    validator.registerDriver(prospectiveDriver, vehicle);

    // Test providing driver info for an existing driver
    assertDoesNotThrow(() -> validator.provideDriverInfo("Parker"));
  }

  @Test
  void provideDriverInfoNoMatch() {
    // Test providing driver info for a non-existing driver
    assertDoesNotThrow(() -> validator.provideDriverInfo("NonExisting"));
  }

  @Test
  void testEqualsNotEqualObjects() {
    Name name1 = new Name("Taylor", "Swift");
    Name name2 = new Name("Sam", "Smith");
    assertTrue(name1.equals(name1));
    assertFalse(name1.equals(name2));
    assertFalse(name2.equals(name1));
    assertFalse(name1.equals(null));
    assertFalse(name1.equals("JohnDoe"));
  }
}
Project Summary
===============
Option2: RideShareDriverValidator
--------------------------------------
The program checks various criteria such as age, driver's license information, vehicle details, insurance status, driving violations, crashes, etc., 
to determine whether a prospective driver is eligible for registration as an RideShare Driver. Accepted drivers are stored in a set. Driver's Information can be queried.
- The system is designed to be extensible. It is easy to add new criteria to the system.
- The system is designed to be scalable. It is easy to add new types of drivers to the system.
- The system is designed to be maintainable. It is easy to modify the existing criteria.
- Challenges faced:
  - The system verifies many of criteria for a prospective driver. It is difficult to keep track of all the criteria.
  - To test the validator, I had to create a lot of test data. It is time-consuming.
  - Deciding on an appropriate design pattern and architecture is a challenging yet crucial aspect of the project.
1. Please include a code snippet showing how have you used inheritance and composition in your code.
   ```
   public class ProspectiveDriver {
   private final Name name;
   private final Integer age;
   private final LocalDate birthDate;
   private final DriversLicense driversLicense;

   // ... constructor and other methods
   }
    ```
2. Please include a code snippet showing how have you used an interface or an abstract class in your code.
    ```
    based on the nature of the project, I did not see any need for them.
    Due to the design, there are no common methods or attributes between the classes.
    
    ```
3. Please include code example of a method overriding and method overloading from your code, or explain why you have not used any overloading or overriding.
    ```
    I tried to use comparable interface to sort the list of drivers based on their age. However, 
    I explored the possibility of not using it to achieve the same result.
    ```
4. Please include a code example showing how have you used encapsulation, or explain why you did not need encapsulation in your code.
    ```
   public class ProspectiveDriver {
   private final Name name;
   private final Integer age;
   private final LocalDate birthDate;
   private final DriversLicense driversLicense;
   private final Vehicle vehicle;
   private final Crashes crashes;
   private final Violations violations;

   // Getter methods provide encapsulated access to fields
   public Name getName() {
      return name;
   }
   // ... other getter methods}
    ```
5. Please include a code example of subtype polymorphism from your code, or explain why you did not need subtype polymorphism.
    ```
    // constructor that driver with crashes and violations
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
    // constructor that driver with no crashes and violations
    public ProspectiveDriver(Name name, LocalDate birthDate, DriversLicense driversLicense,
      Vehicle vehicle) {
    this(name, birthDate, driversLicense, vehicle, null, null);}
    ```
6. Please include a code snippet of generics from your code.
    ```
    public class Violations {
    private final List<Violation> violations;
    public Violations(List<Violation> violations) {
    this.violations = violations;
    }
    public List<Violation> getViolations() {
    return violations;
    }
    }
    ```
7. Please include a code snippet showing how have you used some of the built-in data
   collections from the Java Collections Framework, or explain why you had no need for
   any data collections.
    ```
    if (matchingDrivers.isEmpty()) {
      System.out.println("No registered driver found");
    } else {
      // Sort matching drivers by first names
      Collections.sort(matchingDrivers, Comparator.comparing(
          driver -> driver.getAcceptedDriver().getName().getFirstName(),
          String.CASE_INSENSITIVE_ORDER
      ));
    ```
8. Please include a code snippet showing how have you used interfaces Iterable and
   Iterator, or explain why you had no need for these two interfaces.
    ```

    public class RideShareDriverValidator implements Iterable<AcceptedDriver> {
    private Set<AcceptedDriver> acceptedDrivers;

    @Override
    public Iterator<AcceptedDriver> iterator() {
    return acceptedDrivers.iterator();
    }
    }
    ```
9. Please include a code snippet showing how have you used interfaces Comparable and
   Comparator, or explain why you had no need for these two interfaces.
    ```
    I tried to use comparable interface to sort the list of drivers based on their age. However, 
    I explored the possibility of not using it to achieve the same result.
    By using the validateDrivers method, I was able to validate the prospective drivers to accepted drivers.
    ```
10. Please include a code snippet showing how have you used regular expressions, or
    explain why you had no need for it.
    ```
    condering the nature of the project, I did not see any need for it.
    the only place might need to use regex is to validate place of issue of the driver's license.
    in this project, only USA and Canada are considered.
    I will consider to use if the program requires to validate other countries or much more complex validation.
    ```
11. Please include a code snippet showing how have you used nested classes, or justify
    why you had no need for nested classes.
    ```
    condering the nature of the project, I did not see any need for it.
    There is no need to create a class inside another class.
    
    ```
12. Please include code example showing how have you used components of functional
    programming, such as lambdas and streams, or explain why you had no need for it in
    your code.
    ```
    Did not use any of functional programming components in this project.
    I am still learning about using them in my code.
    ```
13. Please include code snippet(s) showing how have you used creational, structural
    and/or behavioral design patterns. Please list which design patterns have you used,
    or explain why you had no need for design patterns in your solution.
    ```
    public class RideShareDriverValidator {
    private static RideShareDriverValidator instance;
    
    private Set<AcceptedDriver> acceptedDrivers;
    
    private RideShareDriverValidator() {
    acceptedDrivers = new HashSet<>();
    }
    
    public static RideShareDriverValidator getInstance() {
    if (instance == null) {
    instance = new RideShareDriverValidator();
    }
    return instance;
    }
    ```
14. Please include code snippets showing examples of MVC architecture, or justify why
    you had no need for MVC architecture in your design.
    ```
    Model: ProspectiveDriver, AcceptedDriver, Name, DriversLicense, Vehicle, Crashes, Violations, RegistrationValidator
    View: RideShareDriverValidator
    Controller: RideShareDriverValidator
    ```
15. Please include code examples showing data and stamp coupling in your code.
    ```
    public class RideShareDriverValidator {

    public void registerDriver(ProspectiveDriver prospectiveDriver, Vehicle vehicle) {
    RegistrationValidator validator = new RegistrationValidator();
    if (validator.validate(prospectiveDriver, vehicle)) {
    // ...
    } else {
    // ...
    }

    ```
# Rideshare System - Prospective Drivers Validator and Simulator

## Overview

This project focuses on the development of a driver-side application for a rideshare company, specifically handling the registration and validation of prospective drivers. The system involves capturing various details about the drivers, their vehicles, insurance, driving history, and vehicle history. Additionally, a registration validator ensures that prospective drivers meet specific criteria before being accepted into the system.

## Features

### Prospective Driver Registration

- **Driver Information:**
  - First and last name
  - Birthdate

- **Driver License Information:**
  - License unique number
  - Address
  - Country and state of issuance
  - Issuance and expiration date

- **Vehicle Information:**
  - Make, model, and year of the vehicle
  - Official owner details

- **Vehicle Insurance Information:**
  - Official owner details
  - Insured drivers
  - Insurance expiration date

- **Driver's History:**
  - Traffic violations, including date and type

- **Vehicle History:**
  - Crashes and traffic violations associated with the vehicle

### Registration Validator

The validator checks various criteria to determine if a prospective driver should be accepted:

- Age verification
- Consistency checks on driver's license information
- Vehicle age verification
- Insurance details validation
- Checking for moving violations in driver's history
- Examination of vehicle history for recent violations

### Pool of Existing Accepted Drivers

Accepted drivers are added to a unique pool, ensuring:

- Uniqueness to avoid duplicate entries
- Ability for drivers to register multiple vehicles
- Possibility for a vehicle to be registered with different drivers

### Querying the Pool

The pool can be queried using the `provideDriverInfo` method, displaying information about a specific driver or drivers based on last name.

## Simulation

A `RideshareDriverValidator` class runs the simulation using user-input files containing prospective driver information. Users can interact with the program by searching for potential drivers based on their last name.

## How to Use

- Clone the repository
- Run the simulation using the provided example file
- Explore and query the pool of accepted drivers

## Questions and Answers

After designing, implementing, and testing the system, refer to the write-up document for detailed answers to questions about the code's structure and design decisions.

## Acknowledgments

This project was developed as part of the CS 5004 course in Fall 2023.

## License

This project is licensed under the [MIT License](LICENSE.md).

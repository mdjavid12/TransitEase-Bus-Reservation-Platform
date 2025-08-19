# TransitEase - Bus Reservation Platform

A console-based bus reservation platform built with Java and JDBC, following layered architecture principles.

## Features
- 🚌 Bus availability checking
- 🎟️ Seat booking management
- 📅 Date-based reservation system
- 🏗️ Scalable architecture (DAO-Service-Model)

## Tech Stack
- **Core**: Java 11
- **Database**: MySQL
- **Architecture**: 3-Tier (Model-DAO-Service)

## Setup
1. Import MySQL schema from `db/schema.sql`
2. Configure DB credentials in `DbConnection.java`
3. Run `Main.java`

## Future Roadmap
- Spring Boot migration
- JPA implementation
- Maven integration

> Developed as a learning project demonstrating JDBC and OOP principles

## Key Packages
```text
com.javid.busReservation/
├── model/       # POJOs (Bus, Booking)
├── dao/         # Database operations
├── service/     # Business logic
└── Main.java    # CLI Interface

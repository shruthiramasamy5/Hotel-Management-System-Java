# Hotel Booking System

A console-based Java application for managing hotel room bookings, built using object-oriented principles like inheritance and polymorphism to model different room types (Standard, Deluxe, Suite) with varying pricing and amenities.

## Features
- Check availability of all rooms
- Book a room (Deluxe rooms support breakfast add-on and coupon-based discounts)
- Cancel an existing booking
- Generate an itemized invoice with 10% tax
- View a daily report of bookings and revenue

## Room Types

| Type     | Base Amenities | Extra Charges |
|----------|----------------|----------------|
| **Standard** | None | Base price only |
| **Deluxe**   | WiFi, Balcony, Breakfast (optional) | +₹100 WiFi, +₹150 Balcony, +₹250 Breakfast, custom extra charge |
| **Suite**    | Jacuzzi, Living Area | +₹800 Jacuzzi, +₹500 Living Area, custom luxury charge |

## Project Structure
HotelAppMain.java     → Console menu & application entry point
Room.java              → Base class: booking, cancellation, billing, availability
DeluxeRoom.java        → Deluxe room type (extends Room) — WiFi, balcony, breakfast, coupon discount
SuiteRoom.java         → Suite room type (extends Room) — jacuzzi, living area
BookingService.java    → Manages room collection, invoicing, and daily reporting

## Tech Stack
- Java (Core OOP — inheritance, polymorphism, method overriding)

## How to Run
1. Clone the repository
git clone <repo-url>
2. Compile the source files
javac hotelapp/*.java
3. Run the application
java hotelapp.HotelAppMain

## Menu Options

Check Availability   → Lists all currently unbooked rooms
Book Room             → Books a room by room number (Deluxe auto-applies breakfast + SAVE100 coupon)
Cancel Booking        → Cancels booking for a given room number
Generate Invoice      → Shows base + extras, 10% tax, and total for a booked room
Daily Report          → Shows count of booked rooms and total revenue (pre-tax)
Exit


## Sample Rooms Preloaded
| Room No | Type | Base Price |
|---------|------|------------|
| 101 | Standard | ₹1500 |
| 102 | Deluxe (WiFi, Balcony) | ₹2500 |
| 201 | Suite (Jacuzzi, Living Area) | ₹5000 |
| 103 | Deluxe (Balcony, Breakfast) | ₹2800 |

# 2025-26: Coding exercises 

This repository contains **two exercises** demonstrating the implementation of **Behavioral, Creational, and Structural Design Patterns** in Java, along with a **console-based Astronaut Daily Schedule Organizer** project.  

The goal of this project is to:  
- Apply **design patterns** in realistic use cases.  
- Show **creativity** and **clarity** in implementation.  
- Provide a structured solution with **easy-to-follow explanations**.  

---

##  Exercise 1 – Design Pattern Demonstrations  

I implemented **2 use cases for each category** of design patterns.  

### 🔹 Behavioral Patterns  
1. **Memento Pattern – Grid Game with Undo**  
   - Player moves in a grid using keyboard keys.  
   - Pressing `z` undoes the last move (restores previous state).  
   - Demonstrates saving and restoring state.  

2. **Observer Pattern – E-commerce Price Drop Notification**  
   - Multiple users set desired price thresholds.  
   - When a product price drops, only users within their threshold are notified.  
   - Demonstrates **event-driven notification system**.  

---

### 🔹 Creational Patterns  
1. **Factory Pattern – Ride Booking Platform**  
   - Users can book **Auto**, **Car**, or **Bike**.  
   - Factory creates the appropriate ride object based on input.  

2. **Prototype Pattern – T-Shirt Customization**  
   - A base T-shirt prototype can be cloned.  
   - Users modify **color, size, and price**.  
   - Demonstrates **object cloning and reusability**.  

---

### 🔹 Structural Patterns  
1. **Adapter Pattern – Game Input Compatibility**  
   - Game accepts only controller input.  
   - Adapter maps **keyboard keys (WASD)** to **controller inputs**.  
   - Demonstrates making **incompatible systems work together**.  

2. **Decorator Pattern – Iron Man Suit Upgrades**  
   - Start with a **basic Iron Man suit**.  
   - Add new features like **Flight Jet** or **NanoTech Armor** dynamically.  
   - Demonstrates **extending functionalities without modifying base class**.  

---

##  Exercise 2 – Astronaut Daily Schedule Organizer  

A **console-based application** that manages astronaut schedules.  
Implemented using **Singleton, Factory, and Observer Patterns**.  

###  Basic Features  
- Add a new task (description, start time, end time, priority).  
- Remove an existing task.  
- View all tasks sorted by start time.  
- Validate tasks to prevent overlaps.  
- Show error messages for invalid operations.  

###  Key Features   
- Edit an existing task.  
- Mark tasks as completed.  
- View tasks by specific priority level.  

###  Applied Design Patterns  
1. **Singleton Pattern**  
   - `ScheduleManager` ensures only **one instance** manages all tasks.  

2. **Factory Pattern**  
   - `TaskFactory` creates tasks with proper attributes.  

3. **Observer Pattern**  
   - Alerts users if **task conflicts** occur.  
   - Notifies when tasks are **updated**.  

---

##  Tech Stack  
- **Language**: Java  
- **Concepts**: OOP, Design Patterns, Console-based Applications  

---



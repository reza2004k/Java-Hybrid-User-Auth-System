# 🔒 Java Hybrid User Authentication & Management System

This project is a multi-interface application built in Java, designed to manage user access and basic operations. It combines a modern **JavaFX Graphical User Interface (GUI)** for login with a traditional **Command Line Interface (CLI)** for the main application functionalities.

## ✨ Features

* **Dual Interface:** The application seamlessly transitions from a graphical login screen to a console-based management system.
* **JavaFX Login:** A dedicated GUI window handles user authentication (username and password) for a user-friendly entry point.
* **Console Management:** The core application features, accessible after successful login, operate within the terminal/console environment.
* **File-Based Persistence (Flat-File DB):** User credentials and other application data are stored in a simple, local file. This file acts as a lightweight data store, similar to a server or database in a small-scale system.
* **Security Focus:** Implements basic user authentication to control access to the management features.

## 🛠️ Technologies Used

* **Language:** Java
* **GUI Framework:** JavaFX (for the graphical Login component)
* **Data Persistence:** Java File I/O (for reading and writing data to the file)
* **Interface:** Command Line Interface (CLI) for the main application

## 🚀 Getting Started

To compile and run this Java application, you need to ensure your development environment is correctly set up to handle JavaFX.

### Prerequisites

* Java Development Kit (JDK) 11 or later (recommended for JavaFX module support).
* JavaFX SDK (or JavaFX modules configured via your build tool like Maven or Gradle).

### Installation and Running

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/YOUR_USERNAME/Java-Hybrid-User-Auth-System.git](https://github.com/YOUR_USERNAME/Java-Hybrid-User-Auth-System.git)
    cd Java-Hybrid-User-Auth-System
    ```
2.  **Compilation and Execution:**
    Because JavaFX requires specific module paths, running the application is typically done using an IDE (IntelliJ IDEA, Eclipse) or a command that includes the module path.

    * **If running via Command Line (CLI):**
        You must specify the path to your JavaFX SDK. (The exact command may vary):
        ```bash
        # Example Compilation:
        javac --module-path <path-to-javafx-sdk>/lib --add-modules javafx.controls,javafx.fxml *.java
        
        # Example Run (assuming your main class is Main.java):
        java --module-path <path-to-javafx-sdk>/lib --add-modules javafx.controls,javafx.fxml Main
        ```

### Usage Flow

1.  Upon launching, the **JavaFX Login Window** will appear, prompting for credentials.
2.  Enter the required Username and Password (which are validated against the stored data file).
3.  Upon successful authentication, the GUI window closes.
4.  The main application will launch in the **Console/Terminal**, providing a menu for user management and operations.

---

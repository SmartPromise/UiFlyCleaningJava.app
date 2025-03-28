**UiFLY Cleaning Company**
The UiFLY Cleaning Company project is a modular Java application designed to manage cleaners and their job assignments. It provides both a text-based interface and a modern graphical user interface (GUI) built with JavaFX. The project is organized into several modules and packages, including models, services, and menus, to facilitate adding, assigning, viewing, and removing cleaners.

Project Structure

```markdown
UiFLY-Cleaning-Company/
├── src/
│   ├── cleaning/
│   │   ├── menu/
│   │   │   ├── CleaningCompanyMenu.java    // Text-based interface for the cleaning company
│   │   │   └── CleaningCompanyUI.java      // JavaFX GUI interface for the cleaning company
│   │   ├── model/
│   │   │   ├── Cleaner.java                // Model class for a cleaner
│   │   │   └── JobToCleaner.java           // Model class for a job assignment
│   │   └── service/
│   │       └── CleaningService.java        // Service class containing business logic and file persistence
│   ├── module-info.java                      // Module declaration for the cleaning module
│   ├── hello-view.fxml                       // FXML file for additional JavaFX view structure (if used)
│   └── resources/
│       └── dst.jpeg                        // Image resource used as a background in the GUI
└── README.md                                 // Project documentation (this file)

```
Prerequisites
Java Development Kit (JDK): Version 11 or higher is recommended.

JavaFX: Ensure that JavaFX libraries are available (the module-info.java declares the required JavaFX modules). If not bundled with your JDK, download them from openjfx.io.

IDE or Build Tool: An IDE like IntelliJ IDEA or Eclipse, or a build tool such as Maven or Gradle, can be used to compile and run the project.

Module Configuration
The module-info.java file declares the cleaning module and its dependencies:


```java
module cleaning {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;

    opens cleaning.menu to javafx.fxml;
    exports cleaning.menu;
    exports cleaning.model;
    exports cleaning.service;
}
```
This ensures that JavaFX and BootstrapFX libraries are properly included and that the required packages are exported for use.

How to Run the Application
Using the Text-Based Interface
Compile the Application:

Open your terminal or command prompt, navigate to the src directory, and compile all Java files:


```java
javac --module-path /path/to/javafx-sdk-<version>/lib --add-modules javafx.controls,javafx.fxml *.java cleaning/**/*.java
Adjust the module path to your JavaFX SDK location.
Adjust the module path to your JavaFX SDK location.
```
Run the Text-Based Interface:

Run the CleaningCompanyMenu class:


```java
java --module-path /path/to/javafx-sdk-<version>/lib --add-modules javafx.controls,javafx.fxml cleaning.menu.CleaningCompanyMenu
This interface uses the console to prompt for inputs such as adding a new cleaner, assigning jobs, viewing assignments, and removing cleaners.
```

Using the Graphical User Interface (GUI)
Compile the Application:

Similar to the text-based version, compile with the proper JavaFX module path:


```java
javac --module-path /path/to/javafx-sdk-<version>/lib --add-modules javafx.controls,javafx.fxml *.java cleaning/**/*.java
Run the GUI Interface:
Run the GUI Interface:

Run the CleaningCompanyUI class:

Run the CleaningCompanyUI class:


```java
java --module-path /path/to/javafx-sdk-<version>/lib --add-modules javafx.controls,javafx.fxml cleaning.menu.CleaningCompanyUI
The GUI application launches a window titled "UiFLY Cleaning Company" with a background image, buttons for various operations (adding cleaners, assigning jobs, etc.), and uses dialog boxes to interact with the user.
```

Tip: If you're using an IDE, configure your project settings to include the JavaFX libraries and set the module path accordingly. Many IDEs have built-in support for JavaFX applications.

Features
Add New Cleaner:
Enter details such as name, address, contact information, and a unique ID to register a new cleaner.

Assign Job to Cleaner:
Input job details (job ID, description) and assign the job to an existing cleaner.

View Assigned Jobs:
Retrieve a list of all job assignments made to cleaners.

View Available Cleaners:
Display a list of currently available cleaners.

Remove Cleaner:
Remove a cleaner from the system by specifying their unique ID.

Persistence:
The CleaningService writes job assignments to a file (allCleanersInfo.txt) to maintain a log of all assignments.

Dual Interfaces:
Choose between a text-based interface for simplicity or a JavaFX GUI for a richer user experience.

Usage Guidelines
Running the Text-Based Menu:
Follow the on-screen prompts to input choices and data. Options range from adding cleaners to exiting the application.

Navigating the GUI:

Buttons: Use the clearly labeled buttons to perform actions.

Dialog Boxes: Input data through text dialogs prompted by each action.

Exit: Click the "Exit" button to close the GUI application.

File Resources:

hello-view.fxml: (If integrated) can be used to further customize the UI layout.

dst.jpeg: Serves as the background image for the GUI. Ensure that this file is placed in the correct resource directory so that it loads properly at runtime.

Future Enhancements
Improved Persistence:
Integrate a database or enhanced file storage mechanism.

Extended Functionality:
Add more features such as scheduling, cleaner ratings, or detailed job tracking.

User Interface Enhancements:
Further refine the GUI layout and styling.

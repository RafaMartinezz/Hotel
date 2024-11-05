# Hotel Management System - JavaFX Application

This JavaFX application serves as a front-end for managing hotel reservations. The application includes interfaces for room and event reservations, as well as a central main menu. Users can navigate through the application using various buttons and menu options to access reservation screens.

## Project Overview

The Hotel Management System is designed with a clean and interactive interface using JavaFX. It provides simple navigation and functional forms that allow users to manage room and event reservations easily. Key features include date selectors for reservations, user feedback on form selection, and interactive UI elements with hover effects.

### Key Components

1. **Controller Classes**: 
   - Controllers manage the UI actions for each view, connecting user input to backend functionality.
   - Examples include:
     - `FormularioPrincipalController`: Controls the main form, handling navigation to different reservation forms.
     - `ReservaHabitacionController`: Manages room reservation actions and validates user input.
     - `ReservaSalonController`: Handles event reservation, configuring UI elements based on event type.

2. **FXML Views**: 
   - The UI is divided into various FXML files for modularity.
   - Views include:
     - **Main Menu**: Access points for room and event reservation.
     - **Room Reservation**: Form to select room type, arrival, and departure dates.
     - **Event Reservation**: Configures event type, attendance, and options for associated services.

3. **CSS Styling**:
   - Custom styles are applied to enhance UI aesthetics and usability.
   - Rounded corners, shadows, and hover effects are added for an intuitive, modern user experience.
   - Each button has a subtle shadow effect that becomes more pronounced when hovered over, creating visual feedback.

4. **JavaFX Application Class (`hotel`)**:
   - This class serves as the entry point for launching the JavaFX application. It loads the main form (`FormularioPrincipal.fxml`) and sets the application title.

## Folder Structure

- `hotel.controller`: Contains the controller classes for each FXML view.
- `hotel.view`: Contains the main view files in FXML.
- `style`: Contains the custom stylesheet for the application.
- `model`: (Optional) Could be used to include model classes representing reservation data structures.

## Getting Started

### Prerequisites

- **Java**: Ensure Java 11 or higher is installed.
- **JavaFX SDK**: JavaFX SDK is required to compile and run the application.
- **IDE**: Use an IDE like IntelliJ IDEA, Eclipse, or NetBeans with JavaFX support.

### Running the Application

1. Clone this repository to your local machine.
2. Import the project into your IDE.
3. Ensure that JavaFX is properly configured in your IDE. Set the path to the JavaFX SDK libraries if required.
4. Run the `hotel` class to launch the application.

## Usage

- **Main Menu**: Allows navigation to Room and Event reservation forms.
- **Room Reservation Form**:
  - Select room type, arrival, and departure dates.
  - Option to select additional preferences.
- **Event Reservation Form**:
  - Choose event type (e.g., wedding or corporate).
  - Specify additional details like catering options, attendance, and room booking preferences.

## Technologies Used

- **JavaFX**: For UI development and form controls.
- **FXML**: XML-based UI design for clear separation of presentation and logic.
- **CSS**: Custom styling to enhance UI appearance.

## Future Improvements

- **Database Integration**: Connect to a database to store reservation details persistently.
- **User Authentication**: Add user login and role-based access for enhanced security.
- **Improved UI Feedback**: Display confirmation messages or errors based on form submission.
- **Responsive Design**: Optimize layout for different screen sizes.
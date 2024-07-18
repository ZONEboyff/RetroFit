# RetroFit

Welcome to RetroFit! Our fitness app is designed to help you plan exercise routines and track your progress with ease.

## Table of Contents
1. [Introduction](#introduction)
2. [Features](#features)
3. [Installation](#installation)
4. [Usage](#usage)
5. [Contributing](#contributing)
6. [License](#license)

## Introduction
RetroFit is a fitness tracker app that allows users to plan their exercise routines and gain insights into their progress. Our goal is to provide a user-friendly platform that helps you stay motivated and reach your fitness goals.

## Features
- **Exercise Planning**: Create and customize workout plans tailored to your fitness level and goals.
- **Progress Tracking**: Monitor your progress with detailed insights and analytics.
- **Wildlife Images**: Stay motivated with inspiring wildlife images sourced from APIs.
- **User-Friendly Interface**: Enjoy a seamless experience with our intuitive design using Android Studio with Jetpack Compose.
- **Backend Support**: Powered by Python with Django and MySQL for efficient data management.

## Installation
To get started with RetroFit, follow these steps:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/RetroFit.git
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd RetroFit
   ```

3. **Set Up the Backend**:
   - Install the required Python packages:
     ```bash
     pip install -r requirements.txt
     ```
   - Set up the MySQL database:
     ```sql
     CREATE DATABASE retrofit;
     ```
   - Apply Django migrations:
     ```bash
     python manage.py migrate
     ```

4. **Set Up the Frontend**:
   - Open the project in Android Studio.
   - Build and run the app on an emulator or connected device.

## Usage
Once installed, you can start using RetroFit to plan your workouts and track your progress. 

- **Create a Workout Plan**: Go to the "Plans" section and click "Add Plan". Fill in the details and save.
- **Log Your Exercise**: Navigate to the "Log" section, select the exercise, and enter your workout details.
- **View Progress**: Check the "Progress" section for detailed analytics and insights.

## Contributing
We welcome contributions from the community! If you would like to contribute to RetroFit, please follow these steps:

1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature/YourFeature
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add YourFeature"
   ```
4. Push to the branch:
   ```bash
   git push origin feature/YourFeature
   ```
5. Open a pull request.

## License
RetroFit is licensed under the GNU General Public License. See the LICENSE file for more details.

---

Thank you for using RetroFit! We hope our app helps you achieve your fitness goals. If you have any questions or feedback, feel free to reach out to us.

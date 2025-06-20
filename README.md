🚌 Routes – Nairobi Matatu Route Finder

Routes is a Java-based mobile application inspired by the Digital Matatus Project, a groundbreaking initiative by students and professors—primarily from the University of Nairobi (UoN)—to map and digitize Nairobi’s matatu (public minibus) transit routes.

This app makes urban navigation more accessible by helping users determine the best matatu routes to take from a given starting point to their destination.

🚀 Features

🔎 Route Finder: Input your start and end points and get the optimal matatu route.

🗺️ Mapped Directions: Visual representation of the route on a map.

🚌 Matatu SACCO Details: Displays the SACCO name and route number to use.

🌐 Offline-Ready (Optional): Leverages local GTFS data for faster access and offline functionality.

📲 Screenshots

Coming soon — UI mockups and app screenshots

🧠 Background

This project builds on the Digital Matatus open-data initiative, which used GTFS (General Transit Feed Specification) to document informal transit systems in Nairobi. The goal of Routes is to make this data usable and accessible for everyday commuters, especially those unfamiliar with the city’s informal transit patterns.

🛠️ Tech Stack

Language: Java

Platform: Android

Mapping: Google Maps API / OpenStreetMap (TBD)

Transit Data Format: GTFS (General Transit Feed Specification)

Database: SQLite (local route storage) / Firebase (optional for sync)

📦 Installation

Prerequisites:

Android Studio (latest version)

Android device or emulator

API key for Google Maps (if using Google Maps)

Steps:

git clone https://github.com/your-username/routes.git
cd routes

Open the project in Android Studio.

Add your API keys and configure any required environment variables.

Run the app on your preferred device/emulator.

🗂️ Project Structure

routes/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/       # Main Java code
│   │   │   ├── res/        # UI layouts and drawables
│   │   │   └── assets/     # GTFS route data
├── README.md
└── build.gradle

🧪 Future Improvements

Real-time location tracking and route suggestions

Fare estimates for the selected routes

Crowdsourced updates from users

Multilingual support for Swahili and English

Offline navigation support

🙌 Contributors

Elizabeth Kenaiyan – Project Lead & Developer

Inspired by: Digital Matatus Project (UoN & international collaborators)

📄 License

This project is licensed under the MIT License – see the LICENSE file for details.

📬 Contact

Got feedback or want to contribute? Reach out at seinkenaiyan@gmail.com

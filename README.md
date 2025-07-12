## BrickBreaker Game

# Java Game Programming for Desktop

I developed a brick-breaker game using Java. I use a JFrame and a JPanel to draw different graphics, making this game work perfectly.
A classic arcade-style Brick Breaker game developed in Java as a 2nd-year university project. This game offers smooth gameplay and responsive controls, 
challenging players to break all bricks using a bouncing ball and a paddle.

✨ Features
🎮 Classic Gameplay
Enjoy the timeless fun of breaking bricks to clear each level.

⌨️ Keyboard Controls
Move the paddle intuitively using the arrow keys for precise control.

📈 Score Tracking
Monitor your progress in real time with a live score display.

💥 Game Over & Victory Logic
Lose lives if you miss the ball, or win by clearing all bricks.

⚙️ Multiple Difficulty Levels
Select from Easy, Medium, or Hard modes, each with unique brick layouts and increasing challenges.

🔐 User Authentication
Secure login and registration system to manage and protect player accounts.

🏆 Leaderboard
Compete globally and track high scores across all players.

🆘 Help Section
Access in-game instructions and tips to get started quickly.

# Sign Up and Login page:
![WhatsApp Image 2025-07-13 at 00 42 59 (2)](https://github.com/user-attachments/assets/ea80a4fc-6f33-4d9c-923f-e818f67ea3eb)
# Menu bar:
![WhatsApp Image 2025-07-13 at 00 42 59](https://github.com/user-attachments/assets/1acda882-b512-4022-9a24-829d1f688b8e)
# Starting page
![WhatsApp Image 2025-07-13 at 00 42 59 (1)](https://github.com/user-attachments/assets/2caec684-8ef2-4a33-bdba-64ebbb3de353)
# Difficulty at easy:
![WhatsApp Image 2025-07-13 at 00 42 58 (1)](https://github.com/user-attachments/assets/30ac8055-8fa3-498e-9f7e-c18feddc44b1)
# Difficulty at hard:
![WhatsApp Image 2025-07-13 at 00 42 58 (2)](https://github.com/user-attachments/assets/2029702a-a36b-401d-b299-7ccfbbbb730e)
# Leaderboard:
![WhatsApp Image 2025-07-13 at 00 42 58](https://github.com/user-attachments/assets/b7e6699c-3d6d-400f-a32d-ac1e3781d2a1)


## Directory Structure:

mahirazmain-brick-breaker-game/
├── README.md
├── build.xml
├── LoginPage.iml
├── manifest.mf
├── lib/
│   └── nblibraries.properties
├── nbproject/
│   ├── build-impl.xml
│   ├── genfiles.properties
│   ├── project.properties
│   ├── project.xml
│   └── private/
│       ├── config.properties
│       ├── private.properties
│       └── private.xml
└── src/
    ├── brickbreaker/              # Core game logic and levels
    │   ├── BrickBreaker.java
    │   ├── GamePlay.java
    │   ├── GamePlayEasy.java
    │   ├── GamePlayMedium.java
    │   ├── GamePlayHard.java
    │   ├── MapGenerator.java
    │   ├── MapGeneratorEasy.java
    │   ├── MapGeneratorMedium.java
    │   └── MapGeneratorHard.java
    ├── Login/                     # Login and registration UI
    │   ├── Login.form
    │   ├── Login.java
    │   ├── LoginAndRegister.form
    │   ├── LoginAndRegister.java
    │   ├── PanelCustom.java
    │   ├── Register.form
    │   └── Register.java
    ├── Main/                      # App entry point, menus, leaderboard, help, DB
    │   ├── DBConnection.java
    │   ├── DifficultyMenu.form
    │   ├── DifficultyMenu.java
    │   ├── helpPage.form
    │   ├── helpPage.java
    │   ├── JsonParserApp.java
    │   ├── JTableUtilities.java
    │   ├── LeaderBoard.form
    │   ├── LeaderBoard.java
    │   ├── Main.form
    │   ├── Main.java
    │   ├── MainMenu.form
    │   └── MainMenu.java
    └── Swing/                     # Custom UI components
        ├── Button.java
        ├── EventLogin.java
        ├── Password.java
        └── TextField.java

## 🚀Tech Stack & Tools

🖥 Language
Java

🧰 IDE
NetBeans (recommended) or IntelliJ IDEA

🎨 UI Library
Java AWT/Swing for building a responsive interface with robust graphics and event handling

🗄 Database
Integrated database for storing user accounts and leaderboard scores
[See DBConnection.java for connection details]

📦 JSON Processing
Google Gson library for efficient JSON parsing and handling

⚙️ Build Tool
Apache Ant for project compilation, build automation, and dependency management

🧑‍💻 Design Principles
Follows clean Object-Oriented Programming (OOP) principles to ensure modular, maintainable, and scalable code

## 🛠️ Getting Started
To get a copy of the project up and running on your local machine for development and testing purposes, follow these steps.

# Prerequisites
Java Development Kit (JDK) 8 or higher

NetBeans IDE (recommended) or any other Java IDE (e.g., IntelliJ IDEA)

# Installation
🚀 Getting Started
Follow the steps below to set up and run the project locally.

1. Clone the Repository
bash
Copy
Edit
git clone https://github.com/MahirAzmain/Brick-Breaker-Game.git
2. Navigate to the Project Directory
bash
Copy
Edit
cd Brick-Breaker-Game
3. Open the Project in NetBeans
Launch NetBeans.

Go to File > Open Project.

Browse to the cloned Brick-Breaker-Game directory.

Select the project folder and click Open Project.

Clean and build the project using Run > Clean and Build Project.

Run the project using Run > Run Project or press F6.

Go to File > Open Project.

Navigate to the cloned BrickBreaker folder and select it.

# Build and Run
In NetBeans, right-click the project in the Projects window.

Select Build to compile the project.

Right-click the project again and select Run to launch the game.

## 🤝 Contributing
Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are greatly appreciated.

Fork the Project

Create your Feature Branch (git checkout -b feature/AmazingFeature)

Commit your Changes (git commit -m 'Add some AmazingFeature')

Push to the Branch (git push origin feature/AmazingFeature)

Open a Pull Request

## 📞 Contact
Mahir Azmain Haque  - mahirazmain7@gmail.com

## **Project Proposal:**
[2007118 Desktop.docx](https://github.com/user-attachments/files/19014022/2007118.Desktop.docx)

## Infographics:
https://g.co/gemini/share/5064f8d5c5a5

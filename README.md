# 🏏 Hand Cricket Game

A simple **Hand Cricket Game** developed in **Java Swing** as a university project. The player competes against the computer through a toss, two innings, batting, bowling, score tracking, OUT detection, and a final result screen.

## 🎮 Features

* Player name input
* Head/Tail toss system
* Batting system
* Bowling system
* Player vs Computer gameplay
* Two innings
* Run selection from 1–6
* OUT detection
* Score tracking
* Wicket tracking
* Ball tracking
* Target calculation
* Computer batting
* Automatic innings transition
* Winner/Tie detection
* Result screen
* Play Again functionality
* Back and Exit navigation
* GUI-based gameplay

## 🛠️ Technologies

* **Java**
* **Java Swing**
* **Java AWT**
* **Random**
* **Object-Oriented Programming (OOP)**

## 💻 Requirements

* **JDK 17 or newer**
* NetBeans, IntelliJ IDEA, Eclipse, or any Java IDE

## 🚀 How to Run

1. Clone the repository:

```bash
git clone https://github.com/saikat917/Hand-Cricket-game.git
```

2. Open the project in a Java IDE.
3. Locate `Main.java`.
4. Run the `main()` method.
5. The Hand Cricket game window will open.

## 🎮 How to Play

### 1. Enter Player Name

Enter your name in the Main Menu and click **Start Game**.

### 2. Toss

Choose:

* **Head**
* **Tail**

If you win the toss, you can choose:

* **Bat**
* **Bowl**

If you lose the toss, the computer makes the decision.

### 3. First Innings

When batting, select a number from **1 to 6**.

The computer generates its number randomly.

* Different numbers → Your selected run is added to your score.
* Same numbers → You are **OUT** and the first innings ends.

### 4. Second Innings

The computer bats and you bowl.

Select a number from **1 to 6**.

The computer generates its batting number.

* Different numbers → Computer scores runs.
* Same numbers → Computer is **OUT**.

The second innings also ends if the computer reaches the target.

### 5. Result

After the match, the Result Screen displays:

* Player score
* Computer score
* Wickets
* Match result

You can select **Play Again** to start a new match.

## 📁 Project Structure

```text
src/
├── Main.java
│
├── model/
│   ├── player.java
│   └── ScoreBoard.java
│
├── game/
│   ├── BattingManager.java
│   ├── BowlingManager.java
│   └── GameManager.java
│
└── ui/
    ├── MainMenuFrame.java
    ├── TossFrame.java
    ├── GameFrame.java
    ├── ScoreBoardPanel.java
    └── ResultFrame.java
```

## 🧩 Main Classes

* **Main.java** — Starts the application and opens the main menu.
* **MainMenuFrame.java** — Provides the main menu, player name input, Start Game, and Exit options.
* **TossFrame.java** — Handles the Head/Tail toss and Bat/Bowl selection.
* **GameFrame.java** — Provides the main gameplay GUI and connects the game logic with the interface.
* **ScoreBoardPanel.java** — Displays runs, wickets, balls, and game results.
* **ResultFrame.java** — Displays the final scores and match result and provides the Play Again option.
* **GameManager.java** — Controls the overall match flow, innings, target, scores, and winner determination.
* **BattingManager.java** — Handles the player's batting innings.
* **BowlingManager.java** — Handles the computer's batting/bowling innings.
* **player.java** — Stores player information.
* **ScoreBoard.java** — Stores and manages scoreboard information.

## 🏏 Game Logic

The basic Hand Cricket logic is:

```text
Player chooses a number
        ↓
Computer generates a number
        ↓
      Same?
     /     \
   YES      NO
    ↓        ↓
   OUT    Add Runs
```

For example:

```text
Player = 4
Computer = 2
```

The numbers are different, so the player scores **4 runs**.

If:

```text
Player = 4
Computer = 4
```

The player is **OUT**.

## 🔄 Match Flow

```text
Main Menu
    ↓
Player Name
    ↓
Toss
    ↓
Bat / Bowl
    ↓
First Innings
    ↓
OUT
    ↓
Second Innings
    ↓
Target / OUT
    ↓
Result Screen
    ↓
Play Again
    ↓
Main Menu
```

## 📊 Scoreboard

The scoreboard keeps track of:

* Runs
* Wickets
* Balls
* Target
* Current innings

The first innings score is used to calculate the second innings target:

```java
target = playerScore + 1;
```

## 📅 Weekly Development

### Week 1 — Planning & Research

Planned the Hand Cricket game concept, required features, classes, and development timeline.

### Week 2 & 3 — Project Setup & Basic Structure

Created the Java project and established the basic project structure, classes, game flow, and initial GUI components.

### Week 4 — GUI Development

Created the main menu and basic GUI navigation using Java Swing.

### Week 5 — Toss & Game Interface

Implemented the toss system, Head/Tail selection, and Bat/Bowl options.

### Week 6 — Gameplay & Score System

Implemented batting, computer-generated numbers, OUT detection, runs, wickets, balls, and scoreboard integration.

### Week 7 — Game Management

Implemented `GameManager` to control the first innings, second innings, target calculation, score management, and winner determination.

### Week 8 — Result & Additional Features

Implemented the Result Screen, player name input, result display, Play Again functionality, and GUI navigation between innings and result screens.

### Week 9 — Testing & Quality Assurance

Performed functional testing, GUI testing, boundary testing, bug fixing, and final gameplay testing.

### Week 10 — Documentation & Final Submission

Prepared the README, test reports, bug report, screenshots, source code organization, GitHub repository, and final project package.

## 🧪 Testing

The game was tested for:

* Start Game functionality
* Player name validation
* Toss functionality
* Bat/Bowl selection
* Run selection from 1–6
* OUT detection
* First innings completion
* Second innings transition
* Target calculation
* Computer batting
* Match result
* Play Again functionality
* GUI navigation
* Exit functionality

## 🐛 Bug Fixing

During development, issues related to GUI navigation, constructor connections, innings transitions, and game screen integration were tested and corrected.

The final version was tested through complete match simulations from the Main Menu to the Result Screen.

## 🔮 Future Improvements

* Two-player mode
* Better GUI design
* Sound effects and background music
* Player and computer animations
* Difficulty levels
* Match history
* High-score system
* More detailed statistics
* Improved visual effects

> **Note:** Two-player mode is considered an optional future feature.

## 👨‍💻 Project Information

**Project:** Hand Cricket Game
**Language:** Java
**GUI:** Java Swing / AWT
**Type:** University Project
**Mode:** Player vs Computer
**Status:** Completed

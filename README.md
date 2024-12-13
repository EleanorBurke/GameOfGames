# GameOfGames

## Overview

**The Game of Games** is a multi-game Java application created as the final project for CPSC 340. This assignment is designed to evaluate the completeness and clarity of the design-to-implementation process, giving students experience into industry coding. The application client used by the Sewing Sisters to facilitate decision-making through interactive games.

## Features

1. **Games**:
   - Coin Flip
        - A game where the player chooses heads or tails, and the system flips a coin. If the player's choice matches the result, they win. The game tracks scores across rounds and provides feedback for invalid inputs.
   - Guess the Number
        - The system generates a random number within a specified range. The player guesses the number, receiving hints (too high/low) for incorrect guesses. The game ends when the correct number is guessed.
   - Even-Odd
        - This is a two-player game where roles (even or odd) are assigned at the start. Each player inputs a number, and the system sums the two numbers. If the sum is even, the "Even" player wins the round; if the sum is odd, the "Odd" player wins. 
   - Find the Thimble
        - A guessing game where a thimble is hidden under one of several cups. The player guesses the cup hiding the thimble, and the game checks if the guess is correct. Players can replay the game or return to the main menu.
   - Find the Red Thread
        - The player searches for a hidden red thread among several spools. If the player finds the thread, they win; otherwise, turns alternate until it is found. The game tracks scores across rounds.

2. **Modes**:
   - Player Mode: Standard gameplay experience.
   - Test Mode: Displays internal information for debugging.

3. **Documentation**:
    - UML Diagrams
    - Method Glossary
    - Data Configuration Tables
    - Responsibilities Document

4. **Source Code**
    - `PlayGames.java`: Driver class managing the main menu and overall game flow.
    - Individual game classes (`CoinFlip.java`, `GuessTheNumber.java`, etc.).
    - `GetInput.java`: Handles user input validation and error handling.

## Deployment 
**WRITE LATER**

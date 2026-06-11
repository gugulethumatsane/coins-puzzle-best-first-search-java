# Coins-puzzle-best-first-search-java
# 🧠 Coins Puzzle – Best First Search 

## 📌 Overview
This project solves a 7-cell coin movement puzzle using the Best First Search algorithm. The objective is to move blue and red coins into their goal positions using valid moves (adjacent moves and jumps).

## 🎯 Problem Description
- 7 cells in a line
- 3 Blue coins (B) must reach positions 1–3
- 3 Red coins (R) must reach positions 5–7
- One empty cell (0)
- Coins can move to adjacent empty cells or jump over one coin

## 🧠 Algorithm Used
- Best First Search (Greedy Search)
- Priority Queue (Java Collections Framework)
- Heuristic: number of misplaced coins

## 📊 Heuristic Function
h(n) = number of coins not in correct positions

Example:
- State A → h = 3
- State B → h = 6

## ⚙️ Technologies Used
- Java
- Object-Oriented Programming (OOP)
- PriorityQueue (Min Heap)
- File I/O

## 📥 Input Format
Input is read from a text file representing the initial state.

Example: BRBR0RB

## 📤 Output
The program outputs:
- Expanded nodes
- Heuristic values
- Path to goal state
- Number of moves

Output is displayed on screen and saved to file.

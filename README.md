# Tower Of Honoi Java Implemetation

Only one disk can be moved at a time. A valid move consists of taking the top disk from one stack and placing it onto another stack (or an empty rod). No disk can be placed on top of a smaller disk. Moving on to a variant of this game, consider a long room k units (square tiles) wide, labeled from 1 to k in ascending order. Three rods are placed at squares a, b, and c, and a stack of n disks is placed on the rod at square a.

Let E(n,k,a,b,c) be the expected number of squares that Bob travels during a single optimally-played game. A game is played optimally if the number of disk-pickups is minimized. Interestingly enough, the result is always an integer. For example, E(2,5,1,3,5) = 60 and E(3,20,4,9,17) = 2358.

Interestingly enough, the result is always an integer. For example, E(2,5,1,3,5) = 60 and E(3,20,4,9,17) = 2358. Find the last nine digits of ∑1≤n≤10000 E(n,10n,3n,6n,9n).

Find the last nine digits of ∑1≤n≤10000 E(n,10n,3n,6n,9n).

## Installation

1. There is one junit depedency for test-case, You need to have Java 8, Maven and Eclipes IDE installed on your machine, program written in java maven project. 

## Usage

This repository contains two files, TOHMain.java and TowerOfHanoi.java. TOFMain is entry point of the program from where the program execution starts. The main logic is written in TowerOfHanoi class.

TOHMain.java is the mian file , which outputs the last nine digits of ∑1≤n≤10000.

## To run the program

Import project in any IDE like eclipse or Intellij and click on project to run as maven clean and install. then you can run main TOHMain.java and test case.





# Roll Store Simulator
### **By Willie Chew and Sricharan Reddy Varra**

# Running the program
The program is intended to be complied and ran in IntelleJ. Open the "Project 3" directory with IntelleJ
and build the Main.java. IntelleJ should then allow you to run the main. 
Program was developed in Java.

# Testing
There are test cases to test the functionality of various aspects of the program. In IntelliJ, press
Control+Shift+F10 to run all the test cases to ensure that all cases pass before running the main.

# Outputting
A simulation.out file should be made at the end of the program's run. The file should contain the
inventory data, sales data, and profits of each day along with the totals of the time interval at
the end. 
The program will output to the system data about the various rolls that each customer ordered.

# Goal of program
This program simulates the interaction between a store and custormers. The simulated store sells various
types of rolls with the options of extra sauce, filling, or toppings for each type of roll. There are three
types of customers in the simulation: casual, business, and catering. Each type of customer has different logic
that dictates how they construct their orders. 

# Comments and Assumptions
Assumptions made were that extra sauces, toppings, and fillings each had a constant price. Another assumption 
made was that the store will operate until it is out of rolls to sell.

# OO Patterns Used
The <strong>abstract</strong> factory pattern was used in the design of the various roll and customer factories.
The <strong>command</strong> pattern was used by the store controller object to excapsulate store operation fuctions.
The <strong>observer</strong> pattern was used in the StoreObserver object.
The <strong>strategy</strong> pattern was used in the design of the outage logic of the customers.  

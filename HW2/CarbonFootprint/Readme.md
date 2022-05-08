# Program Structure：
* Main function:
	- TestCarbonFoorprint.java
* Interface:
	- CarbonFootprint.java
* Three object classes:
	- Bicycle.java
	- Building.java
	- Car.java
* Output process: 
	- OutputProcess.java
	- TestOutput.java
	
# Compile：
* I attach a Makefile with this homework
* You can compile and execute all programs with typing "make" on terminal：
	- step by step compile .java
	- I set the package path in ./classes directory
	- execute the test program（TestCarbonFootprint), which is in ./classes/test/
* I also labeled all programs' compiling command in Makefile so that if you want to singlely compile a program, you can type each command below:
	- make interface
	- make output
	- make bicycle
	- make car
	- make building
	- make test_output
	- make test

# Only Execute：
* You can also type "make execute" on terminal
	- It will execute classes.test.TestCarbonFootprint
	
* You can also type: "java classes.test.TestCarbonFootprint" on your terminal

# Clean:
* I add "make clean" command that you can delete the whole "classes" directory

# Test Program:
* This program creates an array of disparate objects that share an interface.
	- Building("Building", 2, 100, 100, 100, 100, 100, 100, 0));
		+ id
		+ number of people
		+ electricity
		+ natural gas
		+ heating oil
		+ coal
		+ LPG
		+ propane
		+ wooden pellets
	- Car("Car", 10000, 25)
		+ ID
		+ Miles
		+ Miles per Callon
	- Bicycle("Bicycle", 1000, Bicycle.PowerSource.CHEESEBURGERS)
		+ ID, Miles, PowerSource
	
	
# Calculate CarbonFootprint 
* refer to:
	- https://www.carbonfootprint.com/calculator.aspx
	- https://nightcrawler5566.pixnet.net/blog/post/373518581
	
	
	
	
	
	
	


all: interface output bicycle car building test_output test execute

interface:
	javac -d . ./CarbonFootprint.java

output:
	javac -d . ./OutputProcess.java

bicycle:
	javac -d . ./Bicycle.java

car:
	javac -d . ./Car.java

building:
	javac -d . ./Building.java

test_output:
	javac -d . ./TestOutput.java

test:
	javac -d . ./TestCarbonFootprint.java

execute:
	java classes.test.TestCarbonFootprint
clean:
	rm -r ./classes

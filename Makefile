all:


compile:
	javac src/*.java

run:
	cd src/
	java Main.class

clean:
	rm -Rf *.class

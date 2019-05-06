all:

tar:
	tar cvf SERHAN_PITTIS.tar bin/* src/* Makefile *.pdf *.md

compile:
	javac src/*.java -d ./bin/

run:
	cd ./bin/ && java Main

clean:
	rm -f bin/*.class

exec: clean compile run

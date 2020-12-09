all: run

clean:
	rm -f out/MaxWeight.jar out/DFS.jar

out/MaxWeight.jar: out/parcs.jar src/MaxWeight.java src/Node.java
	@javac -cp out/parcs.jar src/MaxWeight.java src/Node.java
	@jar cf out/MaxWeight.jar -C src MaxWeight.class -C src Node.class
	@rm -f src/MaxWeight.class src/Node.class

out/DFS.jar: out/parcs.jar src/DFS.java src/Node.java
	@javac -cp out/parcs.jar src/DFS.java src/Node.java
	@jar cf out/DFS.jar -C src DFS.class -C src Node.class
	@rm -f src/DFS.class src/Node.class

build: out/MaxWeight.jar out/DFS.jar

run: out/MaxWeight.jar out/DFS.jar
	@cd out && java -cp 'parcs.jar:MaxWeight.jar' MaxWeight

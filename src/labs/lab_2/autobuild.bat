mkdir build

cd src
javac -d "../build/" -cp Pokemon.jar Main.java Pokemons/*.java Moves/*.java
copy Pokemon.jar ..\build\
copy main.mf ..\build\

cd ../build
jar -cfm Lab_2.jar main.mf *.class Pokemons/*.class Moves/*.class

java -jar Lab_2.jar

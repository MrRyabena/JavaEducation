
mkdir -p build

cd src
javac -Xms512m -Xmx128m -XX:MaxMetaspaceSize=128m -d "../build/" -cp Pokemon.jar Main.java Pokemons/*.java Moves/*.java
cp Pokemon.jar ../build/
cp main.mf ../build/

cd ../build
jar -Xms512m -Xmx128m -XX:MaxMetaspaceSize=128m -cfm Lab_2.jar main.mf *.class Pokemons/*.class Moves/*.class

java -Xms512m -Xmx128m -XX:MaxMetaspaceSize=128m -jar Lab_2.jar

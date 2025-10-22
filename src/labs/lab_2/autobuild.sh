
mkdir -p build

cd src
javac -d "../build/" -cp Pokemon.jar Main.java Pokemons/*.java Moves/*.java
cp Pokemon.jar ../build/
cp main.mf ../build/

cd ../build
jar -cfm Lab_2.jar main.mf *.class Pokemons/*.class Moves/*.class

# Проверяем, что JAR создался
if [ -f "Lab_2.jar" ]; then
    echo "JAR file created successfully. Running..."
    java -Xmx256m -jar Lab_2.jar
else
    echo "Error: JAR file was not created!"
    exit 1
fi

mkdir -p build

cd src
echo "Compiling Java files..."
javac -d "../build/" -cp Pokemon.jar Main.java Pokemons/*.java Moves/*.java
echo "Copying files..."
cp Pokemon.jar ../build/
cp main.mf ../build/

cd ../build
echo "Creating JAR file..."
jar -cfm Lab_2.jar main.mf *.class Pokemons/*.class Moves/*.class

echo "Running JAR file..."
if [ -f "Lab_2.jar" ]; then
    echo "JAR file created successfully. Running..."
    java -Xms64m -Xmx128m -XX:MaxMetaspaceSize=64m -jar Lab_2.jar
else
    echo "Error: JAR file was not created!"
    exit 1
fi
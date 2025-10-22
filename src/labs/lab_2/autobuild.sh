
#!/bin/bash

echo "=== Starting build process ==="
echo "Java version:"
java -version

# Устанавливаем минимальные настройки JVM для всех команд
export JAVA_OPTS="-Xms32m -Xmx64m -XX:MaxMetaspaceSize=32m"

mkdir -p build

cd src
echo "Compiling Java files..."
javac $JAVA_OPTS -d "../build/" -cp Pokemon.jar Main.java Pokemons/*.java Moves/*.java
if [ $? -ne 0 ]; then
    echo "Error: Compilation failed!"
    exit 1
fi

echo "Copying files..."
cp Pokemon.jar ../build/
cp main.mf ../build/

cd ../build
echo "Creating JAR file..."
jar -cfm Lab_2.jar main.mf *.class Pokemons/*.class Moves/*.class
if [ $? -ne 0 ]; then
    echo "Error: JAR creation failed!"
    exit 1
fi

echo "Running JAR file..."
if [ -f "Lab_2.jar" ]; then
    echo "JAR file created successfully. Running..."
    java $JAVA_OPTS -jar Lab_2.jar
else
    echo "Error: JAR file was not created!"
    exit 1
fi
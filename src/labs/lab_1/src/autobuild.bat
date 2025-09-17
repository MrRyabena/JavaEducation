mkdir build

javac Main.java
jar cfe main.jar Main *.class

copy "Main.class" "build/"
copy "main.jar" "build/"

del Main.class
del Main.jar

cd build

echo "----------Run Main.class:----------"
java Main
echo "-----------------------------------"
echo "-----------Run main.jar:-----------"
java -jar main.jar
echo "-----------------------------------"
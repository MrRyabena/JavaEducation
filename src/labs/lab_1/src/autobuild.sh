mkdir build

javac Main.java
jar cfe main.jar Main *.class

cp Main.class build/
cp main.jar build/

rm Main.class
rm Main.jar

echo "----------Run Main.class:----------"
java Main
echo "-----------------------------------"
echo "-----------Run main.jar:-----------"
java -jar main.jar
echo "-----------------------------------"

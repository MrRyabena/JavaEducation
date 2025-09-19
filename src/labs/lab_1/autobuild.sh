mkdir build

cd src
javac -d ../build/ Main.java

cd ../build
jar cfe main.jar Main *.class

echo "----------Run Main.class:----------"
java Main
echo "-----------------------------------"
echo "-----------Run main.jar:-----------"
java -jar main.jar
echo "-----------------------------------"

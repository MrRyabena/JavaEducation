mkdir -p build

cd src
javac -d ../build/ Main.java

cd ../build
jar cfe main.jar Main *.class

echo "----------Run Main.class:----------"
java -Xmx512m -XX:MaxMetaspaceSize=128m Main
echo "-----------------------------------"
echo "-----------Run main.jar:-----------"
java -Xmx512m -XX:MaxMetaspaceSize=128m -jar main.jar
echo "-----------------------------------"

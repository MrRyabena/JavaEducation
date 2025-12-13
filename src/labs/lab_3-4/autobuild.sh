mkdir -p build

cd src
javac -d "../build/" Main.java transport/*.java
cp main.mf ../build/

cd ../build
jar -cfm lab_3-4.jar main.mf Main.class transport/*.class

java -Xmx512m -XX:MaxMetaspaceSize=128m -jar lab_3-4.jar

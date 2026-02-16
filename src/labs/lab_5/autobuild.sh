mkdir -p build

mvn clean install

cd src
javac -d "../build/" Main.java core/*.java dragon/*.java collection/*.java
cp main.mf ../build/

cd ../build
jar -cfm lab_5.jar main.mf Main.class core/*.class dragon/*.class collection/*.class

java -Xmx512m -XX:MaxMetaspaceSize=128m -jar lab_5.jar

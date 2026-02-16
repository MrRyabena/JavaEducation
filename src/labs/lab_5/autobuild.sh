mkdir -p build

cd src
javac -d "../build/" Main.java core/*.java dragon/*.java
cp main.mf ../build/

cd ../build
jar -cfm lab_5.jar main.mf Main.class core/*.class dragon/*.class

java -Xmx512m -XX:MaxMetaspaceSize=128m -jar lab_5.jar

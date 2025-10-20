mkdir build

cd src
javac -d "../build/" -cp Pokemon.jar Main.java *.java
copy Pokemon.jar ..\build\
copy main.mf ..\build\

cd ../build
jar -cfm Lab_2.jar main.mf *.class

@REM java -cp .;Pokemon.jar Main

java -jar Lab_2.jar

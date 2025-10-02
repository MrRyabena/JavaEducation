mkdir build

cd src
javac -d "../build/" -cp Pokemon.jar Main.java *.java
copy Pokemon.jar ..\build\

cd ../build
java -cp .;Pokemon.jar Main

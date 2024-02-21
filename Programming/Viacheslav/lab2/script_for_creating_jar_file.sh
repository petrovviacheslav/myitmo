export CLASSPATH=./lib/Pokemon.jar:./src:./src/info/Moves/PhysicalMoves:./src/info/Moves/StatusMoves./src/info/Moves/SpecialMoves./src/info/Pokemons:./src/info/Main
javac -d out src/info/Main.java
echo -e "Manifest-Version: 1.0\nClass-Path: lib/Pokemon.jar\nMain-Class: info.Main\n" > MANIFEST.MF
jar cfm Main.jar MANIFEST.MF -C out . -C . lib/ru

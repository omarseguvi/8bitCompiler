#!/bin/sh
set +v
# compila modelo y compilador
javac -cp .:lib:$CLASSPATH  -d lib src/js/*.java src/compiler/*.java

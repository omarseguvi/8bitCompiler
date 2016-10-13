@echo off
REM compila modelo y compilador
javac -cp .;lib;%CLASSPATH%  -d lib src/js/*.java src/compiler/*.java 

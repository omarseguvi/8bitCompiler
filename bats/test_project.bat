@echo off
echo Prueba una caso de prueba: %1
java -cp .;lib;%CLASSPATH% eightBit.compile.EightBitc cases\%1 > output\%1.asm

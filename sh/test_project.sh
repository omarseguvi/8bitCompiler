#!/bin/sh
set +v
echo Prueba un caso de prueba
java -cp .:lib:$CLASSPATH eightBit.compile.EightBitc  > output/out.js

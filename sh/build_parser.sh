#!/bin/sh
# Genera parser y visitors y los compila
# Asume antlr4 esta en el PATH
if java -Xmx500M -cp "/usr/local/lib/antlr-4.5-complete.jar:$CLASSPATH" org.antlr.v4.Tool -visitor  -o src/antlr -package eightBit.compile -no-listener grammar/EightBit.g4

then
  javac -d lib  -Xlint:deprecation src/antlr/*.java

else
  echo "*** ANTLR compilation failed ***"
fi

exit 0

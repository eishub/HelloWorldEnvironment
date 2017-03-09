HelloWorldEnvironment
=====================

This environment creates a simple whiteboard showing messages that can be written there by the entity that it creates.

Action: printText(Txt) prints text to window (whiteboard).

Percept: printedText(Nr) informs about how many times the printText/1 action has been performed.
Percept: lastPrintedText(Txt) informs agent about the last text that was printed to the whiteboard.

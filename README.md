HelloWorldEnvironment
=====================

This environment creates a simple whiteboard showing messages that can be written there by the entity that it creates.


Action: printText(Txt) prints text to window (whiteboard).

Percept: printedText(Nr) informs about how many times the printText/1 action has been performed.

Percept: lastPrintedText(Txt) informs agent about the last text that was printed to the whiteboard.
=======
Dependency information 
=====================

```
<repository>
 <id>eishub-mvn-repo</id>
 <url>https://raw.github.com/eishub/mvn-repo/master</url>
</repository>
```
	
```	
<dependency>
	<groupId>eishub</groupId>
	<artifactId>HelloWorldEnvironment</artifactId>
	<version>1.1.1-SNAPSHOT</version>
</dependency>
```


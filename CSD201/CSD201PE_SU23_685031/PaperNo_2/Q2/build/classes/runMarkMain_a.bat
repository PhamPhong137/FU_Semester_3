cls
echo off
del *.class
javac MarkMain.java
java MarkMain < run_a.txt
pause
del *.class


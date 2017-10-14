set JDK_HOME=C:\Program Files\Java\jdk1.5.0_22
set AGLET_HOME=C:\aglets
set CLASSPATH=.
set CLASSPATH=%CLASSPATH%;%AGLET_HOME%\lib\aglets-2.0.2.jar;%CLASSPATH%;%AGLET_HOME%\lib\swing-layout-1.0.4.jar
javac -encoding utf8 -d %AGLET_HOME%\public -classpath %CLASSPATH% *.java

@echo off
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_181
set Path=%JAVA_HOME%\bin;%Path%
TITLE = Application (Sms spam)
java -Xms32m -Xmx512m -jar -Xmx512m spam_sms-0.0.1-SNAPSHOT.jar
REM
cd ..\data
start java -classpath ../lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:easykin --dbname.0 easykin
start java -classpath ..\target\classes;../lib/hsqldb.jar;../lib/rrozhkov-lib.jar ru.rrozhkov.easykin.gui.EasyKin
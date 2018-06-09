REM
cd ..
start "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe" "http://localhost:8081/EasyKinService/?wsdl"
start java -cp jar\easykin-ws.jar;jar\easykin.jar;lib\hsqldb.jar;lib\rrozhkov-lib.jar ru.rrozhkov.easykin.ws.EasyKinPublisher
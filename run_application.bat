@echo Clean Install Of Applciation
call mvn clean install
cd war
@echo Starting Tomcat7
call mvn tomcat7:run
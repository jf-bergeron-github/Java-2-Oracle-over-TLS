1. Create a Java Keystore
   keytool -keystore [oracle].jks -genkey -alias oracle
   keytool -importkeystore -srckeystore [oracle].jks -destkeystore [oracle].p12 -deststoretype pkcs12

2. Download the certificates (certificate authority and intermediates) from the database host:
   openssl s_client -showcerts -connect [host]:port

3. Import certificates
   keytool -import -keystore [oracle].p12 -file [certificate.pem] -alias "certificate CN"
   ...

4. Download Oracle driver (ojdbc8-full.tar.gz)
   https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html

5. Compile Source

   mkdir lib
   tar xvf ojdbc8-full.tar.gz ./lib

   javac -cp "./lib/*.jar" ./OracleConnection.java
   java cfm OracleConnection.jar manifest.mf OracleConnection.class

6. Update connection.properties accordingly

7. Execute
   java -jar OracleConnection.jar
   


import java.util.Properties;
import java.sql.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class OracleConnection {

    public static void main(String[] args) throws Exception {

        // load database configuration properties file
        try {
            InputStream input = new FileInputStream("./connection.properties");

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Properties config = new Properties();
            config.load(input);

            Properties props = new Properties();

            String url = config.getProperty("db.url");
            props.setProperty("user", config.getProperty("db.user"));
            props.setProperty("password", config.getProperty("db.password"));
            props.setProperty("javax.net.ssl.trustStore", config.getProperty("db.trustStore"));
            props.setProperty("javax.net.ssl.trustStoreType", config.getProperty("db.trustStoreType"));
            props.setProperty("javax.net.ssl.trustStorePassword",
                    config.getProperty("db.trustStorePassword"));
            props.setProperty("SSL_SERVER_DN_MATCH", "yes");

            Connection conn = DriverManager.getConnection(url, props);
            conn.close();

        } catch (

        Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

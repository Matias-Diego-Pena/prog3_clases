package pe.edu.pucp.softprog.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

//patron singleton, para utilizar un unica instancia
public class DBManager {

    private static DBManager instance;
    private final String hostname ;
    private final String user ;
    private final String password ;
    private final String port ;
    private final String database;




    private Connection con;
    private final String DB_CRDENTIALS_FILE = "db";

    //private Properties properties;  usado nomas par ala primera forma

    private DBManager (){
        //instrucciones de creacion de objeto
        //leer el properties del resources

        /* Primer forma de leer el archivo
        properties = new Properties();
        try{
            InputStream inputStream =
                    getClass().getClassLoader().getResourceAsStream(DB_CRDENTIALS_FILE);

            properties.load(inputStream);
        } catch (Exception ex){
            System.out.println("ERROR al leer el archivo de credenciales: "
                    + ex.getMessage());
        }
         */


        //mejor esta forma xd
        ResourceBundle db = ResourceBundle.getBundle(DB_CRDENTIALS_FILE);
        hostname = db.getString("db.hostname");
        user = db.getString("db.user");
        port = db.getString("db.port");
        password = db.getString("db.password");
        database = db.getString("db.database");



    };

    public static DBManager getInstance(){
        if (instance == null)
            instance = new DBManager();

        return instance;
    }

    public Connection getConnection(){
        try {
            //indicamos el driver de conexion
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://"+hostname+":"+port+"/"+database;
            //establecemos conexion con la base de datos
            con = DriverManager.getConnection(url,user,password);

            System.out.println("se establecio conexion con la dase de datos");

        } catch(Exception ex){
            System.out.println("ERROR al conectar con la BD: "
                    + ex.getMessage());
        }
        return con;
    }
}

using MySql.Data.MySqlClient;
using System.Linq.Expressions;
using System.Runtime.InteropServices.Marshalling;

public class Program
{
    public static void Main(String[] args)
    {
        Console.WriteLine("Hello, world!");

        String cadena =
            "Server=mysql-clases-matias.cb8wai" +
            "24tylj.us-east-1.rds.amazonaws.com;" +
            "Port=3306;" +
            "Database=prog3;" +
            "User ID=admin;" +
            "Password=DJ#167349_smPerro";






        MySqlConnection con = new MySqlConnection(cadena);

        con.Open();
        System.Console.WriteLine("Abrimos conexion con la base de datos");

        MySqlCommand cmd = con.CreateCommand();
        cmd.CommandText = "INSERT INTO area(nombre,activa)" +
            "VALUES('AAII',1)";

        int resultado = cmd.ExecuteNonQuery(); //INSERT, UPDATE, DELETE

        if (resultado != 0)
            System.Console.WriteLine("El area de ha registrado con exito");
        
        con.Close();
    }
}

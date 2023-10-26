package Excepciones;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Excepciones 
{
	//ArithmeticException
	/*
	public static void main (String [] args )
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese un numero");
		int a = sc.nextInt();
		System.out.println("Ingrese otro numero");
		int b = sc.nextInt();
		int suma = a+b;
		int resta = a-b;
		int multiplicacion = a*b;
		try
		{
		int division = a/b;
		System.out.println("La division es: " + division);
		}
		catch (ArithmeticException e)
		{
		 System.out.println("Error: Division por cero");	
		}
		sc.close();
		System.out.println("La suma es: "+ suma);
		System.out.println("La resta es: " + resta);
		System.out.println("La multiplicacion es: " + multiplicacion);
	}
	
	
	public static void main (String [] args)
	{
		int [] numeros = {1,2,3,4,5};
		try
		{
		for(int i= 0; 1 <= numeros.length; i++)
		{
			System.out.println("Numero en el indice " + i + ":" + numeros[i]);
		}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.err.println("Error: indice fuera de rango");
			}
	}
	//RuntimeException: El tiempo de ejeucción. 
	public static void main (String [] args )
	{
		int dividiendo = 10;
		int divisor = 0;
		
		try
		{
			int resultado = dividiendo / divisor;
			System.out.println("Resultado: " + resultado);
		}
		catch (RuntimeException e)
		{
			System.out.println("Error diviendo por cero. ");
		}
		System.out.println("El programa continua ejecutandose despues del intento.");
	}
	
	public static void main (String [] args)
	{
		String cadena = null;
		try
		{
		int longitud = cadena.length();
		System.out.println("Longitud de la cadena: " + longitud);
		}
		catch(NullPointerException e)
		{
			System.err.println("Error: Puntero nulo. La cadena es vacia");
		}
	}

	public static void main (String [] args)
	{
		try {
			
	
		String cadena = "Java";
		char caracter = cadena.charAt(10);
		System.out.println(caracter);
	}
		catch (StringIndexOutOfBoundsException e)
		{
			System.err.println("Error de manipulación en la cadena : " + e.getMessage());
		}
	}

	public static void main (String [] args)
	{
		try {
		FileInputStream archivo = new FileInputStream("archivo_no.txt");
		}
		catch(FileNotFoundException e)
		{
			System.err.println("Error: Archivo no encontrado.");
		}
		}
		
	public static void main (String [] args)
	{
		Scanner sc = new Scanner (System.in);
		int numero = sc.nextInt();
		System.out.println(numero);
		
	}
	
	public static void main (String [] args)
	{
		try {
		Socket socket = new Socket("socket_prueba.com", 80);
		}
		catch (SocketException e)
		{
			System.err.println("Error de red: " + e.getMessage());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	*/
	/*
	 * ¿Que son los sockets? Son una API que permite la comunicación entre procesos en una red
	 * utilizando el protocolo TCP/IP. Nos permiten enviar datos entre maquinas a traves de la red.
	
	public static void main (String [] args)
	{
		try
		{
		List<String> listaVacia = new ArrayList<>();
		String elemento = listaVacia.get(0);
		System.out.println(elemento);
		}
		catch(NoSuchElementException e)
		{
			System.err.println("Error: Elemento no encontrado en la lista");
		}
	}
	
	public static void main (String[] args)
	{
		try 
		{
		Connection conexion = DriverManager.getConnection("jdbc:db_url");
		Statement statement = conexion.createStatement();
		ResultSet resultado = statement.executeQuery("SELECT * FROM CLIENTES");
		}
		catch(SQLException e) 
		{
			System.err.println("Error de conexion a la base de datos: " + e.getMessage());
		}
	}
*/
	public static void main (String [] args) throws CustomArithmeticException 
	{
		try
		{

		int resultado = 10 / 0 ;
		System.out.println(resultado);
		}
		catch (ArithmeticException e)
		{
			throw new CustomArithmeticException("Error capturado, excepción creada propia");
		}
	 catch (Exception e)
	{
		System.err.println("Manejo personalizado: " + e.getMessage());
	}
}
	 
}
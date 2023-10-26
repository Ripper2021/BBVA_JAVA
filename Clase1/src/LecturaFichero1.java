/*
Scanner: Lectura de datos separados por delimitadores: Si el archivo de texto c ontiene datos que estan separados
por delimitadores (como comas, tabulaciones, punto y comas.
Se  puede utilizar para analizar y extraer los datos de manera sencilla.
Si necesitas leer tipos de datos primitivos como enteros, flotantes, etc. Scanner proporciona
metodos convenietes. NextInt nextDouble

BufferedReader:
Lectura eficiente de archivos GRANDES. Es eficiente ya que realiza la lectura en el bufer de memoria,
lo que minimiza la llamada al sistema operativo y reduce la sobrecarga de lectura. 
Lectura linea por linea lo cual indica que se encarga de leer toda la información de forma
eficiente. Lo hace a traves del metodo readLine(). 

FileReader: 
Lectura de caracteres de forma individual.
Se utiliza para casos de lectura simple. 

Files.readAllLines: Se utiliza para leer todas las lineas de un archivo
en una lista de CADENAS. Es conveniente para leer archivos de texto en su totalidad. 
Conciso: Requiere menos recursos 
Cierre automatico: cierra el archivo de manera automatica
Sencillez: Es el mas facil de usar. 
Desventajas: 
Consumo de memoria, rendimiento.
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class LecturaFichero1 
{
	public static void main (String [] args)
	{
		try {
		Scanner sc = new Scanner(new File ("C:\\Users\\Gusta\\OneDrive\\Documentos\\ResolucionJava1\\resultados.txt"));
		while(sc.hasNextLine()) //hasNextLine significa que tiene lineas para leer
		{
			System.out.println(sc.nextLine()); //Imprime las lineas que va leyendo.
		}
	}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
}
}
/*
 * ACTIVIDAD 1:
Desarrollar un programa en Java que permita al usuario realizar las 4 operaciones aritmeticas basicas (suma, resta, division, multiplicación)
donde el usuario debe insertar 2 valores numericos por consola, y luego, se debe informar el resultado de las 4 operaciones.
CONSIDERACIONES:
El programa debe hacer lo siguiente:
- Crear un directorio donde se almacene el resultado de salida
- Ese directorio luego debe ser utilizado para almacenar el archivo de salida que contenga los resultados
- El archivo de salida se debe llamar "resultados"
EXTRA:
- Si la salida esta formateada. Por ejemplo:
El numero1 utilizado fue: 
El numero2 utilizado fue: 
El resutado de la suma es: resutadoSuma
El resultado de la multiplicación es: 
ENTREGABLES:
- Codigo del proyecto. 
- TXT de salida.
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class ResolucionAct1 
{
	public static void main (String[] args)
	{
		
	//Declaro variables de tipo File y Scanner
	Scanner sc = new Scanner(System.in);
	String directorio = "C:\\Users\\Gusta\\OneDrive\\Documentos\\ResolucionJava1\\";
	String archivoSalida = "resultados.txt";
	String ruta_Final = directorio + archivoSalida;
	File directorioFile = new File(directorio);
	boolean creado = directorioFile.mkdir();
	
	//Declaro las variables de calculo
	System.out.println("Ingrese el primer numero:");
	int num1 = sc.nextInt();
	System.out.println("Ingrese el segundo numero");
	int num2 = sc.nextInt();
	int suma = num1+num2;
	int  resta = num1-num2;
	int multiplicacion = num1*num2;
	int  division = num1/num2;
	//Declaro las variables de almacenamiento
	String resultadoSuma = "El resultado de la suma es:" + suma;
	String resultadoResta = "El resultado de la resta es:" + resta;
	String resultadoMultiplicacion = "El resultado de la multiplicacion es:" + multiplicacion;
	String resultadoDivision = "El resultado de la division es:" + division;
	//Declaro variable final que almacena todos los resutados formateados
	String Final = "El numero 1 utilizado es: " + num1 + "\n" + "El numero 2 utilizado es: " + num2+ "\n" +resultadoSuma + "\n" + resultadoResta + "\n"+ resultadoMultiplicacion + "\n" + resultadoDivision;
	System.out.println("Se genera el directorio indicado");
	File archivo = new File(ruta_Final);
	//Escribo dentro del archivo. 
	try {
	if (! archivo.exists())
	{
			archivo.createNewFile();
		System.out.println("Se creo el fichero");
	}
	FileWriter fw = new FileWriter(archivo);
	BufferedWriter bw = new BufferedWriter (fw);
	bw.write(Final);
	bw.close();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	}
}

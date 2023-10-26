/*
try-catch se utiliza para manejar excepciones en Java. 
¿Que son las excepciones? Son eventos inusuales o errores que pueden ocurrir
durante la ejecución de un programa.
Try: Se envuelve el codigo que puede generar una excepción
Catch: se utiliza para manejar o capturar esa excepción.
¿Que nos permite el try-catch? Esto nos permite que el programa
continue ejecutandose en lugar de terminar de manera abrupta debido a un error
¿Cuando se usa?
- Se usa para manejar excepciones que se pueden producir DURANTE la ejecución del programa
- Se espera que una operación pueda lanzar una excepción y se desea manejarla de forma ESPECIFICA.
- Por ejemplo: registrar un error, notificar al usuario, conectarse a una API. 

Throw: Arroja excepciones MANUALMENTE durante una parte del codigo
- Util cuando se encuentra una condición (!) EXCEPCIONAL (!) que no se puede manejar localmente y se debe comunicar
a un nivel superior para su manejo. 
- Permite definir excepciones personalizadas para situaciones especificas. 
- Usado para propagar errores hacia arriba en la jerarquia de llamadas de funciones. 


FileWriter: Es una clase que se utiliza para escribir caracteres en un archivo de texto.
Esta clase crea un abre un archivo para su escritura. Si el archivo ya existe, el contenido anterior SE SOBRESCRIBE, si el archivo no existe se crea uno nuevo
Es simple de usar para escribir texto en archivos, PERO no es muy eficiente para grandes cantidades de datos.
BufferedWriter: Es una clase que proporciona una capa de almacenamiento en bufer para escribir caracteres en un archivo
Mejora el rendimiento al reducir las operaciones de escritura directa en disco, ya que almacena una cantidad de datos EN MEMORIA
antes de escribirlos en el archivo, lo que reduce la cantidad de acceso al disco. 
Se utiliza en combinación con FileWriter para escribir datos en archivos de manera mas EFICIENTE.
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CrearFichero 
{
		public static void main (String [] args)
		{
			try {
			String ruta = "C:\\Users\\Gusta\\OneDrive\\Documentos\\Prueba\\";	
			String nombreArchivo = "proceso_salida.txt";
			String ruta_NombreArchivo = ruta + nombreArchivo;
			String contenido = "Hola, me gusta la paella";
			File archivo = new File(ruta_NombreArchivo);
			if (! archivo.exists())
			{
					archivo.createNewFile();
				System.out.println("Se creo el fichero");
			}
			//Comenzamos la escritura de los ficheros
			FileWriter fw = new FileWriter(archivo);
			//FileWriter necesita de un File
			BufferedWriter bw = new BufferedWriter (fw);
			//BufferedWriter necesita de un FileWriter
			bw.write(contenido);
			bw.close(); //Siempre que abro el BufferedWriter y escribo debo cerrarlo.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
}
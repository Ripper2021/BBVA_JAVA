import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LecturaFichero4 
{
	public static void main (String [] args)
	{
	 try
	 {
		 List<String> lineas = Files.readAllLines(Paths.get("C:\\Users\\Gusta\\OneDrive\\Documentos\\ResolucionJava1\\resultados.txt")); 
		 for (String linea: lineas)
		 {
			 System.out.println(linea);
		 }
	 }
	 catch (IOException e)
	 {
		 e.printStackTrace();
	 }
	 
	}
}

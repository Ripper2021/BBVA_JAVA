import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LecturaFichero2 
{
	public static void main (String [] args)
	{
		try {
		File documento = new File("C:\\Users\\Gusta\\OneDrive\\Documentos\\ResolucionJava1\\resultados.txt");
		BufferedReader objeto = new BufferedReader(new FileReader(documento));
		String caracteres = "";
		while((caracteres = objeto.readLine()) != null)
		{
			System.out.println(caracteres);
		}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}

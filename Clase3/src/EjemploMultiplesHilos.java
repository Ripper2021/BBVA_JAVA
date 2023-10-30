public class EjemploMultiplesHilos 
{
		public static void main (String [] args)
		{
			Thread hilo1 = new Thread(new Tarea("Hilo 1"));
			Thread hilo2 = new Thread(new Tarea("Hilo 2"));
			hilo1.setPriority(Thread.MAX_PRIORITY); //Este hilo es el mas priortario. 
			hilo1.start();
			hilo2.start();
			System.out.println("Hilo principal: Los hilos estan en ejecución");
		}	
static class  Tarea implements Runnable
{
	private String nombre;
	
	public Tarea(String nombre)
	{
		this.nombre = nombre;
	}
@Override
public void run()
	{
		for(int i= 1; i<=5; i++)
		{
			System.out.println(nombre + ":Mensaje" + i);
			try
			{
				Thread.sleep(100);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
}
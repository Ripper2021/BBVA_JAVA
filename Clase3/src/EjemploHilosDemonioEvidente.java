
public class EjemploHilosDemonioEvidente 
{
	public static void main (String [] args)
	{
		Thread hiloNoDemonio = new Thread(new Tarea("Hilo No Demonio"));
		Thread hiloDemonio = new Thread(new Tarea("Hilo Demonio"));
		hiloDemonio.setDaemon(true);
		hiloNoDemonio.setPriority(Thread.MAX_PRIORITY);
		hiloDemonio.setPriority(Thread.MIN_PRIORITY);
		hiloNoDemonio.start();
		hiloDemonio.start();
		try
		{
			hiloNoDemonio.join();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Hilo principal: El hilo demonio ha terminado, el programa se cerrara");
		
		if (hiloNoDemonio.isAlive())
		{
			System.out.println("Hilo principal: El hilo demonio sigue en ejecución! Deteniendo el programa");
		}
	}
}
class Tarea implements Runnable
{
	private String nombre;
	
	public Tarea(String nombre)
	{
		this.nombre = nombre;
	}
@Override
	public void run()
{
	for (int i = 1; i<=10; i++)
	{
		System.out.println(nombre + ": Mensaje " + i);
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
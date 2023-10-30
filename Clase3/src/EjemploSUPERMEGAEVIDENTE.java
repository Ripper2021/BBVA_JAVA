
public class EjemploSUPERMEGAEVIDENTE 
{
	public static void main (String [] args)
	{
		Thread hiloNoDemonio = new Thread(new Operacion("Hilo No demonio", 100));
		Thread hiloDemonio = new Thread(new Operacion("Hilo Demonio", 10000));
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
	
		System.out.println("Hilo principal: el hilo no demonio ha terminado");	
		
		if(hiloNoDemonio.isAlive())
		{
			System.out.println("Hilo Principal: el hilo demonio sigue activo, el programa se cerrara");
			System.exit(0);
		}
	}
}

class Operacion implements Runnable
{
	private String nombre;
	private int duracion;
	
	public Operacion(String nombre, int duracion)
	{
		this.nombre = nombre;
		this.duracion= duracion;
	}
	
public void run()
{
 System.out.println(nombre + ": Realizando operacion...");
 try
 {
	 Thread.sleep(duracion);
 }
 catch(InterruptedException e)
 {
	 e.printStackTrace();
 }
 System.out.println(nombre + ": Operacion completada");
}
}
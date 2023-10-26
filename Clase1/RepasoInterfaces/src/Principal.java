

//@Override es una anotación que se utiliza para indicar que un metodo
//de una subclase esta destinado a anular (o sobreescribir) un metodo heredado de su superclase.

public class Principal implements iSaludo{

	public void saludar()
	{
	 System.out.println("Te estoy dando la patita");
	}
	
	public void despedir()
	{
		System.out.println("Me estoy despidiendo");
	}
	
	public static void main (String [] args)
	{
	 Principal p = new Principal();
	 p.saludar();
	 p.despedir();
	}
}

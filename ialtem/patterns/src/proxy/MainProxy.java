package proxy;

public class MainProxy {

	public static void main(String[] args) {
		IReal real=new Real();
		IReal proxy=new Proxy(real);
		
		System.out.printf("Evaluation of \"15\" is %d.\n" , proxy.compute("15"));
	}

}

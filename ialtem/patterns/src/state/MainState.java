package state;

import state.TCPState.IllegalState;

public class MainState {

	public static void main(String[] args) {
		Context ctx=new Context();
		final int PORT=8888;
		
		System.out.println("Usage: type \"localhost:8888\" in your browser twice.");
		
		try {
			ctx.open(PORT);
			for (int i=1;i<3;i++){
				System.out.println(ctx.receive());
			}
			ctx.close();
			ctx.open(PORT);
			for (int i=1;i<3;i++){
				System.out.println(ctx.receive());
			}
			ctx.close();
		} catch (IllegalState e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Ok, let's now try to call unauthorized operation");
		
		try { Thread.sleep(1000); } catch (InterruptedException e1) {}
		
		try {
			ctx.receive();		
		} catch (IllegalState e) {
			System.err.println("Bingo: "+e.toString());			
		}
		
	}

}

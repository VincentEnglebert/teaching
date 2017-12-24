
class Transfert extends Thread {
	private final Account account;
	private final long amount;

	public Transfert(Account account, long amount) {
		assert account != null;
		assert amount > 0;

		this.account = account;
		this.amount = amount;
	}

	public void run() {
		// synchronized block
		synchronized (account) {
			// inside this block, the thread locks the 'account' resource
			long val = account.getValue();
			sleeping();
			account.setValue(val + amount);
		}
	}

//	// Uncomment this part to test the bad alternative 
//	// and see what is the result. 
//	public void run() {
//		// synchronized block
//			// inside this block, the thread locks the 'account' resource
//			long val = account.getValue();
//			sleeping();
//			account.setValue(val + amount);
//	}
	
	private void sleeping() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}

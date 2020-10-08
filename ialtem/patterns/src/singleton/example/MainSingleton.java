package singleton.example;

public class MainSingleton {
	public static void main(String[] args) {
		SingletonLogger.getInstance().info("running");
		SingletonLogger.getInstance().info("computing");
		SingletonLogger.getInstance().info("stopped");
	}
}

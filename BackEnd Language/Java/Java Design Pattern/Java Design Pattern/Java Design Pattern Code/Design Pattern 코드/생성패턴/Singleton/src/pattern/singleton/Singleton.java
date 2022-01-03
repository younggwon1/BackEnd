package pattern.singleton;

public class Singleton {
	private static Singleton instance;

	private Singleton() {
	}

	// static block initialization for exception handling
	static {
		try {
			instance = new Singleton();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating singleton instance");
		}
	}

	public static Singleton getInstance() {
		return instance;
	}
}

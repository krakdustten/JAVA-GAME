package main;

public class Main 
{
	public static Game game;
	public static GameLoader loader;
	private static Thread gameThread;
	private static Thread loaderThread;
	
	public static void main(String[] args)
	{
		game = new Game();
		loader = new GameLoader();
		
		gameThread = new Thread(game);
		gameThread.setPriority(Thread.MAX_PRIORITY);
		gameThread.start();
		
		loaderThread = new Thread(loader);
		loaderThread.setPriority(Thread.NORM_PRIORITY);
		loaderThread.start();
	}
}

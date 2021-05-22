package pro;

public class NMusic implements Music{
	
	private static Sound playerInstance = new Sound("src/ÄñÖ®Ê«.wav");
	private static NMusic musicInstance;
	
	private NMusic() {
	
	}
	
	public static Sound getSoundInstance() {
		return playerInstance;
	}
	
	public static NMusic getMusicInstance() {
		if(musicInstance == null) {
			musicInstance = new NMusic();
		}
		return musicInstance;
	}


	public void musicPlayer(Sound sound) {
		sound.continues();
		
	}
	
	
}

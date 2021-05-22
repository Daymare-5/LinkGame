package pro;

public class TMusic implements Music {
	private static Sound playerInstance = new Sound("src/���֮��.wav");
	private static TMusic musicInstance;
	
	private TMusic() {
		
	}
	
	public static TMusic getMusicInstance() {
		if(musicInstance == null) {
			musicInstance = new TMusic();
		}
		return musicInstance;
	}
	
	public static Sound getSoundInstance() {
		
		return playerInstance;
	}

	public void musicPlayer(Sound sound) {
		sound.continues();
	}
	
}

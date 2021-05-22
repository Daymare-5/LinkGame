package pro;

public class KMusic implements Music{
	private static Sound playerInstance = new Sound("src/¿¨Å©.wav");
	private static KMusic musicInstance;
	
	private KMusic() {
		
	}
	
	public static Sound getSoundInstance() {
		
		return playerInstance;
	}
	
	public static KMusic getMusicInstance() {
		if(musicInstance == null) {
			musicInstance = new KMusic();
		}
		return musicInstance;
	}

	public void musicPlayer(Sound sound) {
		sound.continues();	
	}
		
}

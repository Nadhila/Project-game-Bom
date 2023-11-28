import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


public class Player {
    private Room currentRoom;
    private boolean adaKode = false;
    
    /**
     * Constructor for objects of class Player
     */
    public Player(Room room) {
        currentRoom = room;
    }
    
    
    /**
	 * Mengatur player punya kode atau tidak.
	 * 
	 * @param kode
	 */
	public void setAdakode(boolean kode) {
		this.adaKode = kode;
	}

	/**
	 * Memeriksa player sudah punya saputangan
	 * 
	 * @return boolean
	 */
	public boolean adakode() {
		return adaKode;
	}
	
	
	/**
	 * Melihat room yang ditempati player sekarang.
	 * 
	 * @return Room
	 */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
	 * Menempatkan player pada room yang dituju.
	 * 
	 * @param currentRoom
	 */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;   
    }
}

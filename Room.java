import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
    A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
   */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;    //stores exits if this room
    private boolean Bom;
    private boolean punyaKode;
    private boolean Musuh;
    private boolean needcode;
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
   
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        Bom=false;
        punyaKode=false;
        Musuh=false;
        needcode=false;
    }

    
    
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
    /**
     * Untuk mengatur sekaligus arah keluar dipisahkan 
     * dengan tanda "," arah keluar yang tersedia adalah 
     * north, east, south, west
     * 
     * @param direction
     * @param row baris ruangan player saat ini
     * @param column kolom ruangan player saat ini
     * @param room objek Room[][]
     */
    
    public void setExit (String direction, int Baris, int Kolom, Room[][] daerah) {
        String[] exit = direction.split(",");
        
        for(int i = 0; i<exit.length; i++) {
            int baris = Baris;
            int kolom = Kolom;
            if(exit[i].equals("north")) {
                baris--;
                }
            else if(exit[i].equals("south")) {
                baris++;
            }
            else if(exit[i].equals("west")) {
                kolom--;
            }
            else if(exit[i].equals("east")) {
                kolom++;
            }
            else {
                continue;
            }
            exits.put(exit[i], daerah[baris][kolom]);
        }
    }
     
 
     /** mengatur ruangan ada kode atau tidak */
    public void setkode(boolean Kode){
   
        this.punyaKode = Kode;
    }
    
     /** memeriksa apakah ruangan ada kode atau tidak */
    public boolean punyaKode(){
   
        return punyaKode ;
    }
    
    /**
     * Mengatur ruangan membutuhkan saputangan atau tidak.
     * @param key
     */
    public void setNeedCode(boolean Kode) {
    	needcode = Kode;
    }
    
    /** Memeriksa suatu ruangan membutuhkan saputangan atau tidak.
     * 
     * @return
     */
    public boolean isNeedACode() {
    	return needcode;
    }
    
    /** apakah ruangan ada musuh atau tidak */
    public boolean ApakahAdaMusuh(){
        return Musuh;
    }
    
    
     /** mengatur ruangan ada musuh atau tidak */
    public void setmusuh(boolean set){
   
        this.Musuh = set;
    }
    
    /** apakah ruangan ada bom atau tidak */
    public boolean ApakahAdaBom(){
        return Bom;
    } 
     
     /** mengatur ruangan ada bom atau tidak */
    public void setbom(boolean set){
        needcode = set;
        this.Bom = set;
    }
    
      
    
    
    
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    
    public String getLongDescription()
    {
        return description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    
    
    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}


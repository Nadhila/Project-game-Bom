import javax.swing.JOptionPane;
import java.util.Random;

public class Game
{
    Player player;
    private Room RoomStart;
    private Parser parser;
    protected Room[][] daerah = new Room[7][7];

    /**
     * Konstruktor untuk kelas game
     */

    public Game () {
        createRoom();
        
        parser = new Parser();
        player = new Player(RoomStart);
    }

    public void createRoom(){
       daerah[1][5] = new Room("Kamu berada di Pabrik Kertas");
        daerah[1][4] = new Room("Kamu berada di jalan kumbang 6");
        daerah[1][3] = new Room("Kamu berada di Cafe Burger");
        daerah[1][2] = new Room("Kamu berada di jalan mawar 6"); 
        daerah[1][1] = new Room("Kamu berada di Tempat Bermain Bowling");                
        daerah[2][5] = new Room("Kamu berada di Rumah Nenek Jey");  
        daerah[2][4] = new Room("Kamu berada di jalan kumbang 5");
        daerah[2][3] = new Room("Kamu berada di Taman Kota");
        daerah[2][2] = new Room("Kamu berada di jalan mawar 5");
        daerah[2][1] = new Room("Kamu berada di Rumah Sakit");
        daerah[3][5] = new Room("Kamu berada di Rumah Bibi Luis");
        daerah[3][4] = new Room("Kamu berada di jalan kumbang 4");
        daerah[3][3] = new Room("Kamu berada di jalan melati 1");
        daerah[3][2] = new Room("Kamu berada di jalan mawar 4");
        daerah[3][1] = new Room("Kamu berada di Gedung Teater");
        daerah[4][5] = new Room("Kamu berada di rumah kakek shu");
        daerah[4][4] = new Room("Kamu berada di jalan kumbang 3");
        daerah[4][3] = new Room("Kamu berada di jalan Kantor Pos");
        daerah[4][2] = new Room("Kamu berada di jalan mawar 3");
        daerah[4][1] = new Room("Kamu berada di Meuseum");
        daerah[5][5] = new Room("Kamu berada di Rumah Pak Takure");
        daerah[5][4] = new Room("Kamu berada di jalan kumbang 2");
        daerah[5][3] = new Room("Kamu berada di rumah Kantor Polisi ");
        daerah[5][2] = new Room("Kamu berada di jalan mawar 2");
        daerah[5][1] = new Room("Kamu berada di Fire Station");
        daerah[6][5] = new Room("Kamu berada di Rumah Mayor");
        daerah[6][4] = new Room("Kamu berada di jalan kumbang 1");
        daerah[6][3] = new Room("Kamu berada di Pizza Parlor");
        daerah[6][2] = new Room("Kamu berada di jalan mawar 1");   
        daerah[6][1] = new Room("Kamu berada di Teater");

        RoomStart = daerah[6][4];

        // atur exit
        daerah[1][5].setExit("west", 1, 5, daerah);
        daerah[1][4].setExit("west,south,east", 1, 4, daerah);
        daerah[1][3].setExit("west,east", 1, 3, daerah);
        daerah[1][2].setExit("west,south,east", 1, 2, daerah); 
        daerah[1][1].setExit("east", 1, 1, daerah);                
        daerah[2][5].setExit("west", 2, 5,daerah);  
        daerah[2][4].setExit("west,south,east,north", 2, 4,daerah);
        daerah[2][3].setExit("south,west,east", 2, 3,daerah);
        daerah[2][2].setExit("west,south,east,north", 2, 2,daerah);
        daerah[2][1].setExit("east", 2, 1,daerah);
        daerah[3][5].setExit("west", 3, 5,daerah);
        daerah[3][4].setExit("west,south,east,north", 3, 4,daerah);
        daerah[3][3].setExit("west,east,south,north", 3, 3,daerah);
        daerah[3][2].setExit("west,south,east,north", 3, 2,daerah);
        daerah[3][1].setExit("east", 3, 1,daerah);
        daerah[4][5].setExit("west", 4, 5,daerah);
        daerah[4][4].setExit("west,south,east,north", 4, 4,daerah);
        daerah[4][3].setExit("west,south,east,north", 4, 3,daerah);
        daerah[4][2].setExit("west,south,east,north", 4, 2,daerah);
        daerah[4][1].setExit("east", 4, 1,daerah);
        daerah[5][5].setExit("west", 5, 5,daerah);
        daerah[5][4].setExit("west,south,east,north", 5, 4,daerah);
        daerah[5][3].setExit("west,east,north", 5, 3,daerah);
        daerah[5][2].setExit("west,south,east,north", 5, 2,daerah);
        daerah[5][1].setExit("east", 5, 1,daerah);
        daerah[6][5].setExit("west", 6, 5,daerah);
        daerah[6][4].setExit("west,east,north", 6, 4,daerah);
        daerah[6][3].setExit("west,east", 6, 3,daerah);
        daerah[6][2].setExit("west,east,north", 6, 2,daerah);   
        daerah[6][1].setExit("east", 6, 1,daerah);
        
        //Random Tempat ada Bom
        int T4Bom = 3;
        int randomBom = (int) (Math.random() * 1000) % 3;

        boolean[] t4Bom = new boolean [T4Bom];
        for(int i=0 ; i < T4Bom; i++)
            t4Bom[i] = false;
        t4Bom[randomBom] = true;

        daerah[1][1].setbom(t4Bom[0]);
        daerah[5][1].setbom(t4Bom[1]);
        daerah[5][5].setbom(t4Bom[2]);
        
        //Random Tempat ada musuh
        int TempatMusuh = 5;

        boolean[] tempatMusuh = new boolean [TempatMusuh];
        for(int i = 0 ; i < TempatMusuh; i++){
            double rand = Math.random();
            tempatMusuh[i] = rand < 0.5;
        }

        daerah[2][1].setmusuh(tempatMusuh[0]);
        daerah[3][3].setmusuh(tempatMusuh[1]);
        daerah[2][3].setmusuh(tempatMusuh[2]);
        daerah[4][1].setmusuh(tempatMusuh[3]);
        daerah[4][5].setmusuh(tempatMusuh[4]);

        //Random Tempat ada kode
        boolean[] kode = new boolean[TempatMusuh];
        int randomKode = (int) Math.round(Math.random() * (TempatMusuh-1));
        for (int i = 0; i < TempatMusuh; i++) {
            kode[i] = false;
        }
        kode[randomKode] = true;
        daerah[2][1].setkode(kode[0]);
        daerah[3][3].setkode(kode[1]);
        daerah[2][3].setkode(kode[2]);
        daerah[4][1].setkode(kode[3]);
        daerah[4][5].setkode(kode[4]);

        

    }

    /**
     * Print out the opening message for the player.
     */
    public String printWelcome () {
        String welcome = "SELAMAT DATANG DI GAME \" BOM SQUAD!\"\n";
        return welcome;
    }

    /**
     * Given a command, process (that is: execute) the command.
     * 
     * @param command
     *            The command to be processed.
     * @return "true" If the command ends the game, response otherwise.
     */
    private String processCommand(Command command) {
        String response = " ";
        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            response = "i don't know what you mean..";
            return response;
        }

       if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if(commandWord == CommandWord.QUIT){
            response = quit(command);
        }
        return response;
    }


    /**
     * Ada bom atau tidak?
     * 
     * @return boolean
     */
    public boolean adaBom() {
        return player.getCurrentRoom().ApakahAdaBom();
    }

    /**
     * Membuat tidak ada musuh.
     */
    public void setTidakAdaMusuh() {
        player.getCurrentRoom().setmusuh(false);
    }

    /**
     * Apakah ada musuh atau tidak?
     * 
     * @return boolean
     */
    public boolean adaMusuh() {
        return player.getCurrentRoom().ApakahAdaMusuh();

    }

    /**
     * Try to go to one direction. If there is an exit, enter the new room,
     * otherwise print an error message.
     */
    public String goRoom(Command command) {
        String room= " ";
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            room = "Go where?";
            // System.out.println(room);
            return room;
        }

        String direction = command.getSecondWord();
        //String direction = "west";
       
        // Try to leave current room.
        Room nextRoom = player.getCurrentRoom().getExit(direction);
        
     
       

        if (nextRoom == null) {
            room = "Tidak ada jalan";
           
        } 
        else{
            player.setCurrentRoom(nextRoom);
            room = player.getCurrentRoom().getLongDescription();
        }
        
    
        return room;  
    } 

    /**
     * Memeriksa suatu ruangan ada saputangan atau tidak.
     * 
     * @return boolean
     */
    public boolean adakode() {
        return player.getCurrentRoom().punyaKode();
    }

    /**
     * Mengambil kunci pada ruangan
     */
    public void ambilkode() {
        player.getCurrentRoom().setkode(false);
        player.setAdakode(true);
    }

    // mengembalikan player ke StartRoom
    public void backToEntranceStartRoom() {
        setPlayerCurrentRoom(6, 4, " ");
    }

    // mengatur current room player sesuka hati
    public void setPlayerCurrentRoom(int baris, int kolom, String namaRoom) {
        
        if (namaRoom.equals("daerah")) {
            player.setCurrentRoom(daerah[baris][kolom]);
        } 
    }

    /**
     * "Quit" was entered. Check the rest of the command to see whether we
     * really quit the game.
     * 
     * @return "quit", if this command quits the game, a confirmation question
     *         otherwise.
     */
    public String quit(Command command) {
        String response = "quit";
        if (command.hasSecondWord()) {
            response = "Quit what?";
        }
        return response;
    }


    /**
     * Pergi ke arah yang dituju
     * 
     * @param direction
     * @return deskripsi ruang
     */
    public String Go(String direction) {
        return goRoom(new Command(CommandWord.GO, direction));
    }
}


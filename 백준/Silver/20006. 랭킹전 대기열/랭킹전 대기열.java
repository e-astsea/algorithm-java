import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Player{
        int level;
        String name;

        public Player(final int level, final String name) {
            this.level = level;
            this.name = name;
        }

        public int getLevel() {
            return level;
        }

        public String getName() {
            return name;
        }
    }

    private static class Room {
        int startLevel;
        int nowPlayer= 0;
        List<Player> players = new ArrayList<>();

        public Room(final int startLevel) {
            this.startLevel = startLevel;
        }

        public boolean checkRoom(int level){
            if(startLevel+10 >= level && startLevel-10 <= level){
                return true;
            }
            return false;
        }

        public boolean checkMaxPlayer(){
            if(nowPlayer < m){
                return true;
            }
            return false;
        }

        public void addPlayer(Player player){
            players.add(player);
            nowPlayer++;
        }

        public List<Player> getPlayers() {
            return players;
        }
    }

    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Player> players = new ArrayList<>();
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            players.add(new Player(Integer.parseInt(st.nextToken()), st.nextToken()));
        }


        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            boolean inRoom = false;
            for (int j = 0; j < rooms.size(); j++) {
                final Room room = rooms.get(j);
                if(!room.checkRoom(player.level)){
                    continue;
                }
                if(!room.checkMaxPlayer()){
                    continue;
                }
                room.addPlayer(player);
                inRoom = true;
                break;
            }
            if(inRoom == false){
                Room room = new Room(player.level);
                room.addPlayer(player);
                rooms.add(room);
            }
        }

        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            if(room.getPlayers().size() == m){
                System.out.println("Started!");
            } else{
                System.out.println("Waiting!");
            }

            room.getPlayers().sort(Comparator.comparing(Player::getName));


            for (int j = 0; j < room.getPlayers().size(); j++) {
                final Player player = room.getPlayers().get(j);
                System.out.println(player.getLevel()+" "+player.getName());
            }
        }
    }
}

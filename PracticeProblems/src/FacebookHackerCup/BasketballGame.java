package FacebookHackerCup;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import files.ReadWriteTextFile;

public class BasketballGame {

	
	public static void main(String[] args){
		File file = new File("C:\\Users\\Nomad\\workspace\\Practice\\src\\FacebookHackerCup\\basketball_game_example_input.txt");
		List<String> inputFile = ReadWriteTextFile.getContents(file);
		
		int numStudents = 0;
		int minutes = 0;
		int numPlayers = 0;
		
		int numTests = Integer.parseInt(inputFile.get(0));
		
		int idx = 1;
		String line = null;
		
		for(int i = 1; i <= numTests; i++){
			line = inputFile.get(idx);
			StringTokenizer token = new StringTokenizer(line, " ");
			
			//get initial test vals
			numStudents = Integer.parseInt(token.nextToken());
			minutes = Integer.parseInt(token.nextToken());
			numPlayers = Integer.parseInt(token.nextToken());
			
			Player[] playerList = new Player[numStudents];
			List<Player> teamA = new ArrayList<Player>();
			List<Player> teamB = new ArrayList<Player>();
			
			for(int j = 1; j <= numStudents; j++){
				line = inputFile.get(j+idx);
				StringTokenizer playerToken = new StringTokenizer(line, " ");
				
				String playerName = playerToken.nextToken();
				int shotPercentage = Integer.parseInt(playerToken.nextToken());
				int height = Integer.parseInt(playerToken.nextToken());
				Player player = new Player(playerName, shotPercentage, height);
				playerList[j-1] = player;
				System.out.println(player.toString());
			}
			
			rankPlayers(playerList);
			splitIntoTeams(playerList, teamA, teamB);
			
			System.out.println("Team A");
			printTeamList(teamA);
			System.out.println("---------------------------------------------------");
			System.out.println("Team B");
			printTeamList(teamB);
			idx += numStudents+1;
			
			System.out.println("=====================================================");
		}
	}
	
	static class Player{
		String name = null;
		int shotPercentage = 0;
		int height = 0;
		
		public Player(String name, int shotPercentage, int height){
			this.name = name;
			this.shotPercentage = shotPercentage;
			this.height = height;
		}
		
		public String toString(){
			String val = "Name            : "+ this.name +"\n" + 
						 "Shot Percentage : "+ this.shotPercentage + "\n" +
						 "Height          : "+ this.height + "\n";
			
			return val;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getShotPercentage() {
			return shotPercentage;
		}

		public void setShotPercentage(int shotPercentage) {
			this.shotPercentage = shotPercentage;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}
	}
	
	public static void rankPlayers(Player[] players){
		for(int i =0; i < players.length; i++){
			for(int j = i; j< players.length; j++){
				if(players[i].getShotPercentage() < players[j].getShotPercentage()){
					Player tempPlayer = players[i];
					players[i] = players[j];
					players[j] = tempPlayer;
				}
				if(players[i].getShotPercentage() == players[j].getShotPercentage() &&
					players[i].getHeight() < players[j].getHeight()){
					
					Player tempPlayer = players[i];
					players[i] = players[j];
					players[j] = tempPlayer;
				}
			}
		}
		
		for(int i = 0; i < players.length; i++){
			
			System.out.println("Name :: " + players[i].getName() + ", " + players[i].getShotPercentage() + ", " + players[i].getHeight());
		}
	}
	
	public static void splitIntoTeams(Player[] playerList, List<Player> teamA, List<Player> teamB){
		int idx_a = 0;
		int idx_b = 0;
		
		for(int i = 0; i < playerList.length; i++){
			if(i%2 == 0){
				teamA.add(playerList[i]);
				idx_a++;
			}
			else{
				teamB.add(playerList[i]);
				idx_b++;
			}
		}
	}
	
	public static void printTeamList(List<Player> playerList){
		for(int i = 0; i < playerList.size(); i++){
			System.out.println(playerList.get(i).getName() + ", " + playerList.get(i).getShotPercentage());
		}
	}
}



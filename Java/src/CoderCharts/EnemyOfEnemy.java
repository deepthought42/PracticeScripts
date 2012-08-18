package CoderCharts;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class EnemyOfEnemy {
	public static void main(String[] args){
		String enemyFile = args[0];
		ArrayList<String> people = null;
		boolean[][] enemies = null;
		boolean[][] friends = null;
		
		ArrayList<String> enemyList = new ArrayList<String>();
		ArrayList<String> friendList = new ArrayList<String>();
		HashMap<String, ArrayList<String>> enemyMap = new HashMap<String, ArrayList<String>>();

		HashMap<String, ArrayList<String>> friendMap = new HashMap<String, ArrayList<String>>();
		
		
		//foreach line in enemy relationships lines
		// read in enemy1
		// read in enemy2
		// if enemy1 exists in enemyMap then add enemy2 to enemyList for enemy1
		// if enemy2 exists in enemyMap then add enemy1 to enemyList for enemy2
		
		// foreach test case
		// 	get list of enemies for testcase person in enemyMap
		//  foreach enemy in enemyList for person in enemyMap
		//		append disjoint list of enemy->enemyList && person->enemyList to friendMap[person]->friendList
		try {
			ArrayList<String> friendsList = new ArrayList<String>();

			FileInputStream fstream = new FileInputStream(enemyFile);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String str;
			//begin reading in lines
			int numPeople = 0;
			int numRelationships = 0;
			StringTokenizer tokens = null;
			String tok = null;
			int lineIndex = 0;
			//String inputString = "new input string";
			while((str = br.readLine()) != null){
				tokens = new StringTokenizer(str);
				int index = 0;
				if(lineIndex==0){
					while(tokens.hasMoreTokens()){
						tok = tokens.nextToken();
						if(index==0){
							numPeople = Integer.parseInt(tok);
							people = new ArrayList<String>(numPeople);
							enemies = new boolean[numPeople][numPeople];
							friends = new boolean[numPeople][numPeople];
						}
						else{
							numRelationships = Integer.parseInt(tok);
						}
						index++;
					}
				}
				else if(lineIndex>0 && lineIndex<=numRelationships){
					String[] pplIndex = new String[2];
					while(tokens.hasMoreTokens()){
						tok = tokens.nextToken();
						if(!people.contains(tok) ){
							people.add(tok);
							
						}
						
						if(!enemyMap.containsKey(tok)){
							enemyMap.put(tok, new ArrayList<String>());
							friendMap.put(tok, new ArrayList<String>());
						}
						
												
						pplIndex[index] = tok;
						index++;
					}
					enemyMap.get(pplIndex[0]).add(pplIndex[1]);
					enemyMap.get(pplIndex[1]).add(pplIndex[0]);
					
					//enemies[pplIndex[0]][pplIndex[1]] = true;
					//enemies[pplIndex[1]][pplIndex[0]] = true;
				}
				else if(lineIndex == numRelationships+1){
					while(tokens.hasMoreTokens()){
						tok = tokens.nextToken();
					}
				}
				else if(lineIndex > numRelationships+1){
					int totalFriends = 0;
					String friend = "";
					while(tokens.hasMoreTokens()){
						tok = tokens.nextToken();
						friend = tok;
						int personIndex = people.indexOf(tok);
						
						ArrayList<String> enemiesOrig = enemyMap.get(tok);
						printList(enemiesOrig);

						for(int i=0; i<enemiesOrig.size(); i++){
							ArrayList<String> enemyEnemies = (ArrayList<String>) enemyMap.get(enemiesOrig.get(i));
							printList(enemyEnemies);
							enemyEnemies.removeAll(enemiesOrig);
							enemyEnemies.remove(tok);
							union(friendMap.get(tok), enemyEnemies);
							System.out.println("FRIEND LIST:: ");
							printList(friendMap.get(tok));

						}
						
						
						/*for(int j=0; j<enemies.length; j++){
							if(enemies[personIndex][j]){
								for(int w=0; w<enemies.length; w++){
									if(w==personIndex){
										continue;
									}
									if(enemies[w][j] && !enemies[personIndex][w]){
									*/
										//if(!friends[personIndex][w]){
										//	totalFriends++;
										
										//	friends[personIndex][w] = true;
										//	friends[w][personIndex] = true;
										//}
										/*if(!friendsList.contains(people.get(w))){
											friendsList.add(people.get(w));
										}
									}
									else if(enemies[w][j] && enemies[personIndex][w]){
										//the enemy of your enemy is also your enemy and can't be a friend
										//friends[personIndex][w] = false;
										//friends[w][personIndex] = false;
										friendsList.remove(people.get(w));
									}
								}
							}
						}
						*/
						//totalFriends = friendList.size();
						
						totalFriends = friendMap.get(tok).size();
					}
					System.out.println(totalFriends);
					friendsList.clear();
				}
				
				lineIndex++;
			}
		}catch (IOException e) { e.printStackTrace();}		
		
	}
	
	public static void printArray(boolean[][] arr){
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length; j++){
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println("");
		}
	}
	
	public static void printArray(ArrayList arr){
		for(int i=0; i<arr.size(); i++){
			System.out.print(arr.get(i)+"\t");
		}
	}
	
	public static void printList(ArrayList<String> arr){
		Iterator<String> iter = arr.iterator();
		while(iter.hasNext()){
			System.out.print(iter.next());
		}
		System.out.println("");
	}
	/**
	 * does a union of 2 lists by adding all new values in list2 to list1
	 * @param list1
	 * @param list2
	 */
	public static void union(ArrayList<String> list1, ArrayList<String> list2){
		Iterator<String> iter = list2.iterator();
		String enemy = "";
		while(iter.hasNext()){
			enemy = iter.next();
			if(!list1.contains(enemy)){
				list1.add(enemy);
			}
		}		
	}
}

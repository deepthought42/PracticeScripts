package aStar;

import java.util.ArrayList;

public class AreaMap {

    private int mapWidth;
    private int mapHeight;
    private ArrayList<ArrayList<Node>> map;
    private int startLocationX = 0;
    private int startLocationY = 0;
    private int goalLocationX = 0;
    private int goalLocationY = 0;
    private int[][] obstacleMap;
    
    //private Logger log = new Logger(null);
    
    AreaMap(int mapWidth, int mapHeight, int[][] obstacleMap) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.obstacleMap = obstacleMap;
        
        createMap();
        //log.addToLog("\tMap Created");
        registerEdges();
        //log.addToLog("\tMap Node edges registered");
    }
    
    private void createMap() {
        Node node;
        map = new ArrayList<ArrayList<Node>>();
        for (int x=0; x<mapWidth; x++) {
                map.add(new ArrayList<Node>());
                for (int y=0; y<mapHeight; y++) {
                        node = new Node(y, y);
                        if (obstacleMap[x][y] == 1)
                                node.setObstical(true);
                        map.get(x).add(node);
                }
        }
    }
    
    /**
     * Registers the nodes edges (connections to its neighbors).
     */
    private void registerEdges() {
            for ( int x = 0; x < mapWidth-1; x++ ) {
                    for ( int y = 0; y < mapHeight-1; y++ ) {
                            Node node = map.get(x).get(y);
                            if (!(y==0))
                                    node.setNorth(map.get(x).get(y-1));
                            if (!(y==0) && !(x==mapWidth))
                                    node.setNorthEast(map.get(x+1).get(y-1));
                            if (!(x==mapWidth))
                                    node.setEast(map.get(x+1).get(y));
                            if (!(x==mapWidth) && !(y==mapHeight))
                                    node.setSouthEast(map.get(x+1).get(y+1));
                            if (!(y==mapHeight))
                                    node.setSouth(map.get(x).get(y+1));
                            if (!(x==0) && !(y==mapHeight))
                                    node.setSouthWest(map.get(x-1).get(y+1));
                            if (!(x==0))
                                    node.setWest(map.get(x-1).get(y));
                            if (!(x==0) && !(y==0))
                                    node.setNorthWest(map.get(x-1).get(y-1));
                    }
            }
    }
}

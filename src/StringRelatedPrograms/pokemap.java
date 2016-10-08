package StringRelatedPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class pokemap {
	   static class PokeMap {

	        private final long[][] grid;

	        PokeMap(long[][] grid) {
	            this.grid = grid;
	        }
	        
	        public long getSizeX() {
	            return grid[0].length;
	        }
	        
	        public long getSizeY() {
	            return grid.length;
	        }

	        public long getValue(Location loc) {
	            return getValue(loc.getX(), loc.getY());
	        }

	        long getValue(int x, int y) {
	            if (y >= grid.length || x >= grid[y].length) {
	                throw new IllegalArgumentException("Requested coordinates outside of map");
	            }
	            return grid[y][x];
	        }


	        @Override
	        public String toString() {
	            StringBuilder sb = new StringBuilder();
	            String lineSeparator = System.getProperty("line.separator");
	            for (long[] row : grid) {
	                sb.append(Arrays.toString(row)).append(lineSeparator);
	            }
	            return sb.toString();
	        }
	    }
	    
	    static class Location {

	        private final int x;
	        private final int y;

	        Location(int x, int y) {
	         this.x = x;
	         this.y = y;
	        }

	        int getY() {
	            return y;
	        }

	        int getX() {
	           return x;
	        }

	        @Override
	        public String toString() {
	            return "Location{" +
	                  "x=" + x +
	                 ", y=" + y +
	                  '}';
	        }
	    }
	    
	    private static double sqrt(double a) {
	        return Math.sqrt(a);
	    }
	    
	    private static double log10(double a) {
	        return Math.log10(a);
	    }
	    
	    private static double roundToPlaces(double d, int numDecimalPlaces) {
	        int scaleFactor = (int) Math.pow(10, numDecimalPlaces);
	        return Math.floor(d * scaleFactor) / scaleFactor;
	    }

	    static double findMaximumXP(Location playerPosition, long numPokeBalls, PokeMap pokeMap) {
	        //finding pokemon positions
	    	  TreeSet<Double> XPSet=new TreeSet<Double>();
		      
	    	int i,j;
	    	Location l=null;
	        double xmax=pokeMap.getSizeX();
	        double ymax=pokeMap.getSizeY();
	        List<Location> listOfPokemonPositions=new ArrayList<Location>();
	        
	        for(i=0;i<xmax;i++){
	            for(j=0;j<ymax;j++){
	                if(pokeMap.getValue(i,j)!=0 &&pokeMap.getValue(i,j)!=pokeMap.getValue(playerPosition))
	                	{
	                	l=new Location(i,j);
	                	listOfPokemonPositions.add(l);
	                	}
	            }
	        }
	        //finding XP for all pokemon positions
	        for(Location p:listOfPokemonPositions){
	             int ux= playerPosition.getX();
	             int uy= playerPosition.getY();
	             Long k= pokeMap.getValue(p); 
	            double d=sqrt((double)((ux-p.getX())*(ux-p.getX()) +(uy-p.getY())*(uy-p.getY())));
	            double cost1=d+log10(k);
	            double yourxp=k/cost1;
	            XPSet.add(yourxp);
	        }
	        
	        double total=0;
	        while(numPokeBalls!=0){
	            total=total+XPSet.last();
	            XPSet.remove(XPSet.last());
	            
	            numPokeBalls--;
	        }
	        
	        return roundToPlaces(total, 3);
	    }


	public static void main(String[] args) {
	
	}

}

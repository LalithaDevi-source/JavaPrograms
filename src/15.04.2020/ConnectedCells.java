package Day7;

public class ConnectedCells {

     public static int getSize(int[][] ar , int i , int j){
        if(j<0 || i<0 || i >= ar.length || j >= ar[0].length){
            return 0;
        }
        if(ar[i][j]==0){
            return 0;
        }
        int size = 1;
        ar[i][j]=0;
        for(int row = i-1 ; row <= i+1 ; row++){
            for(int col = j-1 ; col <= j+1 ; col++){
                if(i != row || j != col)
                    size+=getSize(ar , row , col);
            }
        }
        return size;
    }

    // Complete the maxRegion function below.
    static int maxRegion(int[][] grid) {
         int maxR = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int size = getSize(grid,i,j);
                    maxR = Math.max(size,maxR); 
                }
            }          
        }
        return maxR;
    }


    public static void main(String[] args)  {
    	int[][] grid = {{1, 1, 0, 0},{0, 1, 1, 0},{0, 0, 1, 0},{1, 0, 0, 0
}};  
    	System.out.println(maxRegion(grid));
    	
    }
}

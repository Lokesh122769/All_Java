public class Sudoku
{
	    private int[][] sudoku;
        private static final int UNASSIGNED = 0;
          
        public Sudoku()
        {
            sudoku = new int[9][9];
        }
          
        public Sudoku(int sudoku[][])
        {
            this.sudoku= sudoku;
        }

	public static boolean solveSudoku()
    {
        for(int row=0;row<9;row++)
        {
            for(int col=0;col<9;col++)
            {
                if(sudoku[row][col]==UNASSIGNED)
                {
                    for(int number=1;number<=9;number++)
                    {
                        if(isAllowed(row, col, number))
                        {
                            sudoku[row][col] = number;
                            if(solveSudoku())
                            {
                                return true;
                            }
                            else
                            {
                                sudoku[row][col] = UNASSIGNED;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

	private static boolean containsInRow(int row,int number)
    {
        for(int i=0;i<9;i++)
        {
            if(sudoku[row][i]==number)
            {
                return true;
            }
        }
        return false;
    }
  
    private static boolean containsInCol(int col,int number)
    {
        for(int i=0;i<9;i++)
        {
            if(sudoku[i][col]==number)
            {
                return true;
            }
        }
        return false;
    }
  
  
    private static boolean containsInBox(int row, int col,int number)
    {
        int r = row - row%3;
        int c = col - col%3;
        for(int i = r ; i< r+3 ; i++)
        {
            for(int j = c; j < c+3 ; j++)
            {
                if(sudoku[i][j]==number)
                {
                    return true;
                }
            }
              
        }
        return false;
    }

    public static boolean isAllowed(int row, int col,int number)
    {
        return !(containsInRow(row, number) || containsInCol(col, number) || containsInBox(row, col, number));
    }

	public static void displaySudoku()
    {
        for(int i=0;i<9;i++)
        {
            if(i%3==0 && i!=0)
            {
                System.out.println("----------------------------------\n");
            }
            for(int j=0;j<9;j++)
            {
                if(j%3==0 && j!=0)
                {
                    System.out.print(" | ");
                }
                System.out.print(" " + sudoku[i][j] + " ");
      
            }
      
            System.out.println();
        }
        System.out.println("\n\n__________________________________________\n\n");
    }

	public static void main(String args[])
	{
		int arr[][] = { {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
                        {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
                        {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
                        {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
                        {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
                        {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
                        {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
                        {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
                        {0, 0, 5, 2, 0, 6, 3, 0, 0} };
		Sudoku s = new Sudoku(arr);
		s.solveSudoku();
		s.displaySudoku();
	}
}
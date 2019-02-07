package edu.jsu.mcis;


public class TicTacToeModel {
    
    public static final int DEFAULT_WIDTH = 3;
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this (DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];

        /* Initialize board by filling every square with empty marks */
        
        // INSERT YOUR CODE HERE
        for (int row=0; row<width; row++){
            for(int col=0; col<width; col++){
                board[row][col] = Mark.EMPTY;
            }
        }   
        
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Use "isValidSquare()" to check if the specified location is in range,
           and use "isSquareMarked()" to see if the square is empty!  If the
           specified location is valid, make a mark for the current player, then
           toggle "xTurn" from true to false (or vice-versa) to switch to the
           other player before returning TRUE.  Otherwise, return FALSE. */
        
        boolean m= false;
    
        if ( isValidSquare(row, col) ) {
            if (xTurn && isSquareMarked(row, col)==false)
            {
                board[row][col] = TicTacToeModel.Mark.X;
                    xTurn = false;
                    m = true;
            }
            else if(!xTurn && isSquareMarked(row, col)==false)
            {
                board[row][col] = TicTacToeModel.Mark.O;
                xTurn = true;
                m = true;
            }
        }
        
    
    
        return m;
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        
        if((row >= 0 && row < width) && (col >= 0 && col < width) )
        { 
            return true; 
        } 
        
        else {
            return false;
        }
     
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        
        if (isValidSquare(row, col)) {
            if(board[row][col] != TicTacToeModel.Mark.EMPTY)
            {
                return true;
            }
        }

        return false;
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
        // INSERT YOUR CODE HERE
        TicTacToeModel.Mark mark = board[row][col];
        return mark;
            
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        
        // INSERT YOUR CODE HERE
        if (isMarkWin(TicTacToeModel.Mark.X)){
            return TicTacToeModel.Result.X;
        }
        else if (isMarkWin(TicTacToeModel.Mark.O)){
            return TicTacToeModel.Result.O;
        }
        else if (Tie()){
            return TicTacToeModel.Result.TIE;
        }
        else{
            return TicTacToeModel.Result.NONE;
        }

    
        
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        // INSERT YOUR CODE HERE
        //horizontal
        int count = 0;
        for(int row = 0; row<width; ++row){
           for (int col = 0; col<width; ++col){
               if (getMark(row, col) == mark){
                   count++;
                }  
               else{
                   count = 0;
               }
               
               if ( count == width){
                   return true;
               }
             
            }
           
           count = 0;
        }
        //vertical
        for(int col = 0; col<width; ++col){
           for (int row = 0; row<width; ++row){
               if (getMark(row, col) == mark){
                   count++;
                }  
               else{
                   count = 0;
               }
               
               if ( count == width){
                   return true;
               }
             
            }
           
           count = 0;
        }
        
        for(int i = 0; i<width; ++i){
           if (getMark(i,width-i-1) == mark){
                   count++;
            }  
           else{
                   count = 0;
            }
               
            if ( count == width){
                   return true;
            }
             
        }
          
        
        for(int i = 0; i<width; ++i){
            if (getMark(i,i) == mark){
                   count++;
            }  
            else{
                   count = 0;
            }
               
            if ( count == width){
                   return true;
            }
             
        }
        
        return false;
    } 
  
    
	
    private boolean Tie() {
        
        /* Check the squares of the board to see if the game is a tie */
        
        // INSERT YOUR CODE HERE
            for (int i=0; i<width; i++){
                for (int j=0; j<width; j++){
                    if (getMark(i, j) == TicTacToeModel.Mark.EMPTY){
                    return false;
                    }    
            }        
            }
        
        if (isMarkWin(TicTacToeModel.Mark.X) || isMarkWin(TicTacToeModel.Mark.O)){
            return false;
        } 
        
        else{
            return true;
        }
        
    }
    

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */
        
        for (int i = 0; i < width; ++i) {
            output.append(i);
        }
        
        output.append("\n");
        for(int i=0; i<width; i++)
        {
            output.append(i + " ");
            for(int j=0; j<width; j++)
                output.append(board[i][j]);
            output.append("\n");
        }
        
        return output.toString();
        
    }

    
}

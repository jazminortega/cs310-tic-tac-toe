package edu.jsu.mcis;

public class TicTacToeController {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView();
        
    }

    public void start() {
    
        /* MAIN LOOP (repeats until game is over) */

        /* Display the board using the View's "showBoard()", then use
           "getNextMove()" to get the next move from the player.  Enter
           the move (using the Model's "makeMark()", or display an error
           using the View's "showInputError()" if the move is invalid. */

        // INSERT YOUR CODE HERE
       while(!model.isGameover())
        {
            
       
            view.showBoard(model.toString());
            
            if (model.isXTurn())
                System.out.println("Player 1 (X) Move: \n");
            else 
                System.out.println("Player 2 (O) Move: \n");
            
            
            TicTacToeMove move = view.getNextMove(true);
            
            boolean result = model.makeMark(move.getRow(), move.getCol());
            
           if(!result){
            view.showInputError();
           } 
            
        }
        
        /* After the game is over, show the final board and the winner */

        view.showResult(model.getResult().toString());
        

}
}

package edu.jsu.mcis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class TicTacToeController implements ActionListener {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */
    public String getMarkAsString(int row, int col) {        
    return (model.getMark(row, col).toString());        
    }
    
    public TicTacToeView getView() {        
        return view;        
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        // INSERT YOUR CODE HERE
        String button = ((JButton) event.getSource()).getName();
        int row = button.charAt(6) -48;
        int col = button.charAt(7) -48;
        
        model.makeMark(row, col);
        JButton click = (JButton) event.getSource();
        view.updateSquares(click, model, row, col);
    }

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView(this, width);
        
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
            
       
            //view.showBoard(model.toString());
            
            if (model.isXTurn())
                System.out.println("Player 1 (X) Move: \n");
            else 
                System.out.println("Player 2 (O) Move: \n");
            
            
            //TicTacToeMove move = view.getNextMove(true);
            
            //boolean result = model.makeMark(move.getRow(), move.getCol());
            
           //if(!result){
           // view.showInputError();
           //} 
            
        }
        
        /* After the game is over, show the final board and the winner */

        view.showResult(model.getResult().toString());

 

}
}

package expedia.tictac.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * TicTacToe Game calling!
 *
 */
public class App {
    public static void main( String[] args ) {
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/expedia/tictac/test/beans/beans.xml");
        
        TicTacToeGame ticTac = (TicTacToeGame) context.getBean("tictactoegame");
        ticTac.main(args); 
        
        ((FileSystemXmlApplicationContext) context).close();
    }
}

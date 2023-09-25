/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Model;

import static Model.Color.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author zheln
 */
public class FacadeGameTest {

    private FacadeGame facade;
    private Game game;

    @BeforeEach
    public void setUp() {
        Game game = new Game();
        facade = new FacadeGame(game);
        Color[][] gameTest = {{R, G, B, G, R, B},
                                {R, G, R, G, R, B},
                                {R, G, G, B, R, B}};
        facade.setGame(gameTest);
    }

    @Test
    public void start_game(){
        Game game = new Game();
        FacadeGame facade = new FacadeGame(game);
        facade.start(3, 5);
        int numberBlockMin= 16;
        assertTrue(facade.getRow()*facade.getColumn()>=numberBlockMin);
    }
    
    @Test
    public void isInside_true_when_really_inside() {
        int x = 0;
        int y = 1;
        assertTrue(facade.isInside(x, y));
    }

    @Test
    public void isInside_false_when_not_inside() {
        int x = 4;
        int y = 0;
        assertFalse(facade.isInside(x, y));
    }

    @Test
    public void start_game_is_successfully_created() {
        Color[][] gameTest = {{R, G, G, G, R, B}, {R, G, G, G, R, B}, {R, G, G, G, R, B}};
        int nbBlock = 0;
        for (int i = 0; i < gameTest.length; i++) {
            for (int j = 0; j < gameTest[i].length; j++) {
                nbBlock++;
            }
        }
        assertTrue(facade.getRow() * facade.getColumn() == nbBlock);
    }

    @Test
    public void start_game_not_empty() {
        boolean trigger = true;
        for (int i = 0; i < facade.getGame().length; i++) {
            for (int j = 0; j < facade.getGame()[i].length; j++) {

                if (facade.getGame()[i][j] == null) {
                    trigger = false;
                }
            }
        }
        assertTrue(trigger);
    }

    @Test
    public void play_block_removed_and_compact() {
        Color[][] gameTestResult = {{R, G, B, null, R, B},
                                    {R, G, R, null, R, B},
                                    {R, G, G, B, R, B}};
        facade.play(0, 3);
        boolean trigger = true;
        int test = gameTestResult.length * gameTestResult[0].length;
        if (gameTestResult.length * gameTestResult[0].length == facade.getRow() * facade.getColumn()) {
            for (int i = 0; i < facade.getGame().length; i++) {
                for (int j = 0; j < facade.getGame()[i].length; j++) {
                    if (facade.getGame()[i][j] != gameTestResult[i][j]) {
                        trigger = false;
                        break;
                    };
                }
            }
        }
        assertTrue(trigger);
    }

    @Test
    public void play_block_removed_column_is_compact() {
        Color[][] gameTestResult = {{G, B, G, R, B, null},
         {G, R, G, R, B, null},
         {G, G, B, R, B, null}};
        facade.play(0, 0);
        boolean trigger = true;
        int test = gameTestResult.length * gameTestResult[0].length;
        if (gameTestResult.length * gameTestResult[0].length == facade.getRow() * facade.getColumn()) {
            for (int i = 0; i < facade.getGame().length; i++) {
                for (int j = 0; j < facade.getGame()[i].length; j++) {
                    if (facade.getGame()[i][j] != gameTestResult[i][j]) {
                        trigger = false;
                        break;
                    }
                }
            }

        }
        assertTrue(trigger);

    }
    
    @Test
    public void score_test(){
        facade.play(0, 3);
        facade.getScore();
        int score= facade.getScore();
        System.out.println(score);
        assertTrue(score==2);
    }
    
    @Test
    public void lose_game(){
        Color[][] gameLose = {{null, null, null,null, null, null},
                                {null, null, null,null, null, null},
                                {null, R, G,null, null, null}};
        facade.setGame(gameLose);
        assertFalse(facade.winOrNot());
    }
    
    @Test
    public void win_game(){
        Color[][] gameLose = {{null, null, null,null, null, null},
                                {null, null, null,null, null, null},
                                {null, null, null,null, null, null}};
        facade.setGame(gameLose);
        assertTrue(facade.winOrNot());
    }
}

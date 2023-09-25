/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Command;

import Model.Command.CommandBuilder;
import Model.Color;
import static Model.Color.*;
import Model.FacadeGame;

import Model.Game;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author zheln
 */
public class CommandBuilderTest {
    
    private Game game;
    private FacadeGame facade;
    private CommandBuilder command;
    
    @BeforeEach
    public void setUp() {
        Game game = new Game();
        facade = new FacadeGame(game);
        this.command = new CommandBuilder(facade);
        Color[][] gameTest = {  {R, G, B, G, R, B},
                                {R, G, R, G, R, B},
                                {R, O, G, B, R, B}};
        facade.setGame(gameTest);
    }
    
    @Test
    public void test_undo_result(){
        Color[][] gameResult = { {R, null, B, G, R, B},
                                {R, null, R, G, R, B},
                                {R, O, G, B, R, B}};
        command.playCommand(0, 1);
        command.playCommand(0, 3);
        command.undo();
        assertArrayEquals(gameResult, command.getFacadeGame().getGame());
    }
    
    @Test
    public void test_redo_result(){
        Color[][] gameResult = { {R, null, B, null, R, B},
                                {R, null, R, null, R, B},
                                {R, O, G, B, R, B}};
        command.playCommand(0, 1);
        command.playCommand(0, 3);
        command.undo();
        command.redo();
        assertArrayEquals(gameResult, command.getFacadeGame().getGame());
    }
    
    @Test
    public void test_undo_when_not_play(){
        Color[][] gameResult = { {R, G, B, G, R, B},
                                {R, G, R, G, R, B},
                                {R, O, G, B, R, B}};
        command.undo();
        assertArrayEquals(gameResult, command.getFacadeGame().getGame());
    }
    
    @Test
    public void test_redo_not_execute_when_stack_isEmpty(){
        command.redo();
        assertTrue(command.getRedoCommand().isEmpty());
    }
    
    @Test
    public void test_undo_not_execute_when_stack_isEmpty(){
        command.undo();
        assertTrue(command.getHistoryCommand().isEmpty());
    }
    
}

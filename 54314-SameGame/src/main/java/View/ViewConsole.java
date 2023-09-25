package View;

import Model.Color;
import Model.FacadeGame;
import Observer.Observer;
import java.util.Scanner;

/**
 * Class ViewConsole
 * @author 54314
 */
public class ViewConsole implements View,Observer {

    private FacadeGame facade;

    /**
     * Constructor of ViewConsole
     * @param facade 
     */
    public ViewConsole(FacadeGame facade) {
        this.facade = facade;
    }

    @Override
    public void displayWelcome() {
        System.out.println("Same Game, Auteur : 54314");
    }

    @Override
    public void displayPlate() {
        String number = " ";
        int a = 0;
        while (a < this.facade.getColumn()) {
            number += String.format("%3d", a );
            a++;
        }
        number += "\n";
        String array = number;
        for(int i=0;i<this.facade.getGame().length;i++){
            array+=String.format("%1d", i);
            for(int j=0;j<this.facade.getGame()[i].length;j++){
                if(this.facade.getGame()[i][j]==null){
                    array=array+String.format("%3s", " ");
                }
                else if(this.facade.getGame()[i][j] instanceof Color){
                    array=array+String.format("%3s", this.facade.getGame()[i][j]);
                    
                }
                
            }
            array+="\n";
        }
        System.out.println(array);
        
    }

    @Override
    public void displayScore() {
        System.out.println("Score :" + this.facade.getScore());

    }

    @Override
    public void displayEnd() {
        if (this.facade.winOrNot()) {
            System.out.println("Fin de la partie: vous avez gagner");
        } else {
            System.out.println("Fin de la partie : vous avez perdu");
        }
    }

    /**
     * Robust method
     * @param message
     * @return 
     */
    private int readInteger(String message) {
        System.out.println(message);
        Scanner clavier = new Scanner(System.in);
        while (!clavier.hasNextInt()) {
            System.out.println("Vous avez entrer un mauvais nombre");
            System.out.println(message);
            clavier.next();

        }
        return clavier.nextInt();
    }

    @Override
    public int askPositionX() {
        int row = readInteger("Entrez la ligne");
        return row;
    }

    @Override
    public int askPositionY() {
        int col = readInteger("Entrez la colonne");
        return col;
    }

    @Override
    public int askSize() {
        int size = readInteger("Entrez le choix de votre niveau (taille du plateau minimum 4, maximum 10) ");
        while(size<=3 || size>=11){
            System.out.println("Taille incorrect");
            size=readInteger("Entrez le choix de votre niveau (taille du plateau minimum 4) ");
        }
        return size;
    }

    @Override
    public int askLevel() {
        int level = readInteger("Entrez le choix de votre niveau (choix niveau : 3-4-5 couleurs)");
        while(level>=6 || level <=2){
            System.out.println("Choix du niveau incorrect");
            level = readInteger("Entrez le choix de votre niveau (choix niveau : 3-4-5 couleurs)");
        }
        return level;
    }

    @Override
    public String askString() {
        System.out.println("Undo(u),Redo(r),Play(p) or Stop(s)?");
        Scanner clavier = new Scanner(System.in);
        while (!clavier.hasNextLine()) {
            System.out.println("Choix inexistant");
            clavier.next();

        }
        return clavier.nextLine();
    }

    @Override
    public void update(Boolean bool) {
        if(!bool){
           displayScore();
           displayPlate();
        }
        else{
            displayScore();
            displayPlate();
            displayEnd();
        }
    }

}

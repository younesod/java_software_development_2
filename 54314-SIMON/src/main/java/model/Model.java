
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import static model.Color.*;
import util.Observable;
import util.Observer;

/**
 * The model manage the color's sequences and react each time the controller detect a click 
 * 
 * @author 54314
 */
public class Model implements Observable {

    private final ArrayList<Color> colorList;
    private final ArrayList<Color> colorToAdd;
    private final ArrayList<Color> longest;
    private final ArrayList<Color> last;
    private int indexList;
    private boolean have_win_notwin;
    private Timer timer;
    private TimerTask timerTask;

    private final List<Observer> observers = new ArrayList<>();

    /**
     * Constructor of Model
     */
    public Model() {
        this.indexList = 0;
        this.last = new ArrayList<>();
        this.longest = new ArrayList<>();
        this.colorToAdd = new ArrayList<>();
        this.colorList = new ArrayList<>();
        this.have_win_notwin = false;
        this.timer = new Timer();

    }

    /**
     * This methods start the game by creating all the necessary to start the game
     */
    public void start() {
        this.indexList = 0;
        Collections.addAll(this.colorToAdd, GREEN, RED, YELLOW, BLUE);
        Random r = new Random();
        int rand = r.nextInt(4);
        Collections.shuffle(this.colorToAdd);
        this.colorList.add(this.colorToAdd.get(0));
        this.last.add(this.colorToAdd.get(0));
        this.longest.add(this.colorList.get(indexList));
        this.have_win_notwin = false;
    }

    /**
     * This method managess to add into the sequence's list or signal an error when the user click on a color
     * @param color 
     */
    public void click(Color color) {
        if (this.colorList.get(this.indexList).equals(color)) {
            this.longest.add(this.colorList.get(indexList));
            this.indexList++;
            this.have_win_notwin = true;
        } else if (!this.colorList.get(this.indexList).equals(color)) {
            System.out.println("Signalement d'une erreur");
            this.have_win_notwin = false;
        }
        if (indexList != colorList.size()) {
            have_win_notwin = false;
        }
    }

    /**
     * This method manages the timer and notify the observer 
     */
    public void timer() {
        int timeLeft=6000;
        System.out.println("Vous avez "+timeLeft/1000+"s pour rejouer les notes");
        timerTask = new TimerTask() {
            @Override
            public void run() {

                notifyObservers(have_win_notwin);
            }

        };
        timer.cancel();
        timer = new Timer();
        timer.schedule(timerTask, timeLeft);

    }
    /**
     * Getter of colorList
     * @return list of colorList
     */
    public ArrayList<Color> getColorList() {
        return colorList;
    }
    /**
    * Getter of longest
    * @return list of longest
    */
    public ArrayList<Color> getLongest() {
        return longest;
    }
    /**
     * Getter of last
     * @return list of last
     */
    public ArrayList<Color> getLast() {
        return last;
    }

    @Override
    public void subscribe(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void notifyObservers(Boolean bool) {
        for (Observer observer : observers) {
            observer.update(bool);
        }

    }

    @Override
    public void unsubscribe(Observer ob) {
        if (!observers.contains(ob)) {
            observers.remove(ob);
        }
    }
}

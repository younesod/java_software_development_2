package Observer;

/**
 *An Observer object in the Observer/Observable pattern.
 * Essentialy presents an update method wich permits the Observable
 * to notify it of any change
 * @author 54314
 */
public interface Observer {
    
    /**
     * This method is called whenever the observer object has changed
     * @param bool 
     */
    void update(Boolean bool);
}

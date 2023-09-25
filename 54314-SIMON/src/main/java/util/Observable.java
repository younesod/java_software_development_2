
package util;

/**
 *An Observable object in the Observer/Observable pattern.
 * Maintains a list of observer and notifies them
 * whenever an internal state changed
 * 
 * @author 54314
 */
public interface Observable {
    
    /**
     * Removes the observer from the list of observers
     * @param observer The observer to be removed
     */
    void unsubscribe(Observer observer);
    
    /**
     * Adds an observer to the list of observers
     * @param observer The observer to be added
     */
    void subscribe(Observer observer);

    /**
     * Notifies all observers by calling their update method
     * @param bool 
     */
    void notifyObservers(Boolean bool);
}

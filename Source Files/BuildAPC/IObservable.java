/**
 * @author Ciaran Curley
 * 
 */

package BuildAPC;

public interface IObservable {
	public void addObserver(IObserver newObserver);
	public void removeObserver(IObserver oldObserver);
	public void notifyObserver();
}

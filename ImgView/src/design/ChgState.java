/**
 * 
 */
package design;

/** 
 * @author artur
 */
public class ChgState extends Actions {
	public void initAction(Object params){
		Actions._session.changeState((int)params);
	}
}

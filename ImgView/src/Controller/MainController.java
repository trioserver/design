package Controller;

import java.util.ArrayList;

import Model.ImageContainer;
import Model.Session;
import View.MainView;


public class MainController {

    private Session _session;
    private Actions curAction;
    private MainView _view;
    
    public MainController(MainView Ui) {
	curAction = null;
	_view = Ui;
    }
    
    
    public void performActionNext() {
	Actions next = new DoNext(_session.getDisplayState(),
				_session.getNbrImages(), 
				_session.getCurrentImage());
	next.addPreviousAction(curAction);
	curAction = next;
	next.addObserver(_view);
	_session.setCurrentImage(next.initAction());
	// put code here to grey out a button and not allow further command
	// objects to be created
    }
    
    public void performActionPrev() {
	Actions prev = new DoPrev(_session.getDisplayState(),
				_session.getNbrImages(), 
				_session.getCurrentImage());
	prev.addPreviousAction(curAction);
	curAction = prev;
	prev.addObserver(_view);
	_session.setCurrentImage(prev.initAction());
    }
    
    public void chgState(int newState) {
	Actions state = new ChgState(_session.getDisplayState(),
				_session.getNbrImages(), 
				_session.getCurrentImage(), 
				newState);
	state.addPreviousAction(curAction);
	curAction = state;
	state.addObserver(_view);
	_session.setCurrentImage(state.initAction());
	_session.setDisplayState(newState);
    }
    
    public void chgTypeState(String typeString) {
	Actions type = new ChgTypeState(_session.getDisplayState(), _session.getCurrentImage(), 0, _session.getType(), typeString);
	
	type.addPreviousAction(curAction);
	curAction = type;
	type.addObserver(_view);
	type.initAction();
	_session.setCurrentImage(0);
	_session.setNbrImages(type.initAction());
    }
    
    public void initStudy(String directory) {
	Actions init = new InitStudy(directory, _view);
	_session = new Session();
	init.addPreviousAction(curAction);
	curAction = init;
	init.addObserver(_view);
	ArrayList<Integer> setNewSession = new ArrayList<Integer>();
	setNewSession.add(1); // display
	setNewSession.add(0); // current image
	setNewSession.add(init.initAction());
	_session.setAll(setNewSession);
    }
    
    public void undoPreviousAction() {
	_session.setAll(curAction.undoAction());
	curAction = curAction.getPreviousAction();
    }

	/**
	 * Getter of the property <tt>_session</tt>
	 * @return  Returns the _session.
	 * @uml.property  name="_session"
	 */
	public Session get_session() {
		return _session;
	}

	/**
	 * Setter of the property <tt>_session</tt>
	 * @param _session  The _session to set.
	 * @uml.property  name="_session"
	 */
	public void set_session(Session _session) {
		this._session = _session;
	}
	/**
	 * @uml.property  name="_mainView"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="_mainController:design.MainView"
	 */
	//private MainView _mainView = new design.MainView();

	/**
	 * Getter of the property <tt>_mainView</tt>
	 * @return  Returns the _mainView.
	 * @uml.property  name="_mainView"
	 */
	//public MainView get_mainView() {
	//	return _mainView;
	//}

	/**
	 * Setter of the property <tt>_mainView</tt>
	 * @param _mainView  The _mainView to set.
	 * @uml.property  name="_mainView"
	 */
	//public void set_mainView(MainView _mainView) {
	//	this._mainView = _mainView;
	//}

	/** 
	 * @uml.property name="_actions"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" aggregation="shared" inverse="mainController:design.Actions"
	 */
    	/*
	private ArrayList _actions;
	*/

	/** 
	 * Returns the element at the specified position in this list.
	 * @param index  index of element to return.
	 * @return  the element at the specified position in this list.
	 * @see java.util.List#get(int)
	 * @uml.property  name="_actions"
	 */
    	/*
	public ArrayList get_actions() {
		return _actions;
	}
	*/

	/** 
	 * Returns the element at the specified position in this list.
	 * @param index  index of element to return.
	 * @return  the element at the specified position in this list.
	 * @see java.util.List#get(int)
	 * @uml.property  name="_actions"
	 */
	/*
	public Actions get_actions(int i) {
		return (Actions) _actions.get(i);
	}
	*/

	/**
	 * Returns an iterator over the elements in this list in proper sequence.
	 * @return  an iterator over the elements in this list in proper sequence.
	 * @see java.util.List#iterator()
	 * @uml.property  name="_actions"
	 */
	/*
	public Iterator _actionsIterator() {
		return _actions.iterator();
	}
	*/

	/**
	 * Returns <tt>true</tt> if this list contains no elements.
	 * @return  <tt>true</tt> if this list contains no elements.
	 * @see java.util.List#isEmpty()
	 * @uml.property  name="_actions"
	 */
	/*
	public boolean is_actionsEmpty() {
		return _actions.isEmpty();
	}
	*/

	/**
	 * Returns <tt>true</tt> if this list contains the specified element.
	 * @param element  element whose presence in this list is to be tested.
	 * @return  <tt>true</tt> if this list contains the specified element.
	 * @see java.util.List#contains(Object)
	 * @uml.property  name="_actions"
	 */
	/*
	public boolean contains_actions(Actions actions) {
		return _actions.contains(actions);
	}
	*/

	/**
	 * Returns <tt>true</tt> if this list contains all of the elements of the specified collection.
	 * @param elements  collection to be checked for containment in this list.
	 * @return  <tt>true</tt> if this list contains all of the elements of the specified collection.
	 * @see java.util.List#containsAll(Collection)
	 * @uml.property  name="_actions"
	 */
	/*
	public boolean containsAll_actions(Collection _actions) {
		return this._actions.containsAll(_actions);
	}
	*/

	/**
	 * Returns the number of elements in this list.
	 * @return  the number of elements in this list.
	 * @see java.util.List#size()
	 * @uml.property  name="_actions"
	 */
	/*
	public int _actionsSize() {
		return _actions.size();
	}
	*/

	/**
	 * Returns an array containing all of the elements in this list in proper sequence.
	 * @return  an array containing all of the elements in this list in proper sequence.
	 * @see java.util.List#toArray()
	 * @uml.property  name="_actions"
	 */
	/*
	public Actions[] _actionsToArray() {
		return (Actions[]) _actions.toArray(new Actions[_actions.size()]);
	}
	*/

	/**
	 * Returns an array containing all of the elements in this list in proper sequence; the runtime type of the returned array is that of the specified array.
	 * @param a  the array into which the elements of this list are to be stored.
	 * @return  an array containing all of the elements in this list in proper sequence.
	 * @see java.util.List#toArray(Object[])
	 * @uml.property  name="_actions"
	 */
	/*
	public Actions[] _actionsToArray(Actions[] _actions) {
		return (Actions[]) this._actions.toArray(_actions);
	}
	*/

	/**
	 * Inserts the specified element at the specified position in this list (optional operation)
	 * @param index  index at which the specified element is to be inserted.
	 * @param element  element to be inserted.
	 * @see java.util.List#add(int,Object)
	 * @uml.property  name="_actions"
	 */
	/*
	public void add_actions(int index, Actions actions) {
		_actions.add(index, actions);
	}
	*/

	/**
	 * Appends the specified element to the end of this list (optional operation).
	 * @param element  element to be appended to this list.
	 * @return  <tt>true</tt> (as per the general contract of the <tt>Collection.add</tt> method).
	 * @see java.util.List#add(Object)
	 * @uml.property  name="_actions"
	 */
	/*
	public boolean add_actions(Actions actions) {
		return _actions.add(actions);
	}
	*/

	/**
	 * Removes the element at the specified position in this list (optional operation).
	 * @param index  the index of the element to removed.
	 * @return  the element previously at the specified position.
	 * @see java.util.List#remove(int)
	 * @uml.property  name="_actions"
	 */
	/*
	public Object remove_actions(int index) {
		return _actions.remove(index);
	}
	*/

	/**
	 * Removes the first occurrence in this list of the specified element  (optional operation).
	 * @param element  element to be removed from this list, if present.
	 * @return  <tt>true</tt> if this list contained the specified element.
	 * @see java.util.List#remove(Object)
	 * @uml.property  name="_actions"
	 */
	/*
	public boolean remove_actions(Actions actions) {
		return _actions.remove(actions);
	}
	*/

	/**
	 * Removes all of the elements from this list (optional operation).
	 * @see java.util.List#clear()
	 * @uml.property  name="_actions"
	 */
	/*
	public void clear_actions() {
		_actions.clear();
	}
	*/

	/** 
	 * Setter of the property <tt>_actions</tt>
	 * @param _actions  the _actions to set.
	 * @uml.property  name="_actions"
	 */
	/*
	public void set_actions(ArrayList _actions) {
		this._actions = _actions;
	}
	*/



}

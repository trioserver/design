package design;


public abstract class Actions {
	static protected Session _session;
	static protected MainView _ui;
	static protected void changeSession(String path)
	{
		_session.chgStudy(path);
	}
	static protected void addUiObserver(MainView ui)
	{
		_session.addObserver(ui);
	}
	
	public abstract void initAction(Object params);
}

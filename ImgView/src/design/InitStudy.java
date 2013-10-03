package design;

public class InitStudy extends Actions {
    
	public InitStudy(String params,MainView ui)
	{
		Actions._session=new Session();
		Actions.addUiObserver(ui);
		initAction(params);
	}
	@Override
	public void initAction(Object params) {
		if (params instanceof String){
			Actions.changeSession((String)params);
		// TODO Auto-generated method stub
		}
	}

}

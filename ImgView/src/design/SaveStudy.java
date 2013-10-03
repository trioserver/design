package design;

public class SaveStudy extends Actions {

	@Override
	public void initAction(Object params) {
		if (params instanceof String) Actions._session.saveStudy((String) params);

	}

}

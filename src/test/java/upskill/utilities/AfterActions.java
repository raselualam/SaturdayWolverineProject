package upskill.utilities;

import cucumber.api.java.After;

public class AfterActions {
	
	@After
	public void afterActions(){
		SetupDrivers.tearDownDriver();
		System.out.println("----- Test Complete, Browser Closed");
	}
	
}
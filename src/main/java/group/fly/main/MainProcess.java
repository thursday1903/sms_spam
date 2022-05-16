package group.fly.main;

import java.util.Timer;

import group.fly.MainApplication;
import group.fly.utilities.Logs;

public class MainProcess {
	static Timer timer = new Timer("timerFactory");
	static final Logs LOGS = new Logs(MainApplication.class);
	
	public static void main(String[] args) {
		LOGS.info("start app scan database and push to mongo");
		
	}
	
	void processCanConfigTable()
	{
		
	}
}

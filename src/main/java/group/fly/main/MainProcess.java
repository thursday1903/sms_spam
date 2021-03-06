package group.fly.main;

import java.util.Timer;

import group.fly.MainApplication;
import group.fly.business.BuzTeleGroup;
import group.fly.business.BuzTeleUser;
import group.fly.thread.ThreadPool;
import group.fly.utilities.Logs;

public class MainProcess {
	static Timer timer = new Timer("timerFactory");
	static final Logs LOGS = new Logs(MainApplication.class);

	public static void main(String[] args) {
		LOGS.info("start app scan  and push user and group to mysql");
		BuzTeleUser buzTeleUser = new BuzTeleUser();
		BuzTeleGroup buzTeleGroup = new BuzTeleGroup();
//		buzTeleUser.process();
//		buzTeleGroup.process();
//		ThreadPool.GetInstance().execute(buzTeleUser);
//		ThreadPool.GetInstance().execute(buzTeleGroup);
		new Thread(buzTeleUser).start();
		new Thread(buzTeleGroup).start();
	}


}

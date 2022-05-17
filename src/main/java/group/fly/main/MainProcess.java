package group.fly.main;

import java.util.Timer;

import org.json.JSONObject;

import group.fly.MainApplication;
import group.fly.utilities.Logs;

public class MainProcess {
	static Timer timer = new Timer("timerFactory");
	static final Logs LOGS = new Logs(MainApplication.class);
	
	public static void main(String[] args) {
		LOGS.info("start app scan database and push to mongo");
		JSONObject json = new JSONObject("{\r\n"
				+ "    \"partner_id\": 90007,\r\n"
				+ "    \"request_id\": \"90007_211129182738.12356\",\r\n"
				+ "    \"username\": \"partner_sb\",\r\n"
				+ "    \"client_ip\": \"192.188.123.456\",\r\n"
				+ "    \"password\": \"\",\r\n"
				+ "    \"provider\": \"VT-POST-PAID\",\r\n"
				+ "    \"payment_amount\":100000,\r\n"
				+ "    \"user_phone\": \"0988659073\",    \r\n"
				+ "    \"client_time\": \"2021112918\",\r\n"
				+ "    \"signature\": \"signature\"\r\n"
				+ "}");
		
		System.out.println(json.get("partner_id").toString());
	}
	
	void processCanConfigTable()
	{
		
	}
}

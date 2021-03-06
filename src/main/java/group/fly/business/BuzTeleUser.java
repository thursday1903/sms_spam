package group.fly.business;

import java.util.Date;

import org.apache.commons.codec.language.bm.Rule.Phoneme;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import group.fly.MainApplication;
import group.fly.cache.RedisCaching;
import group.fly.hibernate.entities.Group;
import group.fly.hibernate.entities.SpamUsers;
import group.fly.hibernate.home.GroupHome;
import group.fly.hibernate.home.SpamUsersHome;
import group.fly.utilities.Logs;
import redis.clients.jedis.Jedis;

public class BuzTeleUser implements Runnable{
	static final Logs logs = new Logs(MainApplication.class);
	public BuzTeleUser() {
		super();
		this.redisClient = RedisCaching.getInstance();
	}

	RedisCaching redisClient;

	public void process() {
		String jsonUser = "";
		
		JSONObject json;
		String phoneNumber;
		String username;
		String accessHash;
		
		Jedis jedis  = null;
		try {			
			jedis  = redisClient.getRedisConnection();
		} catch (Exception e) {
			// TODO: handle exception
						
		}
		while (true) {
			try {
				jsonUser = jedis.lpop(redisClient.tele_user_queue);
				logs.info("start user:" + jsonUser);
				if (jsonUser == null) {
					Thread.sleep(30000);
					continue;
				}
				if (jsonUser.length() == 0) {
					Thread.sleep(30000);
					continue;
				}
				// jsonGroup = gson..
				json = new JSONObject(jsonUser);
				SpamUsers user = new SpamUsers();
				user.setUserTeleId(json.getLong("user_id"));
				user.setUserFromGroupId(json.getLong("group_id"));
				phoneNumber = getJsonString(json, "phone_number");
				if (phoneNumber != null)
					user.setUserPhone(phoneNumber);	
				username = getJsonString(json, "username");
				if (username != null)
					user.setUserNameTele(username);
				accessHash = json.getBigDecimal("access_hash").toPlainString();
				if (accessHash != null)
					user.setAccessHash(accessHash);
				user.setCreatedAt(new Date());
				insertUser(user);
				logs.info("finish user:" + jsonUser);
			} catch (Exception e) {
				// Log here
				logs.fatal("Excetion: ", e);
			}

		}
	}

	void insertUser(SpamUsers user) {
		SpamUsersHome home = new SpamUsersHome();
		try {
			home.persist(user);
		}
		catch (Exception e) {
			// TODO: handle exception
		}

	}
	String getJsonString(JSONObject json, String key) {
		try {
			return json.getString(key);
		}
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	Integer getJsonInt(JSONObject json, String key) {
		try {
			return json.getInt(key);
		}
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		process();
	}
}

package group.fly.main;


import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;




public class MainTest {
	public static void main(String[] args) {
		
		String json = "{\"user_id\": 471574248, \"username\": \"vietanh85kz\", \"group_id\": 623703221, \"phone_number\": \"84933045719\", \"access_hash\": 9116550884046823763}";
		JSONObject jsonTmp = new JSONObject(json);
		System.out.println(jsonTmp.getBigDecimal("access_hash").toPlainString());;
		
		String json2 = "{\"group_id\": 1582539236, \"group_name\": \"group test\", \"total_member\": 4}";
		JSONObject jsonTmp2 = new JSONObject(json2);
		System.out.println("===>"+jsonTmp2.getInt("total_member"));
		DefaultBlockParameter detaul = null;

		try {
			Web3j web3 = Web3j.build(new HttpService("https://bsc-dataseed1.binance.org:443"));
			int value = 0;
//			detaul = DefaultBlockParameter.valueOf(new BigInteger(value));
			Request<?, EthGetBalance> balance = web3.ethGetBalance("0x407d73d8a49eeb85d32cf465507dd71d507100c1", DefaultBlockParameter.valueOf("latest"));
//			EthBlockNumber result = web3.ethBlockNumber().sendAsync().get();
			long timeout = 10;
			EthGetBalance response = balance.sendAsync().get(timeout, TimeUnit.SECONDS);
			System.out.println(" The Block Number is: " + response.getBalance().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

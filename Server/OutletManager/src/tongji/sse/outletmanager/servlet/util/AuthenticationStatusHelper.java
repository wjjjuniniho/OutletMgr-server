package tongji.sse.outletmanager.servlet.util;

import org.json.JSONException;
import org.json.JSONObject;

import tongji.sse.outletmanager.datamodel.AuthenticationStatusObject;
import tongji.sse.outletmanager.servlet.ServletConstant;

public class AuthenticationStatusHelper {
	public static JSONObject toJSONObject(AuthenticationStatusObject authenticationStatusObject) {
		JSONObject authenticationStatusJSONObject = new JSONObject();
		try {
			authenticationStatusJSONObject.put(ServletConstant.USERNAME, authenticationStatusObject.getUsername());
			authenticationStatusJSONObject.put(ServletConstant.AUTHORITY, AuthorityEnumHelper.toString(authenticationStatusObject.getAuthority()));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return authenticationStatusJSONObject;
		
	}
}

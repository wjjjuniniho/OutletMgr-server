package tongji.sse.outletmanager.servlet.util;

import tongji.sse.outletmanager.datamodel.AuthorityEnum;

public class AuthorityEnumHelper {
	public static String toString(AuthorityEnum authorityEnum) {
		return authorityEnum.toString().toLowerCase();
	}
	
	public static AuthorityEnum toAuthorityEnum(String authority) {
		return AuthorityEnum.valueOf(authority.toUpperCase());
	}
}

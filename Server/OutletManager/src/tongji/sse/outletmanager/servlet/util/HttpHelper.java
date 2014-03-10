package tongji.sse.outletmanager.servlet.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

public class HttpHelper {
	/**
     * Accept Header
     */
    public static final String HEADER_ACCEPT = "Accept";

    /**
     * Cache-Control Header
     */
    public static final String CACHE_CONTROL_NAME = "Cache-Control";
    
    /**
     * Cache-Control max-age time
     */
    public static final String MAX_AGE_PATTERN = "max-age";

    /**
     * JSON type
     */
    public static final String JSON_TYPE = "application/json";

    /**
     * Content type
     */
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    
    /**
     * Content
     */
    public static final String CONTENT_TYPE = "application/json;charset=UTF-8";
    
    
    public static String getEntity(HttpServletRequest request) {
		StringBuffer entity = new StringBuffer();
		String stringLine = null;
		
		try {
			while((stringLine = request.getReader().readLine()) != null) {
				entity.append(stringLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return entity.toString();
    }
}

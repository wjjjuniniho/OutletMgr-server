package tongji.sse.outletmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import tongji.sse.outletmanager.database.util.MerchandiseCheckoutOrderDBHelper;
import tongji.sse.outletmanager.database.util.MerchandiseObjectDBHelper;
import tongji.sse.outletmanager.datamodel.MerchandiseCheckoutOrder;
import tongji.sse.outletmanager.datamodel.MerchandiseObject;
import tongji.sse.outletmanager.datamodel.StatusObject;
import tongji.sse.outletmanager.servlet.util.HttpHelper;
import tongji.sse.outletmanager.servlet.util.MerchandiseCheckoutHelper;
import tongji.sse.outletmanager.servlet.util.MerchandiseHelper;

public class MerchandiseCheckoutServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MerchandiseCheckoutServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = null;
		int statusCode = HttpStatus.SC_BAD_REQUEST;

		if (request.getHeader(HttpHelper.HEADER_CONTENT_TYPE).equals(
				HttpHelper.JSON_TYPE)) {
			String stringEntity = HttpHelper.getEntity(request);
			if (stringEntity != null) {
				MerchandiseCheckoutOrder order = MerchandiseCheckoutHelper.parse(stringEntity);
				if (order != null) {
					StatusObject statusObject = MerchandiseCheckoutOrderDBHelper.checkoutMerchandiseOrder(order);
					if (statusObject.isSuccessful()) {
						statusCode = HttpStatus.SC_CREATED;
					} else {
						statusCode = HttpStatus.SC_FORBIDDEN;
					}
				} else {
					statusCode = HttpStatus.SC_BAD_REQUEST;
				}
				
			} else {
				statusCode = HttpStatus.SC_BAD_REQUEST;
			}

		} else {
			statusCode = HttpStatus.SC_BAD_REQUEST;

		}

		response.setContentType(HttpHelper.JSON_TYPE);
		response.setCharacterEncoding("UTF-8");
		response.setStatus(statusCode);
		out = response.getWriter();
		out.flush();
		out.close();
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

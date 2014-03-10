package tongji.sse.outletmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONObject;

import tongji.sse.outletmanager.database.util.MerchandiseDetailObjectDBHelper;
import tongji.sse.outletmanager.database.util.MerchandiseDetailObjectListDBHelper;
import tongji.sse.outletmanager.database.util.StatisticsDetailObjectDBHelper;
import tongji.sse.outletmanager.datamodel.MerchandiseDetailObject;
import tongji.sse.outletmanager.servlet.util.HttpHelper;
import tongji.sse.outletmanager.servlet.util.MerchandiseDetailHelper;
import tongji.sse.outletmanager.servlet.util.MerchandiseDetailListHelper;

public class MerchandiseDetailServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MerchandiseDetailServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = null;
		int statusCode = HttpStatus.SC_BAD_REQUEST;
		JSONObject itemDetailJSONObject = null;

		if (request.getHeader(HttpHelper.HEADER_ACCEPT).equals(
				HttpHelper.JSON_TYPE)) {
			// String requestURL = HttpUtils.getRequestURL(request).toString();
			String storeId = null;
			String barcode = null;
			String query = request.getQueryString();
			List<NameValuePair> queryParamList = null;
			try {
				queryParamList = URLEncodedUtils.parse(new URI(request
						.getRequestURL().toString()
						+ "?" + query), HTTP.UTF_8);

			} catch (URISyntaxException e) {
				e.printStackTrace();
				response.setStatus(HttpStatus.SC_BAD_REQUEST);
				out = response.getWriter();
				out.flush();
				out.close();
			}
			if (queryParamList != null) {
				for (NameValuePair queryParam : queryParamList) {
					if (queryParam.getName().equals(ServletConstant.STOREID)) {
						storeId = queryParam.getValue();
					} else if (queryParam.getName().equals(
							ServletConstant.BARCODE)) {
						barcode = queryParam.getValue();
					}
				}

				if (storeId != null && !storeId.equals("") && barcode != null
						&& !barcode.equals("")) {
					MerchandiseDetailObject itemDetailObject = null;
					if (barcode.equals(ServletConstant.VALUE_BARCODE_ALL)) {
						itemDetailObject = StatisticsDetailObjectDBHelper
								.getStatisticsDetailObject(storeId);
					} else {
						itemDetailObject = MerchandiseDetailObjectDBHelper
								.getMerchandiseDetailObject(storeId, barcode);
					}
					if (itemDetailObject.isSuccessful()) {
						itemDetailJSONObject = MerchandiseDetailHelper
								.toJSONObject(itemDetailObject);

						statusCode = HttpStatus.SC_OK;
					} else {
						statusCode = HttpStatus.SC_NOT_FOUND;
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
		if (itemDetailJSONObject != null) {
			out.write(itemDetailJSONObject.toString());
		}
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
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
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

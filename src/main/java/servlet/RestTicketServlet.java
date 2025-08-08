package servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

/** Rest Ticket API
 * ----------------------
 * 單查 GET    /rest/ticket/1
 * 多查 GET	  /rest/ticket
 * 新增 POST   /rest/ticket
 * 修改 PUT	  /rest/ticket/1?price=35000
 * 刪除 DELETE /rest/ticket/1
 */
@WebServlet("/rest/ticket")
public class RestTicketServlet extends HttpServlet {
	
	
	
}



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public update() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String city=request.getParameter("city");
		out.print("<center><br><h1>Update Data To Database</h1><form action='update2' method='post'><table>");
		out.print("<input type='hidden' name='id' value="+id+" palceholder='id...' required>");
		out.print("<tr><th>Name : </th><td><input type='text' name='name' value="+name+" palceholder='name...' required></td></tr>");
		out.print("<tr><th>City : </th><td><input type='text' name='city' value="+city+" palceholder='city...' required></td></tr>");
		out.print("<tr><td><input type='submit' value='update'></td></tr>");	
		out.print("</table></form></center>");
	}

}

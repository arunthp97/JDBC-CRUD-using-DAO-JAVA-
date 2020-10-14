

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public delete() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		Crud_Operation crud_op=new Crud_Operation();
		Emp e=new Emp();
		e.setId(id);
		int res=crud_op.delete(e);
		if(res!=0)
		{
			out.print("<h3 align='center'> Data delete.</h3>");
			request.getRequestDispatcher("fetch").include(request, response);
		}
		else
		{
			out.print("<h3 align='center'> Failed to delete.</h3>");
			request.getRequestDispatcher("fetch").include(request, response);
		}
		
	}

}

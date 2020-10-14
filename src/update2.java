

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/update2")
public class update2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public update2() {
        super();
       
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String city=request.getParameter("city");
		Emp m=new Emp();
		m.setId(id);
		m.setName(name);
		m.setCity(city);
		Crud_Operation op=new Crud_Operation();
		int res=op.update(m);
		if(res!=0)
		{
			out.print("<h1>Success in update.</h1>");
			response.sendRedirect("fetch");
		}
		else
		{
			out.print("<h1>Failed to update.</h1>");
			request.getRequestDispatcher("fetch").include(request, response);
			
		}
		
	}

}

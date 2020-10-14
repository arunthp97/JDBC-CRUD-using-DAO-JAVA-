

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public insert() {
        super();
        // TODO Auto-generated constructor stub
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
		int res=op.insert(m);
		if(res!=0)
		{
			response.sendRedirect("fetch");
		}
		else
		{
			out.print("<h1>Failed.</h1>");
		}
		
	}

}

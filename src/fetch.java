

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/fetch")
public class fetch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public fetch() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Crud_Operation crud_op=new Crud_Operation();
		List<Emp> list=crud_op.getAllData();
		if(list.isEmpty())
		{
			out.print("<h3 align='center'>No Record To Show.</h3>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		else
		{
			out.print("<center><a href='index.html'>Add Data</a><table>");
			out.print("<tr><th>ID</th><th>Name</th><th>City</th><th>Option 1</th><th>Option 2</th></tr>");
			for(Emp e:list)
			{
			out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getCity()+"</td><td><a href='update?id="+e.getId()+"&name="+e.getName()+"&city="+e.getCity()+"'>Edit</a></td><td><a href='delete?id="+e.getId()+"'>Delete</a></td></tr>");
			}
			out.print("</table>");
		}
		
	}

}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Crud_Operation {
	Connection con=CRUD_Connection.getCon();
	public int insert(Object o)
	{
		Emp m=(Emp)o;
		int status=0;
		try
		{
			PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)");
			ps.setInt(1, m.getId());
			ps.setString(2, m.getName());
			ps.setString(3, m.getCity());
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public int update(Object o)
	{
		Emp m=(Emp)o;
		int status=0;
		try
		{
			PreparedStatement ps=con.prepareStatement("update student set name=?,city=? where roll=?");
			ps.setInt(3, m.getId());
			ps.setString(1, m.getName());
			ps.setString(2, m.getCity());
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public int delete(Object o)
	{
		Emp m=(Emp)o;
		int status=0;
		try
		{
			PreparedStatement ps=con.prepareStatement("delete from student where roll=?");
			ps.setInt(1, m.getId());
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public List<Emp> getAllData()
	{
		List<Emp> list=new ArrayList<Emp>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from student");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String city=rs.getString(3);
				Emp e=new Emp(id,name,city);
				list.add(e);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}

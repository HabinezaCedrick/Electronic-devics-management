import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class delete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String b=request.getParameter("tin");
        int y;
        try{   
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicdevice","root","");
            Statement st=con.createStatement(); 
            y=st.executeUpdate("delete From products where tin='"+b+"'");
            if(y==1)
            {
                out.print("deleted successfully");
                request.getRequestDispatcher("views").include(request, response);
            }
            }catch(IOException | SQLException | ServletException e)
            {
            throw new Error(e);
            }
        }
    }
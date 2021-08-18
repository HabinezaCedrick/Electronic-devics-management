import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class signup extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String n=request.getParameter("name");
        String e=request.getParameter("email");
        String po=request.getParameter("post");
        String p=request.getParameter("password");
        
        
        try {
          DriverManager.registerDriver(new com.mysql.jdbc.Driver());
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicdevice","root","");
          String query="INSERT into users values(?,?,?,?)";
          PreparedStatement st=con.prepareStatement(query);
          st.setString(1, n);
          st.setString(2, e);
          st.setString(3, po);
          st.setString(4, p);
          
          
          int x=st.executeUpdate();
          if(x==1){
          out.println("Account was created Successfully");
          request.getRequestDispatcher("loginout.html").include(request, response);
          }
          else {
              out.println("Passwords error");
              //request.getRequestDispatcher("Admin.jsp").include(request, response);
            }
        }catch(IOException | SQLException | ServletException ex){
            throw new Error(ex);
            }
        }
    }
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class signin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String e = request.getParameter("email");
        String p = request.getParameter("password");
        try (PrintWriter out = response.getWriter()) {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicdevice","root","");
        PreparedStatement st= con.prepareStatement("SELECT * From users where email=? AND password=? ");
         st.setString(1, e);
        st.setString(2, p);
        ResultSet rst=st.executeQuery();
       
        if(rst.next()){
        String post=rst.getString("post");
        if(post.equals("admin")){
        response.sendRedirect("index.html");
        }
        else{
        response.sendRedirect("indexx.html");
        }
        }
        else{
        out.println("Wrong Username or Password");
        request.getRequestDispatcher("loginout.html").include(request, response);
        
        }
        }catch(Exception exp){
        throw new Error(exp);
        }
    }

   
}
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
              String t=request.getParameter("tin");
              String np=request.getParameter("nameofproduct");
              String a=request.getParameter("amount");
              String q=request.getParameter("quantity");
              String d=request.getParameter("date");
              String ex=request.getParameter("expired");
              String c=request.getParameter("color");
              String ql=request.getParameter("quality");
              String s=request.getParameter("supplier");
       try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicdevice","root","");
          Statement st = con.createStatement();
   st.executeUpdate("UPDATE products set tin='" + t + "',nameofproduct='" + np + "',amount='" + a + "',quantity='" + q + "',date='" + d + "',expired='" + ex + "',color='" + c + "',quality='" + ql + "',supplier='" + s + "' where tin= '" + t + "' ");
                     out.print("Updated Successfully");
               request.getRequestDispatcher("views").include(request, response);
                } catch (SQLException e) {
                    throw new Error(e);
                } catch (ClassNotFoundException ex1) { 
            Logger.getLogger(update.class.getName()).log(Level.SEVERE, null, ex1);
        } 
        }
}
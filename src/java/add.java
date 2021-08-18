import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class add extends HttpServlet {

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
          String query="INSERT into products values(?,?,?,?,?,?,?,?,?)";
          PreparedStatement st=con.prepareStatement(query);
          
          st.setString(1, t);
          st.setString(2, np);
          st.setString(3, a);
          st.setString(4, q);
          st.setString(5, d);
          st.setString(6, ex);
          st.setString(7, c);
          st.setString(8, ql);
          st.setString(9, s);
          
          int x=st.executeUpdate();
          if(x==1){
          out.println("Recorded Successfully");
          request.getRequestDispatcher("devices.html").include(request, response);
          }
          else{
              out.println("not Recorded");
            }
        }catch(IOException | SQLException | ServletException e){
            throw new Error(e);
            } catch (ClassNotFoundException ex1) { 
            Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex1);
        } 
        }
    }

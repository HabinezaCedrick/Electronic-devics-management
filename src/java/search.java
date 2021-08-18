          
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class search extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out =response.getWriter();
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        String search=request.getParameter("search");
        int count=0;
        
      try{ 
         
           Class.forName("com.mysql.jdbc.Driver");   
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicdevice","root","");   
           stmt=con.createStatement();          
           rs=stmt.executeQuery("select * from products where tin='"+search+"'");
           
           
            out.println("<html lang=\"en\">\n" +
"  <head>\n" +
"  	<title>Display</title>\n" +
"    <meta charset=\"utf-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
"\n" +
"	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>\n" +
"\n" +
"	<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
"	\n" +
"	<link rel=\"stylesheet\" href=\"csstb/style.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"cssa/bootstrap.min.css\">"+
      "<link rel=\"stylesheet\" href=\"cssa/style.css\">"+
      "<link rel=\"stylesheet\" href=\"cssa/responsive.css\">"+
      "<link rel=\"stylesheet\" href=\"cssa/jquery.mCustomScrollbar.min.css\">"+
      "<link rel=\"stylesheet\" href=\"cssa/owl.carousel.min.css\">"+
      "<link rel=\"stylesheet\" href=\"cssa/owl.theme.default.min.css\">"+
"\n" +
"	</head>\n" +
"	<body>\n" +
"	<section class=\"ftco-section\">\n" +
"		<div class=\"container\">\n" +
"			<div class=\"row justify-content-center\">\n" +
"				<div class=\"col-md-6 text-center mb-5\">\n" +
"				</div>\n" +
"			</div>\n" +
"			<div class=\"row\">\n" +
"				<div class=\"col-md-12\">\n" +
"					<h4 class=\"text-center mb-4\">ALL RECORDS</h4>\n" +
"					<div class=\"table-wrap\">\n" +
"						<table class=\"table\">\n" +
"					    <thead class=\"thead-primary\">\n" +
"					      <tr>\n" +
"					        <th>TIN</th>\n" +                    
"					        <th>NAME OF PRODUCT</th>\n" +
"					        <th>AMOUNT</th>\n" +
"					        <th>QUANTITY</th>\n" +
"					        <th>DATE</th>\n" +
"					        <th>EXPIRED</th>\n" +
"                                                <th>COLOR</th>\n" +
"                                                <th>QUALITY</th>\n" +
"                                                 <th>SUPPLIER</th>\n" +                 
"                                                <th colspan='2'>ACTIONS</th>\n" +                    
"					      </tr>\n" +
"					    </thead>\n" );
            while(rs.next()){
                    out.println("<body>\n" +
"					      <tr>\n" );
                    
out.println("<td>"+rs.getString(1)+"</td>\n" +
"					        <td>"+rs.getString(2)+"</td>\n" +
"					        <td>"+rs.getString(3)+"</td>\n" +
"					        <td>"+rs.getString(4)+"</td>\n" +
"					        <td>"+rs.getString(5)+"</td>\n" +
"					        <td>"+rs.getString(6)+"</td>\n" +
        "					<td>"+rs.getString(7)+"</td>\n" +
                "		                <td>"+rs.getString(8)+"</td>\n" +
"					        <td>"+rs.getString(9)+"</td>\n");
out.print("<td>"+"<a class=\"btn btn-primary\" href='edit?tin="+rs.getString("tin")+"'>"+"EDIT"+"</a>"+ "</td>");
out.print("<td>"+"<a class=\"btn btn-primary\" href='delete?tin="+rs.getString("tin")+"'>"+"DELETE"+"</a>"+ "</td>");

                  
		out.println(" </tr>\n" +					      
"					    </tbody>\n" );
                            }
            				out.println("  </table>\n" +
"					</div>\n" +
"				</div>\n" +
"			</div>\n" +
"		</div>\n" +
"	</section>\n" +
"\n" +
"	<script src=\"js/jquery.min.js\"></script>\n" +
"  <script src=\"js/popper.js\"></script>\n" +
"  <script src=\"js/bootstrap.min.js\"></script>\n" +
"  <script src=\"js/main.js\"></script>\n" +
"\n" );
            out.println("<div class=\"button_section\"> <a class=\"main_bt\" href=\"index.html\" style=\"font:600 18px/20px 'Open Sans',sans-serif;\">RETURN</a>  </div>");
            out.println("</body>");
            out.println("</html>");
        }
         catch(ClassNotFoundException | SQLException e){
                        throw new 
                        ServletException("servlet coul not dispay record." + e);
                                             }
    }

}

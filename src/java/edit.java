import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class edit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
              String t=request.getParameter("tin");
              String np="";
              String a="";
              String q="";
              String d="";
              String ex="";
              String c="";
              String ql="";
              String s="";
                 
          try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/electronicdevice","root","");
            PreparedStatement ps=con.prepareStatement( "select * from products where tin='"+t+"'");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
               np=rs.getString("nameofproduct");
               a=rs.getString("amount");
               q=rs.getString("quantity");
               d=rs.getString("date"); 
               ex=rs.getString("expired"); 
               c=rs.getString("color"); 
               ql=rs.getString("quality"); 
               s=rs.getString("supplier"); 
                        
                       }
            out.print("<title>electronic</title>\n" +
"	<link href=\"https://fonts.googleapis.com/css?family=PT+Sans:400\" rel=\"stylesheet\">\n" +
"	<link type=\"text/css\" rel=\"stylesheet\" href=\"cssb/bootstrap.min.css\" />\n" +
"	<link type=\"text/css\" rel=\"stylesheet\" href=\"cssb/style.css\" />");
            out.print("<div id=\"booking\" class=\"section\">\n" +
"		<div class=\"section-center\">\n" +
"			<div class=\"container\">\n" +
"				<div class=\"row\">\n" +
"					<div class=\"booking-form\">\n" +
"                                            <form action=\"update\" method=\"post\">\n" +
                    
                                      
"							<div class=\"row\">\n" +
"								<div class=\"col-md-6\">\n" +
"									<div class=\"form-group\">\n" +
"										<span class=\"form-label\">Tin Number</span>\n" +
"										<input class=\"form-control\" type=\"text\" name=\"tin\" value='"+t+"' placeholder=\"tin number\" required>\n" +
"									</div>\n" +
"								</div>\n" +
"								<div class=\"col-md-6\">\n" +
"									<div class=\"form-group\">\n" +
"										<span class=\"form-label\">Name of Product</span>\n" +
"                                                                                <input class=\"form-control\" type=\"text\" name=\"nameofproduct\" value='"+np+"' placeholder=\"Product name\" required>\n" +
"									</div>\n" +
"                                                                    \n" +
"								</div>\n" +
"                                                            <div class=\"row\">\n" +
"								<div class=\"col-md-6\">\n" +
"									<div class=\"form-group\">\n" +
"										<span class=\"form-label\">Amount</span>\n" +
"										<input class=\"form-control\" type=\"text\" name=\"amount\" value='"+a+"' placeholder=\"amount\" required>\n" +
"									</div>\n" +
"								</div>\n" +
"								<div class=\"col-md-6\">\n" +
"									<div class=\"form-group\">\n" +
"										<span class=\"form-label\">Quantity</span>\n" +
"                                                                                <input class=\"form-control\" type=\"text\" name=\"quantity\" value='"+q+"' placeholder=\"quantity\" required>\n" +
"									</div>\n" +
"                                                                    \n" +
"								</div>\n" +
"							</div>\n" +
"							<div class=\"row\">\n" +
"								<div class=\"col-md-3\">\n" +
"									<div class=\"form-group\">\n" +
"										<span class=\"form-label\">Date</span>\n" +
"										<input class=\"form-control\" type=\"date\" name=\"date\" value='"+d+"' required>\n" +
"									</div>\n" +
"								</div>\n" +
"								<div class=\"col-md-3\">\n" +
"									<div class=\"form-group\">\n" +
"										<span class=\"form-label\">Expired</span>\n" +
"										<input class=\"form-control\" type=\"date\" name=\"expired\" value='"+ex+"' required>\n" +
"									</div>\n" +
"								</div>\n" +
"								<div class=\"col-md-3\">\n" +
"									<div class=\"form-group\">\n" +
"										<span class=\"form-label\">Color</span>\n" +
"										<select class=\"form-control\" name=\"color\" value='"+c+"'>\n" +
"											<option>Blue</option>\n" +
"											<option>Bleck</option>\n" +
"											<option>White</option>\n" +
"										</select>\n" +
"										<span class=\"select-arrow\"></span>\n" +
"									</div>\n" +
"                                                                    \n" +
"								</div>\n" +
"								<div class=\"col-md-3\">\n" +
"									<div class=\"form-group\">\n" +
"										<span class=\"form-label\">Quality</span>\n" +
"										<select class=\"form-control\" name=\"quality\" value='"+ql+"' >\n" +
"											<option>High Quality</option>\n" +
"											<option>Low Quality</option>\n" +
"											<option>Poor Quality</option>\n" +
"										</select>\n" +
"										<span class=\"select-arrow\"></span>\n" +
"									</div>\n" +
"								</div>\n" +
"							</div>\n" +
"							<div class=\"row\">\n" +
"								<div class=\"col-md-6\">\n" +
"									<div class=\"form-group\">\n" +
"										<span class=\"form-label\">Supplier</span>\n" +
"										<select class=\"form-control\" name=\"supplier\" value='"+s+"'>\n" +
"											<option>HABINEZA Cedrick</option>\n" +
"											<option>RUDASINGWA Mike</option>\n" +
"                                                                                        <option>TUYISHIME Fulgence</option>\n" +
"											<option>KWIZERA Patrick</option>\n" +
"										</select>\n" +
"										<span class=\"select-arrow\"></span>\n" +
"									</div>\n" +
"								</div>\n" +
"								\n" +
"                                                            <div class=\"col-md-3\">\n" +
"									<div class=\"form-btn\">\n" +
"										<button class=\"submit-btn\">Update Now</button>\n" +
"									</div>\n" +
"                                                                    \n" +
"								</div>\n" +
"                                                            <div class=\"col-md-3\">\n" +
"									<div class=\"form-btn\">\n" +
"                                                                            <button class=\"submit-btn\"><a class=\"submit-btn\" href=\"index.html\">Home</a></button>\n" +
"									</div>\n" +
"                                                                    \n" +
"								</div>\n" +
"							</div>\n" +
"						</form>\n" +
"					</div>\n" +
"				</div>\n" +
"			</div>\n" +
"		</div>\n" +
"	</div>\n" +
"    \n" +
"</body>\n" +
"\n" +
"</html>\n" +
"");
            
          }catch(SQLException e)
          {
              throw new Error(e);
          }
    }
}
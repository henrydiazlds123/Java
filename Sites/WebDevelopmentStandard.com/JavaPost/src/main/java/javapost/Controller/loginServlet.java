package javapost.Controller;
/**
 * author: Henry Diaz - CS313
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javapost.Model.loginModel;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
		request.getRequestDispatcher("/login.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
            response.setContentType("text/html");    
            PrintWriter out = response.getWriter();    
          
            String username = request.getParameter("txtUsername");    
            String userpass = request.getParameter("txtUserpass");   

            HttpSession session = request.getSession(false);  
            if(session!=null)  
            session.setAttribute("name", username);  

            if(loginModel.validate(username, userpass)){
                RequestDispatcher rd=request.getRequestDispatcher("addNewPost.jsp");    
                rd.forward(request,response);    
            }    
            else{    
                out.print("<p style=\"color:red\">Sorry username or password incorrect.</p>");    
                RequestDispatcher rd=request.getRequestDispatcher("invalidLogin.jsp");    
                rd.include(request,response);    
            }    

            out.close();    
        }

}

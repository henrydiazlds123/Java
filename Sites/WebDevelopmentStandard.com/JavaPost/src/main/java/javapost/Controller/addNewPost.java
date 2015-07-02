package javapost.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javapost.Model.addPost;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addNewPost
 */
@WebServlet("/addNewPost")
public class addNewPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addNewPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
       
        String postUser    = request.getParameter("username");
        String postContent = request.getParameter("txtNewPost");
        String postDate    = request.getParameter("txtDate");
        
        addPost.insert(postUser, postContent, postDate);
        
        RequestDispatcher rd=request.getRequestDispatcher("/viewPost");    
        rd.forward(request,response);    
     
        
        out.print(postContent);
        out.close();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		


}
}
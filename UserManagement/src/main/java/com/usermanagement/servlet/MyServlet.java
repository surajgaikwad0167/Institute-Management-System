package com.usermanagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usermanagement.bean.Admin;
import com.usermanagement.bean.UserBean;
import com.usermanagement.dao.Dao;
 
@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 PrintWriter out = null;
   
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String path = request.getServletPath();
		 
		 switch(path)
		 {
		 case "/validate": getLogIn(request,response);
		 break;
		 case "/add": getAddUserForm(request,response);
		 break;
		 case "/list":displayUser(request,response);
		 break;
		 case "/insert":insertuser(request,response);
		 break;
		 case "/delete": deleteUser(request,response);
		 break;
		 case "/edit": selectUserById(request,response);
		 break;
		 case "/update": updateUser(request,response);
		 break;
		 default : getAdminLoginPage(request,response);
		 }
	}

	 
	private void updateUser(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		
		UserBean u = new UserBean(id, name, email, city);
		Dao.update(u);
		 try {
				response.sendRedirect("list");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}


	private void selectUserById(HttpServletRequest request, HttpServletResponse response) {
		 int id = Integer.parseInt(request.getParameter("id"));
		 UserBean u = Dao.selectUser(id);
		 request.setAttribute("user", u);
		RequestDispatcher rd =request.getRequestDispatcher("UserForm.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		 int id = Integer.parseInt(request.getParameter("id"));
		 Dao.delete(id);
		 try {
			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void insertuser(HttpServletRequest request, HttpServletResponse response) {
		 String name = request.getParameter("name");
		 String email = request.getParameter("email");
		 String city = request.getParameter("city");
		 
		 UserBean u = new UserBean(name, email, city);
		 int count = Dao.insert(u);
		 if(count>0)
		 {
			 try {
				response.sendRedirect("list");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 else
		 {
			 response.setContentType("text/html");
			  try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 out.print("<h1><center>User already exist</center></h1><br>");
		 }
		 
		
	}


	private void displayUser(HttpServletRequest request, HttpServletResponse response) {
		
		  ArrayList<UserBean> al = Dao.display();
			 request.setAttribute("userlist", al);

		  RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
		  try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
	}


	private void getAddUserForm(HttpServletRequest request, HttpServletResponse response) {
		 
		  RequestDispatcher rd = request.getRequestDispatcher("UserForm.jsp");
		  try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void getLogIn(HttpServletRequest request, HttpServletResponse response) {
		 String user= request.getParameter("name");
		 String pass= request.getParameter("pass");
		 Admin a = new Admin(user, pass);
		 String status = Dao.doMatch(a);
		 if(status.equals("successful"))
		 {
			 try {
				response.sendRedirect("list");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 else
		 {
			 response.setContentType("text/html");
			  try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 out.print("<h1><center>Wrong Credentials</center></h1><br><br>");
			 out.print("<center><a href=\"LogIn.jsp\";>Go back to the Login page</a></center>");
		 }
		 
		
	}


	private void getAdminLoginPage(HttpServletRequest request, HttpServletResponse response) {
		 try {
			response.sendRedirect("LogIn.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

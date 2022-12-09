package com.journaldev.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PokerServlet
 */
@WebServlet(description = "My First Servlet", urlPatterns = { "/PokerServlet" , "/PokerServlet.do"}, initParams = {@WebInitParam(name="id",value="1"),@WebInitParam(name="name",value="pankaj")})

public class PokerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String HTML_START="<html><body>";
	public static final String HTML_END="</body></html>";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PokerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    String b;
    String card0;
    String card1;
    String card2;
    String card3;
    String card4;
    String card5;
    int numBots;
    int chips;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//gets the value of an input with the name startButton
		String a = request.getParameter("button");
		
		//can use a conditional statement to decipher which input was accessed, and run java code based off of this.
		//This is how we will run the game, we will just call the other java files in the conditional statements.
		//There should not be any business logic in here, since this is the Controller part of our MVC
		if(a.equals("Start")) {
			PokerMain.startGame();
			card1 = PokerMain.imageSourceList.get(0);
			card2 = PokerMain.imageSourceList.get(1);
			card3 = PokerMain.imageSourceList.get(2);
			card4 = PokerMain.imageSourceList.get(3);
			card5 = PokerMain.imageSourceList.get(4);
			request.setAttribute("card1", card1);
			request.setAttribute("card2", card2);
			request.setAttribute("card3", card3);
			request.setAttribute("card4", card4);
			request.setAttribute("card5", card5);
			request.getRequestDispatcher("PokerMain.jsp").forward(request, response);
		}
		if(a.equals("Start Game")) {
			chips = Integer.parseInt(request.getParameter("startingChips"));
			numBots = Integer.parseInt(request.getParameter("numBots"));
			PokerMain.startingChips = chips;
			PokerMain.numBots = numBots;
			
			request.setAttribute("chips", chips);
			request.setAttribute("numBots", numBots);
			request.getRequestDispatcher("PokerMain.jsp").forward(request, response);
			
		}
		
		//sets an attribute of your choosing to a value. Can get this attribute in the jsp to create a change with the java code
		
		
		//gets the file that made the request and sends a response back.
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String a = request.getParameter("startButton");
		
		if(a.equals("Start")) {
			b = "among us";
		} else {
			b = "among usssss";
		}
		
		request.setAttribute("us", b);
		
		request.getRequestDispatcher("PokerMain.jsp").forward(request, response);
		out.println(b);
	}	

}

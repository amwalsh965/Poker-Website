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

import com.google.gson.Gson;

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
    public static int numBots = Integer.parseInt(MySQLConfig.selectItem("num_bots", "game_info", "game_id", UpdateRules.gameId));
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Map <String, Object> map = new HashMap<String, Object>();
			PokerMain.startGame();
			ArrayList<String> imageSourceList = PokerMain.getImageSourceList();
			ArrayList<PokerBot> pokerBotList = PokerMain.getBotList();

			for(int j = 0; j < ((numBots * 2)+5); j++) {
				map.put("c"+(j+1), imageSourceList.get(j));
			}
			
			for(int i = 0; i < numBots; i++) {
				map.put("b" + (i+1),pokerBotList.get(i).getName());
				map.put("hId" + (i+1),pokerBotList.get(i).getHandId());
			}
			for(int i = numBots; i < 10; i++) {
				map.put("b" + (i+1), "0");
				map.put("hId" + (i+1), "0");
			}
			
			write(response, map);
	}	

	private void write(HttpServletResponse response, Map<String, Object> map) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(map));
	}
}

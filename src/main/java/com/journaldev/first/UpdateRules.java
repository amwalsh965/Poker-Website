package com.journaldev.first;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class UpdateRules
 */
@WebServlet("/UpdateRules")
public class UpdateRules extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRules() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public static String gameId = Integer.toString(MySQLConfig.getNextGameId() + 1);
    public static String currentTime = MySQLConfig.getCurrentTime();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map <String, Object> map = new HashMap<String, Object>();
		System.out.println("----------------------------------------------------------------------------------------------");
		String chips = request.getParameter("startingChips");
		String numBots = request.getParameter("numBots");
		String smallBlind = request.getParameter("smallBlind");
		String bigBlind = request.getParameter("bigBlind");
		currentTime = MySQLConfig.getCurrentTime();
		gameId = Integer.toString(MySQLConfig.getNextGameId() + 1);
		PokerMain.startingChips = Integer.parseInt(chips);
		PokerMain.numBots = Integer.parseInt(numBots);
		System.out.println("Num_bots = " + numBots);
		ArrayList<String> colv = new ArrayList<String>(List.of(gameId, currentTime, "2022-02-15 14:30:45", "3", chips, numBots, smallBlind, bigBlind));
		System.out.println("Current Id Number: " + gameId);
		System.out.println("Current Timestamp: " + currentTime);
		ArrayList<String> coln = new ArrayList<String>(List.of("game_id", "start_time", "end_time", "players", "starting_chips", "num_bots", "small_blind", "big_blind"));
		
		MySQLConfig.addRow(colv, coln,"game_info");
		write(response, map);
}	

   private void write(HttpServletResponse response, Map<String, Object> map) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(map));
   }
}

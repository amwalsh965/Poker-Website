package com.journaldev.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class PlayerDecisions
 */
@WebServlet("/PlayerDecisions")
public class PlayerDecisions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerDecisions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Map <String, Object>map = new HashMap<String, Object>();
		    BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		    String jsonString = "";
		    if(br != null){
		        jsonString = br.readLine();
		    }
		    JSONObject jsonObject = new JSONObject(jsonString);
		    String decision = jsonObject.getString("buttonValue");
		    String playersInHand = jsonObject.getString("playersInHand");
		    if(decision.equals("Bet")) {
		        String betAmount = jsonObject.getString("bettingAmount");
		        map.put("betAmount", betAmount);
		    } 
		    
		    if(decision.equals("Fold") && Integer.parseInt(playersInHand) == 2) {
		    	/*
	    	 	winArray ArrayList<Object> = PokerMain.getWinner(pot, currentChips, player);
		    	 map.put("winningChips", winArray.get(1));
		    	 */
		    }
		    map.put("decision", decision);
		    write(response, map);
	}

	private void write(HttpServletResponse response, Map<String, Object> map) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		response.getWriter().write(gson.toJson(map));
	}
}

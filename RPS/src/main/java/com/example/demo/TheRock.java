package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheRock {

	@RequestMapping(value = "/score/ties", method = RequestMethod.GET)
	public int getTies() {
		return ScoreBean.TIES;

	}

	@RequestMapping(value = "/score", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String score(String player1, String player2) {

		GameLogic.Players(player1, player2);
		String score = player1 + " " + player2;
		return (GameLogic.Players(player1, player2) + " " + score + " " + GameLogic.player1Score + " "
				+ GameLogic.player2Score);
	}

	@RequestMapping(value = "/score/wins", method = RequestMethod.POST)
	public int increaseWins() {
		ScoreBean.WINS++;
		return ScoreBean.WINS;

	}

	@RequestMapping(value = "/score/ties", method = RequestMethod.POST)
	public int increasTies() {
		ScoreBean.TIES++;
		return ScoreBean.TIES;

	}

	@RequestMapping(value = "/score", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getScoreBean() {

		String pattern = "{ 'winner':'%s', 'losses':\"%s\", \"ties\": \"%s\"}";
		return String.format(pattern, ScoreBean.WINS, ScoreBean.LOSSES, ScoreBean.TIES);

	}

	@RequestMapping(value = "/score", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public String update(int wins, int losses, int ties) {
		ScoreBean.WINS = wins;
		ScoreBean.LOSSES = losses;
		ScoreBean.TIES = ties;
		String pattern = "{ 'wins':'%s', 'losses':'%s', 'ties': '%s'}";
		return String.format(pattern, ScoreBean.WINS, ScoreBean.LOSSES, ScoreBean.TIES);
	}

}

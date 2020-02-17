package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameLogic {

	static int stateRock = 1;
	static int statePaper = 2;
	static int stateScissor = 3;

	static int player1 = 0;
	static int player2 = 0;
	static boolean Player1ready = false;
	static boolean Player2ready = false;

	static int gameRound = 1;
	static int player1Score = 0;
	static int player2Score = 0;

	public static String Players(String INplayer1, String INplayer2) {

		if (INplayer1.equals(INplayer2)) {
			return ("Tie");

		} else if (INplayer1.equals("rock")) {
			if (INplayer2.equals("scissor")) {
				player1Score++;
				return ("Player1 win");
			} else {
				player2Score++;
				return ("Player2 win");
			}

		}

		if (INplayer1.equals(INplayer2)) {
			return ("Win");

		} else if (INplayer1.equals("paper")) {
			if (INplayer2.equals("rock")) {
				player1Score++;
				return ("Player1 win");
			} else {
				player2Score++;
				return ("Player2 win");
			}

		}

		else if (INplayer1.equals("scissor")) {
			if (INplayer2.equals("paper")) {
				player1Score++;
				return ("Player1 win");
			} else {
				player2Score++;
				return ("Player2 win");
			}

		}

		gameRound++;
		Player1ready = false;
		Player2ready = false;

		return ("Error");

	}

}

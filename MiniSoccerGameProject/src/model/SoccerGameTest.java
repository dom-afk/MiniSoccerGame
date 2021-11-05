package model;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import model.players.GamePlayer;
import model.players.Goalkeeper;
import model.players.PlayerCollection;
import model.players.Striker;

/*
 * @author Misato
 */
public class SoccerGameTest {

	@Test
	public void getTimeRemainingTest() {
		SoccerGame soccerGame1 = new SoccerGame();
		SoccerGame soccerGame2 = new SoccerGame();
		Random rand = new Random();
		Integer remain = rand.nextInt(61); // from 0 to 60
		soccerGame2.setTimeRemaining(remain);
		
		assertEquals(60, soccerGame1.getTimeRemaining());
		assertEquals(remain, soccerGame2.getTimeRemaining());
	}

	@Test
	public void getGoalCountTest() {
		SoccerGame soccerGame1 = new SoccerGame();
		SoccerGame soccerGame2 = new SoccerGame();
		Random rand = new Random();
		Integer newCount = rand.nextInt(11); // from 0 to 10
		soccerGame2.setGoal(newCount);
		
		assertEquals(0, soccerGame1.getGoal());
		assertEquals(newCount, soccerGame2.getGoal());
	}
	
	@Test
	public void isPausedTest() {
		SoccerGame soccerGame1 = new SoccerGame();
		SoccerGame soccerGame2 = new SoccerGame();
		
		soccerGame2.setPaused(true);
		
		assertEquals(false, soccerGame1.isPaused());
		assertEquals(true, soccerGame2.isPaused());
	}
	
	@Test
	public void isOverTest() {
		SoccerGame soccerGame1 = new SoccerGame();
		SoccerGame soccerGame2 = new SoccerGame();
		
		soccerGame2.setOver(true);
		
		assertEquals(false, soccerGame1.isOver());
		assertEquals(true, soccerGame2.isOver());
	}
	
	@Test
	public void automateGoalKeeperTest() {
		SoccerGame soccerGame = new SoccerGame();
		GamePlayer goalkeeper = soccerGame.getGamePlayers().get("Goalkeeper");
		goalkeeper.setInitialPosition();
		
		Point initial = goalkeeper.getPlayerPosition();
		Point ballOnKeeperSide = new Point(100, 100); // On keeper's side
		SoccerBall.getSoccerBall().setPosition(ballOnKeeperSide);
		soccerGame.automateGoalkeeper();
		boolean statUpdated = goalkeeper.getPlayerStatistics() > 0 ? true : false;
		
		Point ballNotOnKeeperSide = new Point(100, 300); // Outside of the keeper's side
		SoccerBall.getSoccerBall().setPosition(ballNotOnKeeperSide);
		soccerGame.automateGoalkeeper();
		boolean keeperMoved = initial.x != goalkeeper.getPlayerPosition().x ? true : false;
		
		assertTrue(statUpdated);
		assertTrue(keeperMoved);
	}

	@Test
	public void isScoredTest() {
		SoccerGame soccerGame = new SoccerGame();
		
		Point ballInGate = new Point(300, 30);
		SoccerBall.getSoccerBall().setPosition(ballInGate);
		
		assertEquals(true, soccerGame.isScored());
	}
	
	@Test
	public void getActivePlayerTest() {
		SoccerGame soccerGame = new SoccerGame();
		
		assertEquals("Striker", soccerGame.getActivePlayer().getPlayerName());
	}
}

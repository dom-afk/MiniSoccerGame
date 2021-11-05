package model;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import model.players.GamePlayer;
import model.players.GamePlayerTest;
import model.players.Goalkeeper;
import model.players.PlayerCollection;
import model.players.PlayerCollectionIterator;
import model.players.PlayerCollectionIteratorTest;
import model.players.PlayerCollectionTest;
import model.players.PlayerFactoryTest;
import model.players.PlayerStatistics;
import model.players.PlayerStatisticsTest;
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
		soccerGame.automateGoalkeeper();
		boolean keeperMoved = initial.x != goalkeeper.getPlayerPosition().x ? true : false;
		
		assertTrue(statUpdated);
		assertTrue(keeperMoved);
	}

	@Test
	public void isScoredTest() {
		SoccerGame soccerGame = new SoccerGame();
		GamePlayer striker = soccerGame.getActivePlayer();
		GamePlayer goalkeeper = soccerGame.getGamePlayers().get("Goalkeeper");
		
		Point ballInGate = new Point(300, 30);
		SoccerBall.getSoccerBall().setPosition(ballInGate);
		striker.setPlayerStatistics(1);
		
		assertEquals(true, soccerGame.isScored());
		assertTrue(striker.compareTo(goalkeeper) < 0);
	}
	
	@Test
	public void getActivePlayerTest() {
		SoccerGame soccerGame = new SoccerGame();
		GamePlayer player = soccerGame.getActivePlayer();
		player.setPlayerPosition(new Point(10, 400));
		SoccerBall.getSoccerBall().setPosition(new Point(300, 400));
		player.grabsBall();
		
		assertEquals("Striker", player.getPlayerName());
		assertTrue(player.getPlayerColor().equals(Color.RED));
		assertEquals(30, SoccerBall.getSoccerBall().getPosition().x);
		assertEquals(455, SoccerBall.getSoccerBall().getPosition().y);
	}
	
	@Test
	public void playerMovementTest() {
		SoccerGame soccerGame = new SoccerGame();
		Point playerInitial = new Point(500, 450);
		Point keeperInitial = new Point(280, 70);
		Point ballInitial = SoccerBall.getSoccerBall().getPosition();
		
		soccerGame.getActivePlayer().moveUp();
		soccerGame.getActivePlayer().moveLeft();
		soccerGame.getActivePlayer().moveRight();
		soccerGame.getActivePlayer().moveUp();
		soccerGame.getActivePlayer().moveDown();
		
		soccerGame.getActivePlayer().shootBall();
		
		soccerGame.getGamePlayers().get("Goalkeeper").moveRight();
		soccerGame.getGamePlayers().get("Goalkeeper").moveUp();
		soccerGame.getGamePlayers().get("Goalkeeper").moveDown();
		soccerGame.getGamePlayers().get("Goalkeeper").moveRight();
		soccerGame.getGamePlayers().get("Goalkeeper").moveLeft();
		
		boolean playerMoveUpdated = soccerGame.getActivePlayer().getPlayerPosition().equals(playerInitial) ? false : true;
		boolean keeperMoveUpdated = soccerGame.getGamePlayers().get("Goalkeeper").getPlayerPosition().equals(keeperInitial) ? false : true;
		boolean ballMoveUpdated = SoccerBall.getSoccerBall().getPosition().equals(ballInitial) ? false : true;
		
		assertTrue(playerMoveUpdated);
		assertTrue(keeperMoveUpdated);
		assertTrue(ballMoveUpdated);
	}
	
	@Test
	public void playersIteratorTest() {
		SoccerGame soccerGame = new SoccerGame();
		Collection<GamePlayer> collection = new ArrayList<GamePlayer>();
		GamePlayer striker = new Striker("Striker", Color.RED);
		GamePlayer goalkeeper = new Goalkeeper("Goalkeeper", Color.BLACK);
		collection.add((GamePlayer) striker);
		collection.add((GamePlayer) goalkeeper);
		
		PlayerCollectionIterator itr1 = new PlayerCollectionIterator(collection);
		
		PlayerCollection plyCollection = new PlayerCollection();
		plyCollection.add(striker);
		plyCollection.add(goalkeeper);
		PlayerCollectionIterator itr2 = (PlayerCollectionIterator) plyCollection.iterator();

		boolean samePlayers = false;
		while (itr1.hasNext()) {
			if (itr1.next().getPlayerName().equals(itr2.next().getPlayerName())) {
				samePlayers = true;
			} else {
				samePlayers = false;
				break;
			}
		}
		
		PlayerCollectionIteratorTest test = new PlayerCollectionIteratorTest();
		test.constructorTest();
		assertTrue(samePlayers);
	}
	
	@Test
	public void playerStatisticsTest() {
		SoccerGame soccerGame = new SoccerGame();
		soccerGame.getActivePlayer().setPlayerStatistics(5);
		String points = soccerGame.getActivePlayer().getPlayerStatistics().toString();
		
		assertEquals("5", points);
	}
	
	@Test
	public void testAll() {
		getTimeRemainingTest();
		getGoalCountTest();
		isPausedTest();
		isOverTest();
		automateGoalKeeperTest();
		isScoredTest();
		getActivePlayerTest();
		playerMovementTest();
		playersIteratorTest();
		playerStatisticsTest();
	}
	
	@Test
	public void test() {
		GamePlayerTest test1 = new GamePlayerTest();
		test1.constructorTest();
		test1.updateStatisticsTest();
		
		PlayerFactoryTest test2 = new PlayerFactoryTest();
		test2.getPlayerFactoryTest();
		
		PlayerStatisticsTest test3 = new PlayerStatisticsTest();
		test3.testGetStatistic();
		test3.testToString();
		
		PlayerCollectionTest test4 = new PlayerCollectionTest();
		test4.getGamePlayerTest();
		test4.getCollectionOfGamePlayersTest();
	}
}

package uqac.aop.chess;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import uqac.aop.chess.agent.AiPlayer;
import uqac.aop.chess.agent.HumanPlayer;
import uqac.aop.chess.agent.Move;
import uqac.aop.chess.agent.Player;

public class Chess {

	protected Board board;

	public Chess() {

		board = new Board();
		board.setupChessBoard();

	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	


	private void play() {
		Player hp = new HumanPlayer(Player.BLACK, board);
		Player ap = new AiPlayer(Player.WHITE, board);

		while (true){
			board.print();
			hp.makeMove();
			board.print();
			ap.makeMove();				
		}
	}
	
	public void ecrire(String nomFic, String texte){
		String adressedufichier = System.getProperty("user.dir") + "/"+ nomFic; //On met le chemin et le nom du fichier dans un string
		
		try //On récupère les exceptions
		{
			FileWriter fw = new FileWriter(adressedufichier, true);
			BufferedWriter output = new BufferedWriter(fw);
			System.out.println("ecriture fichier");
			output.write(texte); //On écrit dans le BufferedWriter
	
			output.flush(); //On flush pour envoyer dans le fichier
			
			output.close(); //On ferme le flux
			
			System.out.println("fichier créé");
		}
		catch(IOException ioe){
			System.out.print("Erreur : ");
			ioe.printStackTrace();
			}

	}
	
	public static void main(String[] args) {
		new Chess().play();
	}
}

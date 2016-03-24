package uqac.aop.chess.agent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import uqac.aop.chess.Board;

public abstract class Player {
	public static final int WHITE = 1;
	public static final int BLACK = 0;
	
	protected int Colour;
	protected Board playGround;

	public abstract boolean makeMove(Move mv);
	public abstract Move makeMove();
	
	public int getColor(){
		return this.Colour;
	}
	public void setColor(int arg){
		this.Colour = arg;
	}
	
	public void ecrire(String nomFic, String texte){
		String adressedufichier = System.getProperty("user.dir") + "/"+ nomFic; //On met le chemin et le nom du fichier dans un string
		
		try //On récupère les exceptions
		{
			FileWriter fw = new FileWriter(adressedufichier, true);
			BufferedWriter output = new BufferedWriter(fw);
			
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
}

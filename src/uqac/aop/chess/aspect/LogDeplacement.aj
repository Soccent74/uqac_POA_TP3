package uqac.aop.chess.aspect;

public aspect LogDeplacement {
	pointcut logEcriture() : execution (void uqac.aop.chess.Chess.ecrire(String nomFic, String texte));
	
	after() : logEcriture(){
		ecrire(nomfichier,coup);
	}
}

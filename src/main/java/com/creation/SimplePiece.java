public class SimplePiece implements Piece {

	private String P;
	private Integer idPiece;
	private Integer idFormeNord;
	private Integer idFormeEst;
	private Integer idFormeSud;
	private Integer idFormeOuest;
	
	@Override
	public String toString() {
		return P + "(" + idPiece + ")";
	}
	
	public String getP(){
		return P;
	}
	
	public void setP(String P){
		this.P=P;
	}
	
	public Integer getIdPiece(){
		return idPiece;
	}
	
	public void setIdPiece(Integer idPiece){
		this.idPiece=idPiece;
	}
	
	public Integer getIdFormeNord() {
		return idFormeNord;
	}
	
	public void setIdFormeNord(Integer idFormeNord){
		this.idFormeNord=idFormeNord;
	}
	
	public Integer getIdFormeEst() {
		return idFormeEst;
	}
	
	public void setIdFormeEst(Integer idFormeEst){
		this.idFormeEst=idFormeEst;
	}
	
	public Integer getIdFormeSud() {
		return idFormeSud;
	}
	
	public void setIdFormeSud(Integer idFormeSud){
		this.idFormeSud=idFormeSud;
	}
	
	public Integer getIdFormeOuest() {
		return idFormeOuest;
	}
	
	public void setIdFormeOuest(Integer idFormeOuest){
		this.idFormeNord=idFormeOuest;
	}
}	
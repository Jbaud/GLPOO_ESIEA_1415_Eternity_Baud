public class SimpleFace implements Face {

	private String type;
	private Integer idFace;
	private String couleurFond;
	private String forme;
	private String couleurForme;
	
	@Override
	public String toString() {
		return forme + "(" + idFace + ")";
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(String type){
		this.type=type;
	}
	
	public Integer getIdFace(){
		return idFace;
	}
	
	public void setIdFace(Integer idFace){
		this.idFace=idFace;
	}
	
	public String getCouleurFond(){
		return couleurFond;
	}
	
	public void setCouleurFond(String couleurFond){
		this.couleurFond=couleurFond;
	}
	
	public String getForme(){
		return forme;
	}
	
	public void setForme(String forme){
		this.forme=forme;
	}
	
	public String getCouleurForme(){
		return couleurForme;
	}
	
	public void setCouleurForme(String couleurForme){
		this.couleurForme=couleurForme;
	}
	
}
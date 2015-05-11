public class CsvPieceDao1 implements PieceDao {

    private File file;
    private CsvFile csvFile;

    private CsvPieceDao1() {
        super();
    }

    public CsvPieceDao1(File file) {
        this();
        this.file = file;
        this.csvFile = new CsvFile01(file);
    }
	
	
@Override
public List<Piece> findAllPieces() {

    final List<Piece> pieces = new ArrayList<Piece>();

    final List<String[]> data = csvFile.getData();
    final List<String[]> dataSansTitre = data; // juste data
    dataSansTitre.remove(0);

    for(String[] oneData : dataSansTitre) {
        final Piece piece = tabToPiece(oneData);
        pieces.add(piece);
    }

    return pieces;
}

private Piece tabToPiece(String[] tab) {
    SimplePiece piece = new SimplePiece();

    piece.setP(tab[0]);
	piece.setIdPiece(Integer.parseInt(tab[1]));
    piece.setIdFormeNord(Integer.parseInt(tab[2]));
    piece.setIdFormeEst(Integer.parseInt(tab[3]));
	piece.setIdFormeSud(Integer.parseInt(tab[4]));
	piece.setIdFormeOuest(Integer.parseInt(tab[5]));

    return piece;
}

}
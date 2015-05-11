public class CsvFaceDao1 implements FaceDao {

    private File file;
    private CsvFile csvFile;

    private CsvFaceDao1() {
        super();
    }

    public CsvFaceDao1(File file) {
        this();
        this.file = file;
        this.csvFile = new CsvFile01(file);
    }
	
	
@Override
public List<Face> findAllFaces() {

    final List<Face> faces = new ArrayList<Face>();

    final List<String[]> data = csvFile.getData();
    final List<String[]> dataSansTitre = data; // juste data
    dataSansTitre.remove(0);

    for(String[] oneData : dataSansTitre) {
        final Face face = tabToFace(oneData);
        faces.add(face);
    }

    return faces;

}

private Face tabToFace(String[] tab) {
    SimpleFace face = new SimpleFace();

    face.setType(tab[0]);
    face.setIdFace(Integer.parseInt(tab[1]));
    face.setCouleurFond(tab[2]);
    face.setForme(tab[3]);
	face.setCouleurForme(tab[4]);

    return face;
}

}
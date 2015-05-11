public class CsvFile01 implements CsvFile {

    public final static char SEPARATOR = ',';

    private File file;
    private List<String> lines;
    private List<String[] > data;

    private CsvFile01() {
    }

    public CsvFile01(File file) {
        this.file = file;

        // Init
        init();
    }

    private void init() {
        lines = CsvFileHelper.readFile(file);

        data = new ArrayList<String[] >(lines.size());
        String sep = new Character(SEPARATOR).toString();
        for (String line : lines) {
            String[] oneData = line.split(sep);
            data.add(oneData);
        }
    }

    // GETTERS ...
    }
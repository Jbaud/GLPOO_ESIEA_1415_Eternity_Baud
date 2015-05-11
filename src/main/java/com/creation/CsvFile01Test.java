public class CsvFile01Test {

    private static final String FILE_NAME = "src/test/resources/chien-test-01.csv";
    private static File file;

    @BeforeClass
    public static void beforeClass() {
        file = CsvFileHelper.getResource(FILE_NAME);
    }

    @Test
    public void testFile() {

        // Appel
        final CsvFile csvFile = new CsvFile01(file);
        final File f = csvFile.getFile();

        // Test
        assertEquals(file, f);
    }

    @Test
    public void testCsvFile() {

        // Result
        final int nombreLigne = 11;

        // Appel
        final CsvFile01 csvFile01 = new CsvFile01(file);
        final List<String> lines = csvFile01.getLines();

        // Test
        assertEquals(nombreLigne, lines.size());
    }

    @Test
    public void testData() {

        // Result
        final int nombreLigne = 11;
        final int nombreColonnes = 4;

        // Appel
        final CsvFile csvFile = new CsvFile01(file);
        final List<String[] > data = csvFile.getData();

        // Test
        assertEquals(nombreLigne, data.size());

        for (String[] oneData : data) {
            assertEquals(nombreColonnes, oneData.length);
        }

    }
}
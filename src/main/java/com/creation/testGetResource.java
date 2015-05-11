//Test getResource sur Disque dur 
private final static String FILE_NAME = "src/test/resources/face-test-01.csv";

@Test
public void testGetResource() {
    // Param
    final String fileName = FILE_NAME;

    // Result
    // ...

    // Appel
    final File file = CsvFileHelper.getResource(fileName);

    // Test
    // On sait que le fichier existe bien puisque c'est avec lui qu'on travaille depuis le début.
    assertTrue(file.exists());
}
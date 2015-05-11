//test ReadFile
@Test
public void testReadFile() {
    // Param
    final String fileName = FILE_NAME;

    // Result
    final int nombreLigne = 11;

    // Appel
    final File file = CsvFileHelper.getResource(fileName);
    List<String> lines = CsvFileHelper.readFile(file);

    // Test
    Assert.assertEquals(nombreLigne, lines.size());
}
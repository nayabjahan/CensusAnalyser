
import com.main.CensusAnalyser;
import com.main.CensusAnalyserException;
import org.junit.jupiter.api.*;
import org.junit.rules.ExpectedException;
public class CensusAnalyserTest {
    private static final String INDIAN_CENSUS_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String INDIAN_STATE_CSV_FILE = "./src/main/resources/IndiaStateCode.csv";
    private static final String INDIAN_CENSUS_DELIMITER = "./src/main/resources/CensusDataIncorrectHeader.csv";
    private static final String INDIAN_STATE_CSV_WRONG_FILE = "./src/main/resources/IndiaStateCode.txt";
    private static final String INDIAN_CENSUS_CSV_WRONG_FILE = "./src/main/resources/census.abv";

    @Test
    public void givenIndianCensusCSVFile_Returns_CorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
            Assertions.assertEquals(11, numOfRecords);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndianCensusData_WithWrongFile_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
        }
    }
    @Test
    public void givenIndiaCodeData_WithWrongFileDelimiter_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_DELIMITER);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());

            Assertions.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_HEADER_OR_DELIMITER, e.type);
        }
    }
    @Test
    public void givenIndianCensusData_WithWrongFileType_ShouldThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.loadIndiaCensus(INDIAN_CENSUS_CSV_WRONG_FILE);
        } catch (CensusAnalyserException e) {
            System.out.println(e.getMessage());
            Assertions.assertEquals(CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE, e.type);
        }
    }
}

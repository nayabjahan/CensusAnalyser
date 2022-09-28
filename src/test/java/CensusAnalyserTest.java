
import com.main.CensusAnalyser;
import com.main.CensusAnalyserException;
import org.junit.jupiter.api.*;
public class CensusAnalyserTest {
    private static final String INDIAN_CENSUS_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String WRONG_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
    private static final String INDIAN_STATE_CSV_FILE = "./src/main/resources/IndiaStateCode.csv";
    private static final String INDIAN_CENSUS_DELIMITER = "./src/main/resources/IndiaStateCensusDataDelimiter.csv";
    private static final String INDIAN_STATE_CSV_WRONG_FILE = "./src/main/resources/IndiaStateCode.txt";
    private static final String INDIAN_CENSUS_CSV_WRONG_FILE = "./src/main/resources/census.abv";

    @Test
    public void givenIndianCensusCSVFile_Returns_CorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
            Assertions.assertEquals(29, numOfRecords);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
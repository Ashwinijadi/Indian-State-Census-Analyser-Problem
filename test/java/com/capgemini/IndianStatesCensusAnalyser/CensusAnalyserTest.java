package com.capgemini.IndianStatesCensusAnalyser;

import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest {
	private static final String INDIAN_CENSUS_CSV_FILE_PATH = "/eclipse-workspace/IndianStatesCensusAnalyser/src/"
			+ "test/java/com/capgemini/IndianStatesCensusAnalyser/IndianCensus/IndianCensus.csv";

	@Test
	public void givenIndianCensusCSVFileReturnsCorrectsRecords() throws Exception {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(29, numOfRecords);
		} catch (CensusAnalyserException e) {
		}

	}
}

package com.capgemini.IndianStatesCensusAnalyser;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
	private static final String INDIAN_CENSUS_CSV_FILE_PATH = "/eclipse-workspace/IndianStatesCensusAnalyser/src/"
			+ "main/java/com/capgemini/IndianStatesCensusAnalyser/IndianCensus/IndiaCensus.csv";
	private static final String INDIAN_CENSUS_WRONG_CSV_FILE_PATH = "/eclipse-workspace/IndianStatesCensusAnalyser/src/"
			+ "test/java/com/capgemini/IndianStatesCensusAnalyser/IndianCensus/IndianCensus.csv";
	private static final String INDIAN_CENSUS_WRONG_TYPE_CSV_FILE_PATH = "/eclipse-workspace/IndianStatesCensusAnalyser/src"
			+ "/main/java/capgemini/IndianStatesCensusAnalyser/IndianCensus/IndiaCensus.txt";
	private static final String INDIAN_CENSUS_WRONG_DELIMITER_CSV_FILE_PATH = "/eclipse-workspace/IndianStatesCensusAnalyser/src"
			+ "/main/java/com/capgemini/IndianStatesCensusAnalyser/IndianCensus/CensusDelimiter.csv";
	private static final String INDIAN_CENSUS_WRONG_HEADER_CSV_FILE_PATH = "/eclipse-workspace/IndianStatesCensusAnalyser/src"
			+ "/main/java/com/capgemini/IndianStatesCensusAnalyser/IndianCensus/IndianCensusWrongHeader.csv";

	@Test
	public void givenIndianCensusCSVFileReturnsCorrectsRecords() throws Exception {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_CSV_FILE_PATH);
			Assert.assertEquals(30, numOfRecords);
		} catch (CensusAnalyserException e) {
		}
	}

	@Test
	public void givenIndiaCensusIncorrectShouldThrowCustomException() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_WRONG_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenIndiaCensusData_WithWrongFileType_ShouldThrowException() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_WRONG_TYPE_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenWrongDelimiter_InIndiaCensusData_ShouldReturnCustomExceptionType() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_WRONG_DELIMITER_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}

	@Test
	public void givenMissingHeader_InIndiaCensusData_ShouldReturnCustomExceptionType() {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			censusAnalyser.loadIndiaCensusData(INDIAN_CENSUS_WRONG_HEADER_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}
}

package test.project

import functionnalities.query.Query

object TestQuery {
    def testGettingAirportsByCountryName() = {
        val utils = Utils(AirportUtil.getAirports(), CountryUtil.getCountries(), RunwayUtil.getRunways())
        val result = Query.queryAirportsName("France", utils)
        result == None ? "Test loading airports failed" : "Test loading airports succeeded"
    }

    def testGettingAirportsByCountryCode() = {
        val utils = Utils(AirportUtil.getAirports(), CountryUtil.getCountries(), RunwayUtil.getRunways())
        val result = Query.queryAirportsCode("FR", utils)
        result == None ? "Test loading airports failed" : "Test loading airports succeeded"
    }

    def testQueryByCountryName() = {
        val utils = Utils(AirportUtil.getAirports(), CountryUtil.getCountries(), RunwayUtil.getRunways())
        val result = Query.queryByCountryName("France", utils)
        result == None ? "Test loading airports failed" : "Test loading airports succeeded"
    }

    def testQueryByCountryCode() = {
        val utils = Utils(AirportUtil.getAirports(), CountryUtil.getCountries(), RunwayUtil.getRunways())
        val result = Query.queryByCountryCode("FR", utils)
        result == None ? "Test loading airports failed" : "Test loading airports succeeded"
    }
}
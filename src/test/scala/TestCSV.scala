package test.project

import fileReader.service.CSV

object TestCSV {
    def testLoadingAirports() = {
        val data = CSV.read("airports.csv")
        data == None ? "Test loading airports failed" : "Test loading airports succeeded"
    }
}
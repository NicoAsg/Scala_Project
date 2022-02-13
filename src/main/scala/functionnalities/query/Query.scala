package functionnalities.query

import fileReader.model.AirportUtil
import fileReader.model.Airport
import fileReader.model.CountryUtil
import fileReader.model.RunwayUtil
import fileReader.model.Runway

import functionnalities.utils.Utils

final case class QueryResult(
    airport: Airport,
    runways: List[Runway]
)

object Query {
    def queryAirportsName(name: String, utils: Utils) = queryAirportsCode(utils.countries.filter(_.name == name).head.code, utils)

    def queryAirportsCode(code: String, utils: Utils) = utils.airports.filter(_.iso_country == code)

    def queryRunways(airport: Airport, utils: Utils) = utils.runways.filter(_.airport_ref == airport.id)

    def queryByCountryName(name: String, utils: Utils) = queryAirportsName(name, utils).map(airport => QueryResult(airport, queryRunways(airport, utils)))

    def queryByCountryCode(code: String, utils: Utils) = queryAirportsCode(code, utils).map(airport => QueryResult(airport, queryRunways(airport, utils)))

    def printQueryResults(queryResults: List[QueryResult]) = {
        queryResults.foreach(result => {
            println("Airport: " + result.airport.name)
            println("Runways ids: ")
            result.runways.foreach(runway => println("- " + runway.id))
        })
    }

        // airports.foreach(airport => {
        //     println("Airport: " + airport.name)
        //     println("Runways ids:")
        //     queryRunways(airport).foreach(runway => println("- " + runway.id))
        // })
}


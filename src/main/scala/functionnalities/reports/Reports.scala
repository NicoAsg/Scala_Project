package functionnalities.reports

import functionnalities.query.Query
import functionnalities.utils.Utils

import fileReader.model.Airport
import fileReader.model.Runway

final case class CountryAirports (
    country: String,
    airports: List[Airport]
)

final case class CountryRunways (
    country: String,
    runways: List[Runway]
)

object Reports {
    def highestAirports(utils: Utils) = utils.countries.map(country => CountryAirports(country.name, Query.queryAirportsName(country.name, utils))).sortWith(_.airports.length > _.airports.length).take(10)

    def lowestAirports(utils: Utils) = utils.countries.map(country => CountryAirports(country.name, Query.queryAirportsName(country.name, utils))).sortWith(_.airports.length < _.airports.length).take(10)
}

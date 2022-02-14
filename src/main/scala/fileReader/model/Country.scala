package fileReader.model

import fileReader.service.CSV

final case class Country(
    id: Int,
    code: String,
    name: String
)

object CountryUtil {
    def getCountries() = CSV.read("countries.csv").map(line => Country(line(0).toInt, line(1).toString, line(2).toString))
}

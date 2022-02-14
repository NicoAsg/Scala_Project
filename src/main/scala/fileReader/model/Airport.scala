package fileReader.model

import fileReader.service.CSV

final case class Airport(
    id: Int,
    ident: String,
    typ: String,
    name: String,
    latitude_deg: Float,
    longitude_deg: Float,
    iso_country: String
)


object AirportUtil {
    def getAirports() = CSV.read("airports.csv").map(line => Airport(line(0).toInt, line(1).toString, line(2).toString, line(3).toString, line(4).toFloat, line(5).toFloat, line(8).toString))
}

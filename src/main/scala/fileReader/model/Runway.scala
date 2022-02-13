package fileReader.model

import fileReader.service.CSV

final case class Runway (
    id: Int,
    airport_ref: String,
    airport_ident: String,
    surface: String,
    le_ident: String
)

object RunwayUtil {
    def getRunways() = CSV.read("runways.csv").map(line => Runway(line(0).toInt, line(1).toString, line(2).toString, line(5).toString, line(8).toString))
}
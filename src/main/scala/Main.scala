import fileReader.service.CSV
import fileReader.model.AirportUtil
import fileReader.model.CountryUtil
import fileReader.model.RunwayUtil

import functionnalities.query.Query
import functionnalities.utils.Utils

import functionnalities.reports.Reports

object Main {
  def main(args: Array[String]): Unit = {
      val utils = Utils(AirportUtil.getAirports(), CountryUtil.getCountries(), RunwayUtil.getRunways())
      
  }
}
import fileReader.service.CSV
import fileReader.model.AirportUtil
import fileReader.model.CountryUtil
import fileReader.model.RunwayUtil

import functionnalities.query.Query
import functionnalities.utils.Utils

import functionnalities.reports.Reports

object Main {
  // def main(args: Array[String]): Unit = {
  //     val utils = Utils(AirportUtil.getAirports(), CountryUtil.getCountries(), RunwayUtil.getRunways())

      
  // }

  def menu(): Any = {

      println("----")

      println("1- Query")

      println("2- Reports")

      println("3- Exit")

      print("-> ")

      scala.io.StdIn.readLine() match {

        case "Query" | "1" => query_menu()

        case "Reports" | "2" => reports_menu()

        case "Exit" | "3" => println("Exiting")

        case _ => println("Unknown Option")

       

      }

    }



    def query_menu(): Any = {

      println("1- Query by country name")

      println("2- Query by country code")

      println("3- Back")

      print("-> ")

      scala.io.StdIn.readLine() match {

        case "1" => queryByName()
        case "2" => queryByCode()

        case "Exit" | "3" => menu();

        case _ => println("Unknown Option")

      }
      //fonction a mettre

    }

    def queryByName() : Any = {
        println("Enter the country name: ")

        val name = scala.io.StdIn.readLine()
        Query.queryByCountryName(name, Utils(AirportUtil.getAirports(), CountryUtil.getCountries(), RunwayUtil.getRunways())).foreach(element => println("Airport: " + element.airport.name + "\nRunways ids:\n" + element.runways.foreach(element => println(element.id))))

        menu()
    }

    def queryByCode() : Any = {
        println("Enter the country code: ")

        val code = scala.io.StdIn.readLine()

        Query.queryByCountryCode(code, Utils(AirportUtil.getAirports(), CountryUtil.getCountries(), RunwayUtil.getRunways())).foreach(element => println("Airport: " + element.airport.name + "\nRunways ids:\n" + element.runways.foreach(element => println(element.id))))

        menu()
    }



    def reports_menu(): Any = {

      println("1- Highest/Lowest number of airports")

      println("2- Back")

      print("-> ")

      val choice = scala.io.StdIn.readLine()
      choice match {

        case "1" => highestLowest()

        case "2" => menu();

        case _ => println("Unknown Option")

      }

    }

    def highestLowest() = {
        println("Highest Airports :")
        Reports.highestAirports(Utils(AirportUtil.getAirports(), CountryUtil.getCountries(), RunwayUtil.getRunways())).foreach(element => println(element.country + ": " + element.airports.length + " airports"))

        println("Lowest Airports :")
        Reports.lowestAirports(Utils(AirportUtil.getAirports(), CountryUtil.getCountries(), RunwayUtil.getRunways())).foreach(element => println(element.country + ": " + element.airports.length + " airports"))

        menu()
    }

    def main(args: Array[String]): Unit = {

      menu()

    }
}
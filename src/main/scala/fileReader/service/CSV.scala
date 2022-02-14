package fileReader.service

import scala.io.Source
import scala.util.matching.Regex

object CSV {
  def read(fileName: String) = Source.fromFile("src/main/data/" + fileName)
        .getLines
        .toList
        .drop(1)
        .map(_.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1)
                .map(c => c.replace("\"", "")))
}

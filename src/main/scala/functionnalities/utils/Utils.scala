package functionnalities.utils

import fileReader.model.Airport
import fileReader.model.Country
import fileReader.model.Runway

final case class Utils (
    airports: List[Airport],
    countries: List[Country],
    runways: List[Runway]
)

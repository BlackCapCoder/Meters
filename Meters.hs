import Data.Map as M
import Data.Maybe (maybe)
import Control.Category ((<<<))

data Kind = Clock | Scale | Thermometer
          deriving Show

unit Clock       = "seconds"
unit Scale       = "grams"
unit Thermometer = "celcius"

data Meter = Meter
  { kind   :: Kind
  , minVal :: Float
  , maxVal :: Float
  , broken :: Bool
  }

type MeterArchine = Map String Meter

instance Show Meter where
  show m = concat
    [ show $ kind m
    , ", measures "
    , show $ minVal m, "-"
    , show $ maxVal m, " "
    , unit $ kind m
    , if broken m then ", broken" else mempty
    ]

setBroken b m = m { broken = b }
vandalize = adjust $ setBroken True

move a b m = maybe id (insert b) (M.lookup b m)
           . flip (insert a) m <$> M.lookup a m


try f m | Just x <- f m = x | otherwise = m

main = print . vandalize "M2"
           <<< try (move "M2" "M3")
           <<< vandalize "M4"
           <<< try (move "M4" "M3")
             $ fromList
                 [ ("M1", Meter Clock           0.01       (1/0) False)
                 , ("M2", Meter Thermometer (-273.15)      (1/0) False)
                 , ("M3", Meter Scale            200  (200*1000) False)
                 ]

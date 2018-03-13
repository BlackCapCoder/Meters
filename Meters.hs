import Data.Map as M
import Data.Maybe
import Control.Category ((>>>))

data Kind = Clock | Scale | Thermometer
          deriving (Show, Eq)

unit Clock       = "seconds"
unit Scale       = "grams"
unit Thermometer = "celcius"

data Meter = Meter
  { kind   :: Kind
  , minVal :: Float
  , maxVal :: Float
  , broken :: Bool
  } deriving Eq

instance Show Meter where
  show m = concat
    [ show $ kind m
    , ", measures "
    , show $ minVal m, "-"
    , show $ maxVal m, " "
    , unit $ kind m
    , if broken m then ", broken" else mempty
    ]

type Position     = String
type MeterArchine = Map Position Meter


setBroken :: Bool -> Meter -> Meter
setBroken b m = m { broken = b }

vandalize :: Position -> MeterArchine -> MeterArchine
vandalize = adjust $ setBroken True

move :: Position -> Position -> MeterArchine -> MeterArchine
move a b = (M.lookup b >>> maybe id (insert a))
       <*> (M.lookup a >>= maybe id (insert b))


main :: IO ()
main = vandalize "M2"
   >>> move "M2" "M3"
   >>> vandalize "M4"
   >>> move "M4" "M3"
   >>> putStrLn . maybe "Nothing here" show . M.lookup "M3"
     $ fromList
         [ ("M1", Meter Clock           0.01       (1/0) False)
         , ("M2", Meter Thermometer (-273.15)      (1/0) False)
         , ("M3", Meter Scale            200  (200*1000) False)
         ]

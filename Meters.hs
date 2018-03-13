import Data.Map.MultiKey as M
import Data.Maybe
import Control.Category ((>>>))

data Kind = Clock | Scale | Thermometer
          deriving (Eq, Show)

unit Clock       = "seconds"
unit Scale       = "grams"
unit Thermometer = "celcius"

newtype Reg = Reg { unReg :: String } deriving (Eq, Ord)
newtype Pos = Pos { unPos :: String } deriving (Eq, Ord)

data Meter = Meter
  { reg    :: Reg
  , pos    :: Pos
  , kind   :: Kind
  , minVal :: Float
  , maxVal :: Float
  , broken :: Bool
  } deriving Eq

setPos    x m = m { pos    = x }
setBroken x m = m { broken = x }

instance MultiKeyable Meter where
  empty = MultiKey [key reg, key pos]

type MeterArchive = MultiKey Meter

instance Show Meter where
  show m = unlines
    [ show $ kind m
    , "intv: " ++ show (minVal m) ++ " - "
               ++ show (maxVal m) ++ " " ++ unit (kind m)
    , "reg:  " ++ unReg (reg m)
    , "pos:  " ++ unPos (pos m)
    , "stat: " ++ if broken m
                     then "broken!"
                     else "fine"
    ]


vandalize k = maybe id (M.updateKey k . setBroken True)
                =<< M.lookup k

move r p =
  maybe id (\x m
    -> M.deleteKey p
   >>> M.updateKey r (setPos p x)
   >>> ( maybe id (M.insert . setPos (pos x))
           =<< const (M.lookup p m) )
     $ m
  ) =<< M.lookup r


main :: IO ()
main = id
   >>> vandalize (Pos "M2")
   >>> move      (Reg "T" ) (Pos "M3")
   >>> vandalize (Reg "Q")
   >>> move      (Reg "T" ) (Pos "M3")
   >>> putStrLn . maybe "Nothing here" show
                . M.lookup (Pos "M3")
     $ fromList
        [ Meter (Reg "C") (Pos "M1") Clock           0.01       (1/0) False
        , Meter (Reg "T") (Pos "M2") Thermometer (-273.15)      (1/0) False
        , Meter (Reg "S") (Pos "M3") Scale            200  (200*1000) False
        ]


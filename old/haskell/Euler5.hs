import List
import Data.List
import Math


euler5 = euler5loop 20

euler5loop currentN = if currentN `mod` 19 == 0 && currentN `mod` 17 == 0 && currentN `mod` 13 == 0 && currentN `mod` 7 == 0 
  then
  if    ((isInfixOf [1..20] (sort (properfactors currentN))) )  
    then currentN
    else 
    euler5loop (currentN + 20)
  else
    euler5loop (currentN + 20)


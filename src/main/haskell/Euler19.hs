import Dates
import Math
import qualified Data.Vector as V

daysInwholePeriod = daysFromYear 2000 + daysFromMonth 12 2000

allDatesin1904 = listAllDaysInner (4*365)  ((4*365) + 366) []


euler19 = euler19Inner 365 daysInwholePeriod 0 

euler19Inner :: Int -> Int -> Int -> Int 
euler19Inner iter target acc = if iter < target then
                                  if ((thr3 (dateFromNumber iter)) == 1)  && (isSunday iter)
                                    then 
                                      euler19Inner (iter+1) target (acc+1) 
                                    else
                                      euler19Inner (iter+1) target acc
                                else 
                                  acc  



listAllDays :: [(Int,Int,Int,String, Bool)] 
listAllDays = listAllDaysInner 0 365 []

listAllDaysInner :: Int -> Int -> [(Int,Int,Int,String,Bool)] -> [(Int,Int,Int,String, Bool)] 
listAllDaysInner iter target accList = if iter < target then
                         if ( 1 == 1) 
                              then 
                                listAllDaysInner (iter+1) target (accList ++ [(fst3(dateFromNumber iter), snd3(dateFromNumber iter), thr3(dateFromNumber iter), dayOfTheWeek iter, isSunday iter)]) 
                              else
                                listAllDaysInner (iter+1) target accList
                          else 
                            accList

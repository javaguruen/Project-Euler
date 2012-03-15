module Dates where

import qualified Data.Vector as V

--Convention : Is 0 or 1  : 1 jan 1900 ? We arbitrarily define that date as 1.
daysAtEndOfMonths = V.fromList[31,59,90,120,151,181,212,243,273,304,334,365,999]
daysAtEndOfMonthsLeap = V.fromList[31,60,91,121,152,182,213,244,274,305,335,366,999]

dayList = V.fromList["Mon","Tues","Wed","Thur","Fri","Sat","Sun"]



dayOfTheWeek :: Int -> String
dayOfTheWeek n = dayList V.! ((n-1) `mod` 7) 

isSunday :: Int -> Bool
isSunday n = ((n-1) `mod` 7) == 6

dateFromNumber :: Int -> (Int, Int, Int)
dateFromNumber n = let yearTuple = yearFromNumber n
                       monthTuple = monthFromNumber (snd yearTuple) n
                       restDays = snd monthTuple
                       in (fst yearTuple, fst monthTuple, restDays)

yearFromNumber :: Int -> (Int, Int)
yearFromNumber n = yearFromNumberInner n 0 1900

yearFromNumberInner :: Int -> Int -> Int -> (Int,Int)  
yearFromNumberInner target acc currentYear = if acc < target then 
                                              let acc2 = acc + 365 + getLeapYear currentYear
                                                  nextYear = currentYear + 1 
                                              in yearFromNumberInner target acc2 nextYear
                                            else
                                              ((currentYear - 1), target - (acc - 365 - (getLeapYear (currentYear-1))))


monthFromNumber :: Int ->Int -> (Int, Int) 
monthFromNumber dayCount n =  if (dayCount<=31) then (1, dayCount)
              else 
                if ((getLeapYear (fst (yearFromNumber n))) == 0) then
                    monthFromNumberInner dayCount 0 daysAtEndOfMonths
                else
                    monthFromNumberInner dayCount 0 daysAtEndOfMonthsLeap

monthFromNumberInner n currentMonth dayNumberVector = if n <=  (dayNumberVector V.! currentMonth) 
                then ((currentMonth+1) , n - (dayNumberVector V.! (currentMonth-1))) 
                else  monthFromNumberInner n (currentMonth+1) dayNumberVector


daysFromYear year = daysFromYearInner (year) 0

daysFromYearInner 1900 acc = acc

daysFromYearInner year acc = daysFromYearInner (year -1) acc + 365 + getLeapYear year


daysFromMonth month year = (daysAtEndOfMonths V.! (month-1)) + if month > 1 then (getLeapYear year) else 0

getLeapYear year = if year `mod` 4 == 0 && (year `mod` 100 /= 0 || year `mod` 400 == 0) then 1 else 0


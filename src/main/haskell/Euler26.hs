import Strings
import Math
import BigMath
import CReal

mAX_CYCLE_SIZE = 2000
mAX_OFFSET = 10

euler26 = foldl maxWithIndex (0,0) (map detectCyclesWithVaryingIndexTuple decimalsNewWithIndex)

decimalsNewWithIndex = (map showCRealExtended [ (x, bigDivide x)  | x <- [1..1000] ] )

showCRealExtended :: (CReal, CReal) -> (CReal, String)
showCRealExtended (index, result) = (index, (showCReal 5000 result))

detectCyclesWithVaryingIndexTuple (index, str) = (index, (detectCyclesWithVaryingIndex str))

detectCyclesWithVaryingIndex str = detectCyclesWithVaryingIndexInner str  2

detectCyclesWithVaryingIndexInner str offset = if or [offset > mAX_OFFSET, offset > (length str)] then 0
                                               else detectCyclesOfVaryingLength str (offset+1) 

detectCyclesOfVaryingLength :: String -> Int -> Int
detectCyclesOfVaryingLength str offset = detectCyclesOfVaryingLengthInner str offset 1

detectCyclesOfVaryingLengthInner :: String -> Int -> Int -> Int 
detectCyclesOfVaryingLengthInner str offset size = if size > mAX_CYCLE_SIZE then 0 else
                                                if (detectSingleCycle size offset str) then size
                                                        else detectCyclesOfVaryingLengthInner str offset (size+1)


detectSingleCycle :: Int -> Int -> String -> Bool
detectSingleCycle size offset number =  if (offset + (2*size) > length number) then False
                                      else
                                        let processedString = drop offset number
                                            candidate = substringSafe 0 size processedString
                                        in detectSingleCycleInner size candidate (drop size processedString)

detectSingleCycleInner :: Int -> String -> String -> Bool
detectSingleCycleInner size candidate restOfNumber  = let nextCandidate = substringSafe 0 size restOfNumber
                                                          candidatesEqual = nextCandidate == candidate
                                                          endOfString = ((length restOfNumber) - size) < size
                                                      in if ( not candidatesEqual) then False
                                                        else if endOfString then True
                                                             else detectSingleCycleInner size candidate (drop size restOfNumber)



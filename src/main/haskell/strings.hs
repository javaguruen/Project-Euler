module Strings where

import Char

 

stripLeadingZeroes :: String -> String
stripLeadingZeroes str = dropWhile (=='0') str

--Returns the string starting on index startIndex to endIndex, inclusive
substring :: Int -> Int -> String -> String
substring startIndex endIndex str = take (endIndex-startIndex) (drop startIndex str)

--Returns the string starting on index startIndex to endIndex, inclusive
substringSafe :: Int -> Int -> String -> String
substringSafe (-1) endIndex str = ""
substringSafe startIndex endIndex str = take (endIndex-startIndex) (drop startIndex str)


nreverse (x:xs) = nreverse(xs) ++ [x]
nreverse [] = []

extractChars (x:xs) = 
  if isDigit x
    then [x] ++ extractChars xs
    else extractChars xs 
extractChars [] = []



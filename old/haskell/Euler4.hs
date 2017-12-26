import Math

euler4 = maximum (map stringToInt euler4sub)

euler4sub :: [String]
euler4sub = filter isPalindrome (map show (crossedMulti [100..999] [100..999]))

stringToInt :: String -> Int
stringToInt (xs) = read xs

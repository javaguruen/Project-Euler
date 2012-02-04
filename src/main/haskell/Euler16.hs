tverrmain = let a = 2 ^ 1000
                astr = show a
                in tverrsum astr

tverrsum (x:xs) = tverrsum xs + read [x] :: Int
tverrsum [] = 0

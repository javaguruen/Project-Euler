import qualified Data.Vector as V

euler11data = V.fromList [V.fromList[08,02,22,97,38,15,00,40,00,75,04,05,07,78,52,12,50,77,91,08]
          ,V.fromList[49,49,99,40,17,81,18,57,60,87,17,40,98,43,69,48,04,56,62,00]
          ,V.fromList[81,49,31,73,55,79,14,29,93,71,40,67,53,88,30,03,49,13,36,65]
          ,V.fromList[52,70,95,23,04,60,11,42,69,24,68,56,01,32,56,71,37,02,36,91]
          ,V.fromList[22,31,16,71,51,67,63,89,41,92,36,54,22,40,40,28,66,33,13,80]
          ,V.fromList[24,47,32,60,99,03,45,02,44,75,33,53,78,36,84,20,35,17,12,50]
          ,V.fromList[32,98,81,28,64,23,67,10,26,38,40,67,59,54,70,66,18,38,64,70]
          ,V.fromList[67,26,20,68,02,62,12,20,95,63,94,39,63,08,40,91,66,49,94,21]
          ,V.fromList[24,55,58,05,66,73,99,26,97,17,78,78,96,83,14,88,34,89,63,72]
          ,V.fromList[21,36,23,09,75,00,76,44,20,45,35,14,00,61,33,97,34,31,33,95]
          ,V.fromList[78,17,53,28,22,75,31,67,15,94,03,80,04,62,16,14,09,53,56,92]
          ,V.fromList[16,39,05,42,96,35,31,47,55,58,88,24,00,17,54,24,36,29,85,57]
          ,V.fromList[86,56,00,48,35,71,89,07,05,44,44,37,44,60,21,58,51,54,17,58]
          ,V.fromList[19,80,81,68,05,94,47,69,28,73,92,13,86,52,17,77,04,89,55,40]
          ,V.fromList[04,52,08,83,97,35,99,16,07,97,57,32,16,26,26,79,33,27,98,66]
          ,V.fromList[88,36,68,87,57,62,20,72,03,46,33,67,46,55,12,32,63,93,53,69]
          ,V.fromList[04,42,16,73,38,25,39,11,24,94,72,18,08,46,29,32,40,62,76,36]
          ,V.fromList[20,69,36,41,72,30,23,88,34,62,99,69,82,67,59,85,74,04,36,16]
          ,V.fromList[20,73,35,29,78,31,90,01,74,31,49,71,48,86,81,16,23,57,05,54]
          ,V.fromList[01,70,54,71,83,51,54,69,16,92,33,48,61,43,52,01,89,19,67,48]]

productHorizontalSafe x y = if x < 16 && y < 20 then productHorizontal x y
                            else 0
productHorizontal x y = let line = euler11data V.! y 
                            window = V.unsafeSlice x 4 line
                            in V.foldl (*) 1 window

productVerticalSafe x y = if x < 20 && y < 16 then productVertical x y
                          else 0

productVertical x y = let lines = V.unsafeSlice y 4 euler11data
                          window = V.map (V.! x) lines
                          in V.foldl (*) 1 window

productDownRightSafe x y = if x < 16 && y < 16 then productDownRight x y
                          else 0


productDownRight x y = let lines = V.unsafeSlice y 4 euler11data
                           window = takeVariableDR x y 0
                          in foldl (*) 1 window

productDownleftSafe x y = if x > 3 && y < 16 then productDownLeft x y
                          else 0                          

productDownLeft x y = let lines = V.unsafeSlice y 4 euler11data
                          window = takeVariableDL x y 0
                          in foldl (*) 1 window

bestProductInPoint :: Int -> Int -> Int
bestProductInPoint x y = let hz = productHorizontalSafe x y
                             ver = productVerticalSafe x y
                             dl = productDownRightSafe x y
                             dr = productDownleftSafe x y
                             in foldl max 0  [hz,ver, dl, dr]

euler11 = foldl max 0 (euler11Inner 0 0)

euler11Inner 19 19 = []
euler11Inner x y = [bestProductInPoint x y] ++ if x == 19 then
                                  euler11Inner 0 (y+1)
                                  else
                                  euler11Inner (x+1) y


takeVariableDR :: Int -> Int -> Int -> [Int]
takeVariableDR x y iter = if iter < 4 then  
                                        [euler11data V.! y V.! x] ++ takeVariableDR (x+1) (y+1) (iter+1) 
                                      else
                                        []

takeVariableDL :: Int -> Int -> Int -> [Int]
takeVariableDL x y iter = if iter < 4 then
                                        [euler11data V.! y V.! x] ++ takeVariableDL (x-1) (y+1) (iter+1) 
                                      else
                                        []

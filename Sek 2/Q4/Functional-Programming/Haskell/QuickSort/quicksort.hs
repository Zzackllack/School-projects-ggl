qSort :: Ord a => [a] -> [a]
qSort [] = []
qSort (x:xs) = qSort [y | y <- xs, y<=x] ++ [x] ++
    qSort [y | y <- xs, y> x]
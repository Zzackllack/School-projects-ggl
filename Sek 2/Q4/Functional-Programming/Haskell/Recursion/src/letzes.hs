letztes :: [a] -> a
letztes []     = error "letztes: leere Liste"
letztes [x]    = x
letztes (_:xs) = letztes xs
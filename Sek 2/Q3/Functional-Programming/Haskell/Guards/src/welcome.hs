welcome :: String -> String -> String
welcome vorname nachname
    | vorname == "Steffen" && nachname == "Jost" = "Good morning Dr Jost!"
    | nachname == "Jost" = "Welcome!"
    | otherwise = "Go away!"
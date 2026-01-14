habGeldNachAktion ::Int -> Int -> String
habGeldNachAktion konto zahlung| kontoneu < 0, zahlung > 0 = "Kannst Du Dir nicht leisten!"
    | kontoneu > 0, zahlung > 0 = "Bist echt reich!"
    | otherwise = "Alles ist ok."
    where kontoneu = konto - zahlung
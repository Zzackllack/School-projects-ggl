question_height = int (input("What is your height?"))
question_coins = int(input("How many coins do you have?"))

if question_height >= 137 and question_coins >= 10:
    print("You can ride the Cyclone!")
elif question_height < 137 and question_coins >= 10:
    print("You are too short to ride the Cyclone!")
elif question_height >= 137 and question_coins < 10:
    print("You do not have enough coins to ride the Cyclone!")
else:
    print("You are too short to ride the Cyclone and you do not have enough coins to ride the Cyclone!")
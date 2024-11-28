gryffindor = 0
ravenclaw = 0
hufflepuff = 0
slytherin = 0

question_1 = int(input("(Q1) Do you like Dawn or Dusk? \n 1) Dawn \n 2) Dusk"))
if question_1 == 1:
    gryffindor += 1
    hufflepuff += 1
elif question_1 == 2:
    hufflepuff += 1
    slytherin += 1
else:
    print("Wrong input")

question_2 = int(input("(Q2) When I’m dead, I want people to remember me as: \n 1) The Good \n 2) The Great \n 3) The Wise \n 4) The Bold"))
if question_2 == 1:
    hufflepuff += 2
elif question_2 == 2:
    slytherin += 2
elif question_2 == 3:
    ravenclaw += 2
elif question_2 == 4:
    gryffindor += 2
else:
    print ("Wrong input")

question_3 = int(input("(Q3) Which kind of instrument most pleases your ear? \n 1) The violin \n 2) The trumpet \n 3) The piano \n 4) The drum"))
if question_3 == 1:
    slytherin += 4
elif question_3 == 2:
    hufflepuff += 4
elif question_3 == 3:
    ravenclaw += 4
elif question_3 == 4:
    gryffindor += 4
else:
    print("Wrong input")

if gryffindor > ravenclaw and gryffindor > hufflepuff and gryffindor > slytherin:
    print("Gryffindor")
elif ravenclaw > gryffindor and ravenclaw > hufflepuff and ravenclaw > slytherin:
    print("Ravenclaw")
elif hufflepuff > gryffindor and hufflepuff > ravenclaw and hufflepuff > slytherin:
    print("Hufflepuff")
elif slytherin > gryffindor and slytherin > ravenclaw and slytherin > hufflepuff:
    print("Slytherin")
else:
    print("You are a muggle")
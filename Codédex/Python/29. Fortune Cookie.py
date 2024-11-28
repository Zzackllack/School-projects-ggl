import random

def fortune():
    fortunes = ["Don't pursue happiness – create it.","All things are difficult before they are easy.","The early bird gets the worm, but the second mouse gets the cheese.","Someone in your life needs a letter from you","Don't just think. Act!","Your heart will skip a beat.","The fortune you search for is in another cookie.","Help! I'm being held prisoner in a Chinese bakery!"]
    randomnum = random.randint(0,7)
    print(fortunes[randomnum])

# Call
fortune()
# template for "Guess the number" mini-project
# input will come from buttons and an input field
# all output for the game will be printed in the console
import simplegui
import random
import math

# initialize global variables used in your code
num_range = 100
num_of_guesses = 7
random_num = 50
game_num = 1

# helper function to start and restart the game
def new_game():
    global random_num
    random_num_container = random.randrange(0,num_range)
    random_num = random_num_container
    #print random_num, " -- random number"
    print "New game, Range is from 0 to", num_range
    print "Number of remaining guesses is", num_of_guesses 
    print " "

# define event handlers for control panel
def range100():
    # button that changes range to range [0,100) and restarts
    global num_range
    num_range = 100
    global num_of_guesses
    num_of_guesses = 7
    global game_num
    game_num = 1
    new_game()
   
def range1000():
    # button that changes range to range [0,1000) and restarts
    global num_range
    num_range = 1000
    global num_of_guesses
    num_of_guesses = 10
    global game_num
    game_num = 2
    new_game()
   
def input_guess(guess):
    # main game logic goes here	
    global num_of_guesses
    guess_in_int = int(guess)
    print "Guess was", guess
    #print "player number is", random_num
    num_of_guesses-=1
    print "Number of remaining guesses is", num_of_guesses
    if(num_of_guesses+1 >= 0):
        #num_of_guesses-=1
        
        if(guess_in_int < random_num):
            print "Lower!"
        elif(guess_in_int > random_num):
            print "Higher!"
        elif(guess_in_int == random_num):
            print "Correct!"
            print " "
            select_game(game_num)
    else:
        print "you ran out of guesses. The number was", random_num
        print " "
        select_game(game_num)
    # remove this when you add your code
    print " "
    
def select_game(number):
    if(number == 1):
        range100()
    elif(number == 2):
        range1000()
        
# create frame
f= simplegui.create_frame("Guess the number", 200, 200)

# register event handlers for control elements
f.add_button("Range is [0, 100)", range100, 200)
f.add_button("Range is [0, 1000)", range1000, 200)
f.add_input("Enter a guess", input_guess, 200)

# call new_game and start frame
new_game()

# always remember to check your completed program against the grading rubric

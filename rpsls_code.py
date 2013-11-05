# Rock-paper-scissors-lizard-Spock template
import random


def number_to_name(number):
    # fill in your code below
    
    # convert number to a name using if/elif/else
    if(number==0):
        result = "rock"
    elif(number==1):
        result = "Spock"
    elif(number==2):
        result = "paper"
    elif(number==3):
        result = "lizard"
    elif(number==4):
        result = "scissors"    
    else:
        print "wrong number entered"
    # don't forget to return the result!
    return result

    
def name_to_number(name):
    # fill in your code below

    # convert name to number using if/elif/else
    if(name=="rock"):
        result=0
    elif(name=="Spock"):
        result=1
    elif(name=="paper"):
        result=2
    elif(name=="lizard"):
        result=3
    elif(name=="scissors"):
        result=4
    else:
        print "wrong name entered"
    # don't forget to return the result!
    return result


def rpsls(name): 
    # fill in your code below
    print "Player chooses",name
    
    # convert name to player_number using name_to_number
    player_number=name_to_number(name)
    
    # compute random guess for comp_number using random.randrange()
    comp_number= random.randrange(0,5)
    
    
    # compute difference of player_number and comp_number modulo five
    difference= comp_number-player_number
    
        
    # use if/elif/else to determine winner
    if(difference<0):
        difference+=5
    if(difference==0):
        winner="tie"
    elif(difference<=2):
        winner="Computer"
    else:
        winner="Player"
  
   
    
    # convert comp_number to name using number_to_name
    comp_name=number_to_name(comp_number)
    print "Computer chooses",comp_name
    
    # print results
    if(winner=="tie"):
        print "Player and computer tie!"
    else:
        print winner, "wins!"
    print ""
    

    
# test your code
rpsls("rock")
rpsls("Spock")
rpsls("paper")
rpsls("lizard")
rpsls("scissors")

# always remember to check your completed program against the grading rubric
#checked


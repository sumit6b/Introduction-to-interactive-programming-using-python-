#http://www.codeskulptor.org/#user24_wXbiYsEEqH_5.py
# implementation of card game - Memory

import simplegui
import random

deck = []
exposed = []
state = 0
carda = -1
cardb = -1
freez = False
turns = 0

def init():
    global deck, exposed,state,carda,cardb,freez,turns
    deck = []
    exposed = [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
    state = 0
    carda = -1
    cardb = -1
    freez = False
    turns = 0

# helper function to initialize globals
def new_game():
    global deck
    init()
    list_a = [0,1,2,3,4,5,6,7]
    list_b = [0,1,2,3,4,5,6,7]
    deck = list_a + list_b
    random.shuffle(deck)
    #print deck
# define event handlers
def mouseclick(pos):
    # add game state logic here
    global exposed, state, carda, cardb, deck, freez, turns
 
    index = -1
    index = pos[0]/50
    #print index
    if state == 0:
     
        carda = index
        exposed[index] = 1
        #print "state "+ str(state)
        state = 1
      
    elif state == 1:
        turns += 1
        cardb = index
        exposed[index] = 1
        state = 2
        
    else:
        if deck[carda] == deck[cardb]:
            carda = index
        #    exposed[index] = 1
        #    turns -=1
        else:
           
            exposed[carda] = 0
            exposed[cardb] = 0
            carda = index
        exposed[index] = 1
        state = 1
        #print "state "+ "12" 
    label.set_text("Turns = "+str(turns))
    
                  
# cards are logically 50x100 pixels in size    
def draw(canvas):
    for n in range(16):
        canvas.draw_polygon([(n*50,0), (n*50+50,0),
                                 (n*50+50,100),(n*50,100)], 5, "grey")
    
    
    n = 1
    for x in deck:
        
        canvas.draw_text(str(x), [25*n,60],20,"white")
        n += 2
    n = 0  
    
    for x in exposed:
        
        if x==0:
            canvas.draw_polygon([(n*50,0), (n*50+50,0),
                                 (n*50+50,100),(n*50,100)], 5, "grey", "white")
        n += 1

# create frame and add a button and labels
frame = simplegui.create_frame("Memory", 800, 100)
frame.add_button("Restart", new_game)
label = frame.add_label("Turns = 0")


# register event handlers
frame.set_mouseclick_handler(mouseclick)
frame.set_draw_handler(draw)

# get things rolling
new_game()
frame.start()


# Always remember to review the grading rubric
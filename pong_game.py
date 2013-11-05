http://www.codeskulptor.org/#user23_cpptgQ3M6C_1.py

# Implementation of classic arcade game Pong

import simplegui
import random

# initialize globals - pos and vel encode vertical info for paddles
WIDTH = 600
HEIGHT = 400       
BALL_RADIUS = 20
PAD_WIDTH = 8
PAD_HEIGHT = 80
HALF_PAD_WIDTH = PAD_WIDTH / 2
HALF_PAD_HEIGHT = PAD_HEIGHT / 2
LEFT = False
RIGHT = True

# initialize ball_pos and ball_vel for new bal in middle of table
ball_pos = [WIDTH/2, HEIGHT/2]
ball_vel = [0.0,0.0]

paddle1_pos = HEIGHT/2
paddle2_pos = HEIGHT/2
paddle1_vel = 10
paddle2_vel = 10
direction =" "
score1 = 0
score2 = 0
# if direction is RIGHT, the ball's velocity is upper right, else upper left
def spawn_ball(direction):
    global ball_pos, ball_vel # these are vectors stored as lists
    ball_pos = [WIDTH/2, HEIGHT/2]
    if(direction == RIGHT):
        ball_vel[0] = random.randrange(12/4,16/4)
        ball_vel[1] = -random.randrange(6/4, 18/4)
    elif(direction == LEFT):
        ball_vel[0] = -(random.randrange(12/4,16/4))
        ball_vel[1] = -(random.randrange(6/4, 18/4))

# define event handlers
def new_game():
    global paddle1_pos, paddle2_pos, paddle1_vel, paddle2_vel  # these are numbers
    global score1, score2  # these are ints
    spawn_ball(RIGHT)
    paddle1_pos = HEIGHT/2
    paddle2_pos = HEIGHT/2
    paddle1_vel = 0
    paddle2_vel = 0

def draw(c):
    global score1, score2, paddle1_pos, paddle2_pos, ball_pos, ball_vel
 
        
    # draw mid line and gutters
    c.draw_line([WIDTH / 2, 0],[WIDTH / 2, HEIGHT], 1, "White")
    c.draw_line([PAD_WIDTH, 0],[PAD_WIDTH, HEIGHT], 1, "White")
    c.draw_line([WIDTH - PAD_WIDTH, 0],[WIDTH - PAD_WIDTH, HEIGHT], 1, "White")
        
    # update ball
    ball_pos[0] += ball_vel[0]
    ball_pos[1] += ball_vel[1]
    
    #check for upper screen and lower screen:
    if(ball_pos[1]<=BALL_RADIUS or ball_pos[1]>=HEIGHT-BALL_RADIUS):
        ball_vel[1] = -ball_vel[1]
    
    # check if ball positions is beyong the gutter now if there is paddle there then change
    # direction of the ball increase the velocity by 10% if not for left gutter touch spawn for left else right
    if(ball_pos[0] <= PAD_WIDTH+BALL_RADIUS):
        if(ball_pos[1]<= paddle1_pos+HALF_PAD_HEIGHT):
            if(ball_pos[1]>= paddle1_pos-HALF_PAD_HEIGHT):
                ball_vel[0] = -ball_vel[0]
                ball_vel[0] += 0.1*(ball_vel[0])
                ball_vel[1] += 0.1*ball_vel[1]
                
        else:
            score2 += 1
            spawn_ball(RIGHT)
            
    elif(ball_pos[0]>= WIDTH-(PAD_WIDTH+BALL_RADIUS)):
        if(ball_pos[1]<= paddle2_pos+HALF_PAD_HEIGHT):
            if(ball_pos[1]>= paddle2_pos-HALF_PAD_HEIGHT):
                ball_vel[0] = -ball_vel[0]
                ball_vel[0] += 0.1*ball_vel[0]
                ball_vel[1] += 0.1*ball_vel[1]
                
        else:
            score1 += 1
            spawn_ball(LEFT)
        
    
            
    # draw ball
    c.draw_circle([ball_pos[0], ball_pos[1]], BALL_RADIUS, 10, "White", 'White')
    
    
    # update paddle's vertical position, keep paddle on the screen
    if(paddle1_pos> PAD_HEIGHT/2):
        if(paddle1_pos< HEIGHT-PAD_HEIGHT/2):
            paddle1_pos += paddle1_vel
        else:
            paddle1_pos -= 1
    else:
        paddle1_pos += 1
            
    if(paddle2_pos> PAD_HEIGHT/2):
        if(paddle2_pos< HEIGHT-PAD_HEIGHT/2):
            paddle2_pos += paddle2_vel
        else:
            paddle2_pos -= 1
    else:
        paddle2_pos += 1
    
    
    
    # draw paddles
    c.draw_line([HALF_PAD_WIDTH, paddle1_pos - HALF_PAD_HEIGHT],
                [HALF_PAD_WIDTH, paddle1_pos + HALF_PAD_HEIGHT], 
                PAD_WIDTH, 
                'White')
    c.draw_line([WIDTH-HALF_PAD_WIDTH, paddle2_pos - HALF_PAD_HEIGHT], 
                [WIDTH-HALF_PAD_WIDTH, paddle2_pos + HALF_PAD_HEIGHT], 
                PAD_WIDTH, 
                'White')
    
    # draw scores
    c.draw_text(str(score1),[WIDTH/4, HEIGHT/6], 50, 'White')
    c.draw_text(str(score2),[3*WIDTH/4, HEIGHT/6], 50, 'White')
        
def keydown(key):
    global paddle1_vel, paddle2_vel
    constant = 4 #paddle speed controler 
    if (key == simplegui.KEY_MAP["w"]):
        paddle1_vel -= constant
    elif(key == simplegui.KEY_MAP["s"]):
        paddle1_vel += constant
    elif(key == simplegui.KEY_MAP["up"]):
        paddle2_vel -= constant
    elif(key == simplegui.KEY_MAP["down"]):
        paddle2_vel += constant
   
def keyup(key):
    global paddle1_vel, paddle2_vel
    constant = 4
    if (key == simplegui.KEY_MAP["w"]):
        paddle1_vel += constant
    elif(key == simplegui.KEY_MAP["s"]):
        paddle1_vel -= constant
    elif(key == simplegui.KEY_MAP["up"]):
        paddle2_vel += constant
    elif(key == simplegui.KEY_MAP["down"]):
        paddle2_vel -= constant

def reset_handler():
    global score1, score2
    score1 = 0
    score2 = 0
    spawn_ball(LEFT)    

# create frame
frame = simplegui.create_frame("Pong", WIDTH, HEIGHT)
frame.add_button('Reset', reset_handler, 200)
frame.set_draw_handler(draw)
frame.set_keydown_handler(keydown)
frame.set_keyup_handler(keyup)


# start frame
new_game()
frame.start()

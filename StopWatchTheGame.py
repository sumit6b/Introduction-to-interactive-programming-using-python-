http://www.codeskulptor.org/#user22_wqCRiJ7Zjv_2.py


import simplegui

# define global variables
time = 0
message = "0:00.0"
countermessage = "0/0"
y = 0
x = 0
running = True
# define helper function format that converts time

def incrementer():
    global time
    time += 1
    formate(time)

# in tenths of seconds into formatted string A:BC.D    
def formate(t):
    global message
    D = t%10
    total_sec = t/10
    temp = total_sec%60
    B = temp/10
    C = temp%10
    A = total_sec/60
    res = str(A)+ ":" + str(B) + str(C)+ "." + str(D)
    message = res

def counterformate(x,y):
    global countermessage
    countermessage = str(y)+"/"+ str(x)
    
# define event handlers for buttons; "Start", "Stop", "Reset"
def start_handler():
    timer.start()
    global running
    running = True
    
def stop_handler():
    global x
    global y
    global time
    global running
    timer.stop()
    if(running == True):
        y += 1
        if(time%10 == 0):
            x += 1
        counterformate(x,y)
    running = False
    
def reset_handler():
    global time
    global x
    global y
    global message
    if(running == True):
        message = "0:00.0"
        time = 0
        x = 0
        y = 0
    counterformate(x,y)

# define draw handler
def draw(canvas):
    canvas.draw_text(message, [90,160], 50, "white")
    canvas.draw_text(countermessage, [251,25], 20, "white")

# create frame
frame = simplegui.create_frame("timegame", 300,300)

# register event handlers
start_button = frame.add_button("Start", start_handler, 150)
stop_button = frame.add_button("Stop", stop_handler, 150)
reset_button = frame.add_button("Reset", reset_handler, 150)
timer = simplegui.create_timer(100, incrementer)
frame.set_draw_handler(draw)

# start frame
frame.start()

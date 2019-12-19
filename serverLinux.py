import bluetooth
import socket
import pyautogui
import struct



uuid="00001101-0000-1000-8000-00805F9B34FB"
server_sock=bluetooth.BluetoothSocket( bluetooth.RFCOMM )
client_sock=bluetooth.BluetoothSocket(bluetooth.RFCOMM)
mac=""
port = bluetooth.PORT_ANY
#SCREEN_WIDTH=win32api.GetSystemMetrics(0)
#SCREEN_HEIGHT=win32api.GetSystemMetrics(1)

def unpack(buffer):
    return struct.unpack("i",buffer)[0]

def mouseMoved(data):
    print("In mousemoved")
    x=0
    y=0
    try:
        x=unpack(data[:4])
        y=unpack(data[4:8])
    except Exception as e:
        print( "Unpack Exception in MouseMoved")
        pass
    if(x>20):
        x=20
    if(x<-20):
        x=-20
    if(y>20):
       y=20
    if(y<20):
        y=-20
    pyautogui.moveRel(x,y);
    print("mouseMoved "+str(x)+","+str(y))



def keyPressed(data):
    print("In Keypressed")
    print(data+","+str(len(data)))
    '''if(data>0):
        key="{"+(data)+"}"
        if(data=='\n'):
            key="{ENTER}"
    else:
        key=chr(int(ord(data)))
    shell.SendKeys(key)'''
    pyautogui.typewrite(data)
    print("Exiting Keypressed")

def mouseLeftPressed():
    print("In mouseLeftpressed")
    pyautogui.mouseDown(button='left')
    print("mouseLeftPressed")
    

def mouseLeftReleased():
    print("In mouseLeftreleased")
    pyautogui.mouseUp(button='left')
    print("mouseLeftReleased")


def mouseRightPressed():
    print("In mouseRightpressed")
    pyautogui.mouseDown(button='right')
    print("mouseRightPressed")

def mouseRightReleased():
    print("In mouseRightReleased")
    pyautogui.mouseUp(button='right')
    print("mouseRightReleased")


def mouseWheelMoved(data):
    print("In mouseWheel")
    x=unpack(data[:4])
    y=unpack(data[4:8])
    '''px,py=win32api.GetCursorPos()
    if(abs(x)>abs(y)):
        win32api.mouse_event(win32con.MOUSEEVENTF_WHEEL| \
                     win32con.MOUSEEVENTF_ABSOLUTE,0,0,10*x,y)
    else:
        win32api.mouse_event(win32con.MOUSEEVENTF_WHEEL| \
                     win32con.MOUSEEVENTF_ABSOLUTE,0,0,10*y,x)'''
    print("mouseWheelmoved "+str(x)+str(y))


def main():
    global server_sock
    global client_sock
    def setup():
        global server_sock
        global client_sock
        server_sock.bind((mac,port))
        server_sock.listen(1)
        bluetooth.advertise_service( server_sock, "RemoteDesktop",
                           service_id = uuid,
                           service_classes = [ uuid, bluetooth.SERIAL_PORT_CLASS ],
                           profiles = [ bluetooth.SERIAL_PORT_PROFILE ]
                            )

        print("waiting for connections")
        client_sock,address = server_sock.accept()

        print ("Accepted connection from ",address)
    print("\n[!]DON'T CLOSE THIS WINDOW\n\nSERVER SUCCESSFULLY STARTED\nCONTROL THIS DEVICE FROM YOUR ANDROID PHONE\nMINIMIZE THIS WINDOW AND ENJOY THE SERVICE")
    setup()

    while True:
        try:
            data = client_sock.recv(20)
            #data=data.encode('utf-8')
            #data=data.decode('utf-8','ignore')
            #data=str(data)[1:].strip()
            print(data)
            if data==[]:
                print("E: Client Disconnected\nI:Retrying")
                raise Exception

            i=0
            while(len(data)>0):
                if(ord(data[i])==0):
                    print("lenght is"+str(len(data)))
                    mouseMoved(data[i+1:i+9])
                    data=data[i+9:]
                elif(ord(data[i])==1):
                    keyPressed(data[i+1])
                    data=data[i+2:]
                elif(ord(data[i])==2):
                    mouseLeftPressed()
                    data=data[i+2:]
                elif(ord(data[i])==3):
                    mouseLeftReleased()
                    data=data[i+2:]
                elif(ord(data[i])==4):
                    mouseRightPressed()
                    data=data[i+2:]
                elif(ord(data[i])==5):
                    mouseRightReleased()
                    data=data[i+2:]
                elif(ord(data[i])==6):
                    mouseWheelMoved(data[i+1:i+9])
                    data=data[i+9:]
                data=[]
        except ValueError as e:
            print ("E: From asscii conversion "+e)
        except Exception as e:
            print (e)
            client_sock.close()
            server_sock.close()
            server_sock=bluetooth.BluetoothSocket(bluetooth.RFCOMM)
            setup()
main()



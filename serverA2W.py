import bluetooth
import socket
import win32api
import win32com.client
import win32con
import struct


shell = win32com.client.Dispatch("WScript.Shell")
uuid="00001101-0000-1000-8000-00805F9B34FB"
server_sock=bluetooth.BluetoothSocket( bluetooth.RFCOMM )
client_sock=bluetooth.BluetoothSocket(bluetooth.RFCOMM)
mac=""
port = bluetooth.PORT_ANY
SCREEN_WIDTH=win32api.GetSystemMetrics(0)
SCREEN_HEIGHT=win32api.GetSystemMetrics(1)

def unpack(buffer):
    return struct.unpack("i",buffer)[0]

def mouseMoved(data):
    x=unpack(data[:4])
    y=unpack(data[4:8])

    global px
    global py
    global SCREEN_WIDTH
    global SCREEN_HEIGHT
    px,py=win32api.GetCursorPos()
    px=px+x
    py=py+y
    #print("mouseMoved "+str(px)+","+str(py)+","+str(x)+","+str(y))


    #win32api.mouse_event(win32con.MOUSEEVENTF_MOVE|win32con.MOUSEEVENTF_ABSOLUTE,int(px*65535.0/SCREEN_WIDTH),int(py*65535.0/SCREEN_HEIGHT))
    win32api.SetCursorPos((px,py))


def keyPressed(data,i):
    #print("key presed "+chr(data))
    #data=data.decode('utf-8')
    if(data[i]>0):
        key="{"+chr(data[i])+"}"
        if(chr(data[i])=='\n'):
            key="{ENTER}"
    else:
        key=chr(int(data[i]))
    shell.SendKeys(key)

def mouseLeftPressed():

    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTDOWN|\
                         win32con.MOUSEEVENTF_ABSOLUTE,0,0)
    #print("mouseLeftPressed")

def mouseLeftReleased():
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTUP| \
                     win32con.MOUSEEVENTF_ABSOLUTE,0,0)
    #print("mouseLeftReleased")


def mouseRightPressed():
    win32api.mouse_event(win32con.MOUSEEVENTF_RIGHTDOWN|\
                         win32con.MOUSEEVENTF_ABSOLUTE,0,0)


    #print("mouseRightPressed")

def mouseRightReleased():
    win32api.mouse_event(win32con.MOUSEEVENTF_RIGHTUP| \
                     win32con.MOUSEEVENTF_ABSOLUTE,0,0)
    #print("mouseRightReleased")


def mouseWheelMoved(data):
    x=unpack(data[:4])
    y=unpack(data[4:8])
    px,py=win32api.GetCursorPos()
    if(abs(x)>abs(y)):
        win32api.mouse_event(win32con.MOUSEEVENTF_WHEEL| \
                     win32con.MOUSEEVENTF_ABSOLUTE,0,0,10*x,y)
    else:
        win32api.mouse_event(win32con.MOUSEEVENTF_WHEEL| \
                     win32con.MOUSEEVENTF_ABSOLUTE,0,0,10*y,x)
    #print("mouseWheelmoved "+str(x)+str(y))


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

        #print("waiting for connections")
        client_sock,address = server_sock.accept()

        #print ("Accepted connection from ",address)
    print("\n[!]DON'T CLOSE THIS WINDOW\n\nSERVER SUCCESSFULLY STARTED\nCONTROL THIS DEVICE FROM YOUR ANDROID PHONE\nMINIMIZE THIS WINDOW AND ENJOY THE SERVICE")
    setup()
    while True:
        try:
            data = client_sock.recv(20)
            #data=data.decode('utf-8')
            #print(data)
            if data==[]:
                #print("E: Client Disconnected\nI:Retrying")
                raise Exception


            i=0
            j=len(data)
            while(j>i):
                if(data[i]==0):
                    mouseMoved(data[i+1:i+9])
                    #data=data[i+9:]
                    i=i+9
                elif(data[i]==1):
                    keyPressed(data,i+1)
                    #data=data[i+2:]
                    i=i+2
                elif(data[i]==2):
                    mouseLeftPressed()
                    #data=data[i+2:]
                    i=i+2
                elif(data[i]==3):
                    mouseLeftReleased()
                    data=data[i+2:]
                    i=i+2
                elif(data[i]==4):
                    mouseRightPressed()
                    #data=data[i+2:]
                    i=i+2
                elif(data[i]==5):
                    mouseRightReleased()
                    #data=data[i+2:]
                    i=i+2
                elif(data[i]==6):
                    mouseWheelMoved(data[i+1:i+9])
                    #data=data[i+9:]
                    i=i+9

        except Exception as e:
            print(e)
            client_sock.close()
            server_sock.close()
            server_sock=bluetooth.BluetoothSocket(bluetooth.RFCOMM)
            import win32api
            setup()
main()



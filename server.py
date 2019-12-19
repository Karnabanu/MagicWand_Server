import bluetooth
import socket
import win32api
import win32com.client
import win32con
import struct

shell = win32com.client.Dispatch("WScript.Shell")

uuid="00001101-0000-1000-8000-00805F9B34FB"#"0fee0450-e95f-11e5-a837-0800200c9a66"
server_sock=bluetooth.BluetoothSocket( bluetooth.RFCOMM )
mac=""#"90:48:9A:1B:2C:2C"
port = bluetooth.PORT_ANY
px=1
py=1

def unpack(buffer):
    return struct.unpack("I",buffer)[0]

def mouseMoved(data):
    win32api.SetCursorPos((unpack(data[:4]),unpack(data[4:8])))
    print"mouseMoved"

def keyPressed(data):
    if(int(data)>0):
        key="{"+chr(int(data))+"}"
    else:
        key=chr(int(data))
    shell.SendKeys(key)

def mouseLeftClicked(data):

    win32api.SetCursorPos((unpack(data[:4]),unpack(data[4:8])))
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTDOWN|\
                         win32con.MOUSEEVENTF_ABSOLUTE,0,0)
    win32api.mouse_event(win32con.MOUSEEVENTF_LEFTUP| \
                     win32con.MOUSEEVENTF_ABSOLUTE,0,0)
    print"mouseLeftClicked"

def mouseRightClicked(data):
    win32api.SetCursorPos((unpack(data[:4]),unpack(data[4:8])))
    win32api.mouse_event(win32con.MOUSEEVENTF_RIGHTDOWN|\
                         win32con.MOUSEEVENTF_ABSOLUTE,0,0)
    win32api.mouse_event(win32con.MOUSEEVENTF_RIGHTUP| \
                     win32con.MOUSEEVENTF_ABSOLUTE,0,0)

    print"mouseRightClicked"
def mouseLeftDoubleClicked(data):
    print"mouseLeftDoubleClicked"
def mouseRightDoubleClicked(data):
    print"mouseRightDoubleClicked"
def mouseWheelMoved(data):
    print"mouseWheelmoved"


def main():
    server_sock.bind((mac,port))
    server_sock.listen(1)
    bluetooth.advertise_service( server_sock, "RemoteDesktop",
                           service_id = uuid,
                           service_classes = [ uuid, bluetooth.SERIAL_PORT_CLASS ],
                           profiles = [ bluetooth.SERIAL_PORT_PROFILE ]
                            )
    print"waiting for connections"
    client_sock,address = server_sock.accept()

    print "Accepted connection from ",address

    while True:
        data = client_sock.recv(20)
        print "recived data "+data+"len "+str(len(data))

        if data==[]:
            print"E: Client Disconnected\nI:Retrying"
            main()
        #print "received [%s]" % data
        try:
            '''key=chr(int(data))
            if ((key=='{') or (key== '}') or( key== '%') or (key=='+')or (key=='^')or (key=='~')):
                key='{'+key+'}'
            '''
            if(ord(data[0])==0):
                mouseMoved(data[1:])
            elif(ord(data[0])==1):
                keyPressed(data[1:])
            elif(ord(data[0])==2):
                mouseLeftClicked(data[1:])
            elif(ord(data[0])==3):
                mouseRightClicked(data[1:])
            elif(ord(data[0])==4):
                mouseLeftDoubleClicked(data[1:])
            elif(ord(data[0])==5):
                mouseRightDoubleClicked(data[1:])
            elif(ord(data[0])==0):
                mouseWheelMoved(data[1:])
        except ValueError as e:
            print "E: From asscii conversion k"
    #hello!!SendInput(data)

    client_sock.close()
    server_sock.close()

main()
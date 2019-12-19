import bluetooth
import struct
#import win32api
import sys
import pythoncom, pyHook
buffer=''

uid="00001101-0000-1000-8000-00805F9B34FB"
bd_addr=str()
port=int()
sock=bluetooth.BluetoothSocket( bluetooth.RFCOMM )

def connect():
    #bd_addr = "90:48:9A:1B:2C:2C"
    #port = 25

    service=bluetooth.find_service(uuid=uid)
    if(len(service)==0):
        print "E:Error while getting service"
        return False
    serviceMatch=service[0]
    port=serviceMatch["port"]
    bd_addr=serviceMatch["host"]
    name=serviceMatch["name"]

    print name,bd_addr, port
    sock.connect((bd_addr, port))
    return True

def pack(number):
    if(number<0):
        number=0
    temp=struct.unpack("4B", struct.pack("I", number))
    buffer=''
    for item in temp:
        buffer+=chr(item)
    return buffer

def process():
    def OnMove(event):
        print 'I: Mouse Moved Position:',event.Position
        sock.send(chr(0)+pack(event.Position[0])+pack(event.Position[1]))
        return 1

    def OnLeftClick(event):
        print"I: Left clicked"
        sock.send(chr(2)+pack(event.Position[0])+pack(event.Position[1]))
        return 1

    def OnRightClick(event):
        print"I: Right clicked"
        sock.send(chr(3)+pack(event.Position[0])+pack(event.Position[1]))
        return 1

    def OnLeftDouble(event):
        print"I: Left double clicked"
        sock.send(chr(4)+pack(event.Position[0])+pack(event.Position[1]))
        return 1

    def OnRightDouble(event):
        print"I: Right double clicked"
        sock.send(chr(5)+pack(event.Position[0])+pack(event.Position[1]))
        return 1

    def OnWheelMoved(event):
        print"I: wheel moved"
        sock.send(chr(6)+pack(event.Position[0])+pack(event.Position[1]))
        return 1




    def onKeyboardEvent(event):
        #sock.send(chr(1)+str(event.Ascii))
        print(chr(1)+str(event.Ascii))
        return 1

    while True:
        hm=pyHook.HookManager()
        #hm=pyHook.HookManager()
        try:
            hm.KeyDown=onKeyboardEvent
            hm.MouseMove=OnMove
            hm.MouseLeftDbl=OnLeftDouble
            hm.MouseRightDbl=OnRightDouble
            hm.MouseLeftDown=OnLeftClick
            hm.MouseRightDown=OnRightClick
            hm.MouseWheel=OnWheelMoved
            hm.HookKeyboard()
            hm.HookMouse()
            pythoncom.PumpMessages()
        except TypeError as e:
            print "Error "+e
    sock.close()


def main():
    try:
        if(not(connect())):
            print "E: Conection failed"
            exit()
    except IOError as e:
        print "NO Device found"+e
        exit()
    while True:
        try:
            process()
        except IOError as e:
            print "E: Disconnected"+e
            try:
                connect()
            except IOError as e:
                print "E: Reconnction aborted"
                exit()
            print"I:Connection established"
            continue
main()


import pyHook
import pythoncom

def OnMove(event):
    print 'I: Mouse Moved Position:',event.Position
    return 1

def OnLeftClick(event):
    print"I: Left clicked"
    return 1

def OnRightClick(event):
    print"I: Right clicked"
    return 1

def OnLeftDouble(event):
    print"I: Left double clicked"
    return 1

def OnRightDouble(event):
    print"I: Right double clicked"
    return 1

def OnWheelMoved(event):
    print"I: wheel moved"
    return 1


hm = pyHook.HookManager()
#hm.SubscribeMouseAllButtonsDown(onclick)
#hm.MouseAll=onclick
hm.MouseMove=OnMove
hm.MouseLeftDbl=OnLeftDouble
hm.MouseRightDbl=OnRightDouble
hm.MouseLeftDown=OnLeftClick
hm.MouseRightDown=OnRightClick
hm.MouseWheel=OnWheelMoved


hm.HookMouse()
pythoncom.PumpMessages()
#hm.UnhookMouse()
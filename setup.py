from distutils.core import setup
import py2exe
import os

mfcfiles = [os.path.join('./dist', i) for i in ["mfc90.dll", "mfc90u.dll", "mfcm90.dll", "mfcm90u.dll", "Microsoft.VC90.MFC.manifest"]]
data_files = [("Microsoft.VC90.MFC", mfcfiles)]
setup(
    console=["serverA2W.py"],
    options={
        'py2exe':{
            'packages':['bluetooth']#,'win32.py','win32con.py','win32com.client.py','struct.py']
        }
    }
)

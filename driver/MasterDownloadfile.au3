Sleep(3000)
ControlFocus("Open", "", "Edit1")

Sleep(5000)

; Send the file location with date and time
ControlSend("Open", "", "Edit1", $CmdLine[1])

Sleep(5000)
ControlClick("Open", "", "Button1")

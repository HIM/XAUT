; CLW file contains information for the MFC ClassWizard

[General Info]
Version=1
LastClass=circleMidDlg
LastTemplate=CDialog
NewFileInclude1=#include "stdafx.h"
NewFileInclude2=#include "changfeng.h"
LastPage=0

ClassCount=12
Class1=CChangfengApp
Class2=CChangfengDoc
Class3=CChangfengView
Class4=CMainFrame

ResourceCount=9
Resource1=IDD_DIALOG1
Resource2=IDR_MAINFRAME
Resource3=IDD_DIALOG4
Class5=CChildFrame
Class6=CAboutDlg
Class7=circleBreDlg
Resource4=IDD_DIALOG2
Class8=LineDDADlg
Resource5=IDD_DIALOG5
Class9=LineZhuodianDlg
Resource6=IDD_DIALOG3
Class10=LineBresenhamDlg
Resource7=IDR_CHANGFTYPE
Class11=LineMidDlg
Resource8=IDD_ABOUTBOX
Class12=circleMidDlg
Resource9=IDD_DIALOG6

[CLS:CChangfengApp]
Type=0
HeaderFile=changfeng.h
ImplementationFile=changfeng.cpp
Filter=N

[CLS:CChangfengDoc]
Type=0
HeaderFile=changfengDoc.h
ImplementationFile=changfengDoc.cpp
Filter=N

[CLS:CChangfengView]
Type=0
HeaderFile=changfengView.h
ImplementationFile=changfengView.cpp
Filter=C
BaseClass=CView
VirtualFilter=VWC
LastObject=ID_LineBresenham


[CLS:CMainFrame]
Type=0
HeaderFile=MainFrm.h
ImplementationFile=MainFrm.cpp
Filter=T
LastObject=ID_circleBrehasenham


[CLS:CChildFrame]
Type=0
HeaderFile=ChildFrm.h
ImplementationFile=ChildFrm.cpp
Filter=M


[CLS:CAboutDlg]
Type=0
HeaderFile=changfeng.cpp
ImplementationFile=changfeng.cpp
Filter=D
LastObject=CAboutDlg

[DLG:IDD_ABOUTBOX]
Type=1
Class=CAboutDlg
ControlCount=4
Control1=IDC_STATIC,static,1342177283
Control2=IDC_STATIC,static,1342308480
Control3=IDC_STATIC,static,1342308352
Control4=IDOK,button,1342373889

[MNU:IDR_MAINFRAME]
Type=1
Class=CMainFrame
Command1=ID_FILE_NEW
Command2=ID_FILE_OPEN
Command3=ID_FILE_PRINT_SETUP
Command4=ID_FILE_MRU_FILE1
Command5=ID_APP_EXIT
Command6=ID_VIEW_TOOLBAR
Command7=ID_VIEW_STATUS_BAR
Command8=ID_APP_ABOUT
CommandCount=8

[TB:IDR_MAINFRAME]
Type=1
Class=CMainFrame
Command1=ID_FILE_NEW
Command2=ID_FILE_OPEN
Command3=ID_FILE_SAVE
Command4=ID_EDIT_CUT
Command5=ID_EDIT_COPY
Command6=ID_EDIT_PASTE
Command7=ID_FILE_PRINT
Command8=ID_APP_ABOUT
CommandCount=8

[MNU:IDR_CHANGFTYPE]
Type=1
Class=CChangfengView
Command1=ID_FILE_NEW
Command2=ID_FILE_OPEN
Command3=ID_FILE_CLOSE
Command4=ID_FILE_SAVE
Command5=ID_FILE_SAVE_AS
Command6=ID_FILE_PRINT
Command7=ID_FILE_PRINT_PREVIEW
Command8=ID_FILE_PRINT_SETUP
Command9=ID_FILE_MRU_FILE1
Command10=ID_APP_EXIT
Command11=ID_EDIT_UNDO
Command12=ID_EDIT_CUT
Command13=ID_EDIT_COPY
Command14=ID_EDIT_PASTE
Command15=ID_VIEW_TOOLBAR
Command16=ID_VIEW_STATUS_BAR
Command17=ID_WINDOW_NEW
Command18=ID_WINDOW_CASCADE
Command19=ID_WINDOW_TILE_HORZ
Command20=ID_WINDOW_ARRANGE
Command21=ID_APP_ABOUT
Command22=ID_LineDDA
Command23=ID_LineZhudian
Command24=ID_LineBresenham
Command25=ID_LineMid
Command26=ID_circleMid
Command27=ID_circleBresenham
Command28=ID_Arc
CommandCount=28

[ACL:IDR_MAINFRAME]
Type=1
Class=CMainFrame
Command1=ID_FILE_NEW
Command2=ID_FILE_OPEN
Command3=ID_FILE_SAVE
Command4=ID_FILE_PRINT
Command5=ID_EDIT_UNDO
Command6=ID_EDIT_CUT
Command7=ID_EDIT_COPY
Command8=ID_EDIT_PASTE
Command9=ID_EDIT_UNDO
Command10=ID_EDIT_CUT
Command11=ID_EDIT_COPY
Command12=ID_EDIT_PASTE
Command13=ID_NEXT_PANE
Command14=ID_PREV_PANE
CommandCount=14

[DLG:IDD_DIALOG1]
Type=1
Class=circleBreDlg
ControlCount=9
Control1=IDOK,button,1342242817
Control2=IDCANCEL,button,1342242816
Control3=IDC_STATIC,static,1342308352
Control4=IDC_STATIC,static,1342308352
Control5=IDC_STATIC,static,1342308352
Control6=IDC_STATIC,static,1342308352
Control7=IDC_circleBreX,edit,1350631552
Control8=IDC_circleBreY,edit,1350631552
Control9=IDC_circleBreR,edit,1350631552

[CLS:circleBreDlg]
Type=0
HeaderFile=circleBreDlg.h
ImplementationFile=circleBreDlg.cpp
BaseClass=CDialog
Filter=D
LastObject=circleBreDlg
VirtualFilter=dWC

[DLG:IDD_DIALOG2]
Type=1
Class=LineDDADlg
ControlCount=11
Control1=IDOK,button,1342242817
Control2=IDCANCEL,button,1342242816
Control3=IDC_STATIC,static,1342308352
Control4=IDC_LineDDAX1,edit,1350631552
Control5=IDC_STATIC,static,1342308352
Control6=IDC_STATIC,static,1342308352
Control7=IDC_LineDDAY1,edit,1350631552
Control8=IDC_STATIC,static,1342308352
Control9=IDC_LineDDAX2,edit,1350631552
Control10=IDC_STATIC,static,1342308352
Control11=IDC_LineDDAY2,edit,1350631552

[CLS:LineDDADlg]
Type=0
HeaderFile=LineDDADlg.h
ImplementationFile=LineDDADlg.cpp
BaseClass=CDialog
Filter=D
LastObject=IDC_LineDDAX1
VirtualFilter=dWC

[DLG:IDD_DIALOG3]
Type=1
Class=LineZhuodianDlg
ControlCount=11
Control1=IDOK,button,1342242817
Control2=IDCANCEL,button,1342242816
Control3=IDC_STATIC,static,1342308352
Control4=IDC_STATIC,static,1342308352
Control5=IDC_STATIC,static,1342308352
Control6=IDC_LineZhuodianX1,edit,1350631552
Control7=IDC_LineZhuodianX2,edit,1350631552
Control8=IDC_STATIC,static,1342308352
Control9=IDC_STATIC,static,1342308352
Control10=IDC_LineZhuodianY1,edit,1350631552
Control11=IDC_LineZhuodianY2,edit,1350631552

[CLS:LineZhuodianDlg]
Type=0
HeaderFile=LineZhuodianDlg.h
ImplementationFile=LineZhuodianDlg.cpp
BaseClass=CDialog
Filter=D
LastObject=ID_APP_ABOUT
VirtualFilter=dWC

[DLG:IDD_DIALOG4]
Type=1
Class=LineBresenhamDlg
ControlCount=11
Control1=IDOK,button,1342242817
Control2=IDCANCEL,button,1342242816
Control3=IDC_STATIC,static,1342308352
Control4=IDC_STATIC,static,1342308352
Control5=IDC_STATIC,static,1342308352
Control6=IDC_LineBreX1,edit,1350631552
Control7=IDC_LineBreY1,edit,1350631552
Control8=IDC_STATIC,static,1342308352
Control9=IDC_LineBreX2,edit,1350631552
Control10=IDC_STATIC,static,1342308352
Control11=IDC_LineBreY2,edit,1350631552

[CLS:LineBresenhamDlg]
Type=0
HeaderFile=LineBresenhamDlg.h
ImplementationFile=LineBresenhamDlg.cpp
BaseClass=CDialog
Filter=D
LastObject=ID_APP_ABOUT
VirtualFilter=dWC

[DLG:IDD_DIALOG5]
Type=1
Class=LineMidDlg
ControlCount=11
Control1=IDOK,button,1342242817
Control2=IDCANCEL,button,1342242816
Control3=IDC_STATIC,static,1342308352
Control4=IDC_STATIC,static,1342308352
Control5=IDC_LineMidX1,edit,1350631552
Control6=IDC_STATIC,static,1342308352
Control7=IDC_LineMidY1,edit,1350631552
Control8=IDC_STATIC,static,1342308352
Control9=IDC_LineMidX2,edit,1350631552
Control10=IDC_STATIC,static,1342308352
Control11=IDC_LineMidY2,edit,1350631552

[CLS:LineMidDlg]
Type=0
HeaderFile=LineMidDlg.h
ImplementationFile=LineMidDlg.cpp
BaseClass=CDialog
Filter=D
VirtualFilter=dWC
LastObject=ID_APP_ABOUT

[DLG:IDD_DIALOG6]
Type=1
Class=circleMidDlg
ControlCount=9
Control1=IDOK,button,1342242817
Control2=IDCANCEL,button,1342242816
Control3=IDC_STATIC,static,1342308352
Control4=IDC_STATIC,static,1342308352
Control5=IDC_circleMidX,edit,1350631552
Control6=IDC_STATIC,static,1342308352
Control7=IDC_circleMidY,edit,1350631552
Control8=IDC_STATIC,static,1342308352
Control9=IDC_circleMidR,edit,1350631552

[CLS:circleMidDlg]
Type=0
HeaderFile=circleMidDlg.h
ImplementationFile=circleMidDlg.cpp
BaseClass=CDialog
Filter=D
LastObject=IDC_circleMidR
VirtualFilter=dWC


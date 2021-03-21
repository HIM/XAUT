// changfeng.h : main header file for the CHANGFENG application
//

#if !defined(AFX_CHANGFENG_H__B6A1BC40_377D_4119_9BD3_92A6A1076E4F__INCLUDED_)
#define AFX_CHANGFENG_H__B6A1BC40_377D_4119_9BD3_92A6A1076E4F__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// CChangfengApp:
// See changfeng.cpp for the implementation of this class
//

class CChangfengApp : public CWinApp
{
public:
	CChangfengApp();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CChangfengApp)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation
	//{{AFX_MSG(CChangfengApp)
	afx_msg void OnAppAbout();
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_CHANGFENG_H__B6A1BC40_377D_4119_9BD3_92A6A1076E4F__INCLUDED_)

// testfirst.h : main header file for the TESTFIRST application
//

#if !defined(AFX_TESTFIRST_H__48E17A24_1F37_47C4_AFAE_336BCCD7BC28__INCLUDED_)
#define AFX_TESTFIRST_H__48E17A24_1F37_47C4_AFAE_336BCCD7BC28__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#ifndef __AFXWIN_H__
	#error include 'stdafx.h' before including this file for PCH
#endif

#include "resource.h"       // main symbols

/////////////////////////////////////////////////////////////////////////////
// CTestfirstApp:
// See testfirst.cpp for the implementation of this class
//

class CTestfirstApp : public CWinApp
{
public:
	CTestfirstApp();

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CTestfirstApp)
	public:
	virtual BOOL InitInstance();
	//}}AFX_VIRTUAL

// Implementation
	//{{AFX_MSG(CTestfirstApp)
	afx_msg void OnAppAbout();
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};


/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_TESTFIRST_H__48E17A24_1F37_47C4_AFAE_336BCCD7BC28__INCLUDED_)

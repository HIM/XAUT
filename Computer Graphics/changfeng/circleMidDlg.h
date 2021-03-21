#if !defined(AFX_CIRCLEMIDDLG_H__EC2FE8C2_26CD_47F6_9439_7C082AC09287__INCLUDED_)
#define AFX_CIRCLEMIDDLG_H__EC2FE8C2_26CD_47F6_9439_7C082AC09287__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// circleMidDlg.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// circleMidDlg dialog

class circleMidDlg : public CDialog
{
// Construction
public:
	circleMidDlg(CWnd* pParent = NULL);   // standard constructor

// Dialog Data
	//{{AFX_DATA(circleMidDlg)
	enum { IDD = IDD_DIALOG6 };
	int		m_circleMidR;
	int		m_circleMidX;
	int		m_circleMidY;
	//}}AFX_DATA


// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(circleMidDlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:

	// Generated message map functions
	//{{AFX_MSG(circleMidDlg)
		// NOTE: the ClassWizard will add member functions here
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_CIRCLEMIDDLG_H__EC2FE8C2_26CD_47F6_9439_7C082AC09287__INCLUDED_)

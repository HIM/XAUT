#if !defined(AFX_LINEDDADLG_H__51976DEF_7661_42B6_BE14_629F7CA9B859__INCLUDED_)
#define AFX_LINEDDADLG_H__51976DEF_7661_42B6_BE14_629F7CA9B859__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// LineDDADlg.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// LineDDADlg dialog

class LineDDADlg : public CDialog
{
// Construction
public:
	LineDDADlg(CWnd* pParent = NULL);   // standard constructor

// Dialog Data
	//{{AFX_DATA(LineDDADlg)
	enum { IDD = IDD_DIALOG2 };
	double	m_LineDDAX1;
	double	m_LineDDAY2;
	double	m_LIneDDAY1;
	double	m_LineDDAX2;
	//}}AFX_DATA


// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(LineDDADlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:

	// Generated message map functions
	//{{AFX_MSG(LineDDADlg)
		// NOTE: the ClassWizard will add member functions here
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_LINEDDADLG_H__51976DEF_7661_42B6_BE14_629F7CA9B859__INCLUDED_)

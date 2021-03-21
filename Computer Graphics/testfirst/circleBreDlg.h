#if !defined(AFX_CIRCLEBREDLG_H__03AB77D6_05FA_44D1_BC7F_256B0426B1D5__INCLUDED_)
#define AFX_CIRCLEBREDLG_H__03AB77D6_05FA_44D1_BC7F_256B0426B1D5__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// circleBreDlg.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// circleBreDlg dialog

class circleBreDlg : public CDialog
{
// Construction
public:
	circleBreDlg(CWnd* pParent = NULL);   // standard constructor

// Dialog Data
	//{{AFX_DATA(circleBreDlg)
	enum { IDD = IDD_DIALOG1 };
	int		m_CircleBreR;
	int		m_CircleBreX;
	int		m_CircleBreY;
	//}}AFX_DATA


// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(circleBreDlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:

	// Generated message map functions
	//{{AFX_MSG(circleBreDlg)
		// NOTE: the ClassWizard will add member functions here
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_CIRCLEBREDLG_H__03AB77D6_05FA_44D1_BC7F_256B0426B1D5__INCLUDED_)

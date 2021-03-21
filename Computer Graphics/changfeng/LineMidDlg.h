#if !defined(AFX_LINEMIDDLG_H__C40DA0D4_AE80_4A66_B71A_88F8093C9FAC__INCLUDED_)
#define AFX_LINEMIDDLG_H__C40DA0D4_AE80_4A66_B71A_88F8093C9FAC__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// LineMidDlg.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// LineMidDlg dialog

class LineMidDlg : public CDialog
{
// Construction
public:
	LineMidDlg(CWnd* pParent = NULL);   // standard constructor

// Dialog Data
	//{{AFX_DATA(LineMidDlg)
	enum { IDD = IDD_DIALOG5 };
	int		m_LineMidX1;
	int		m_LineMidX2;
	int		m_LineMidY1;
	int		m_LineMidY2;
	//}}AFX_DATA


// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(LineMidDlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:

	// Generated message map functions
	//{{AFX_MSG(LineMidDlg)
		// NOTE: the ClassWizard will add member functions here
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_LINEMIDDLG_H__C40DA0D4_AE80_4A66_B71A_88F8093C9FAC__INCLUDED_)

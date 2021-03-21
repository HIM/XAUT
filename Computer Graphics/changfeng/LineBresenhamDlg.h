#if !defined(AFX_LINEBRESENHAMDLG_H__00F869DD_546B_46D2_9D34_FAA6C1A17296__INCLUDED_)
#define AFX_LINEBRESENHAMDLG_H__00F869DD_546B_46D2_9D34_FAA6C1A17296__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// LineBresenhamDlg.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// LineBresenhamDlg dialog

class LineBresenhamDlg : public CDialog
{
// Construction
public:
	LineBresenhamDlg(CWnd* pParent = NULL);   // standard constructor

// Dialog Data
	//{{AFX_DATA(LineBresenhamDlg)
	enum { IDD = IDD_DIALOG4 };
	int		m_LineBreX1;
	int		m_LineBreX2;
	int		m_LineBreY1;
	int		m_LineBreY2;
	//}}AFX_DATA


// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(LineBresenhamDlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:

	// Generated message map functions
	//{{AFX_MSG(LineBresenhamDlg)
		// NOTE: the ClassWizard will add member functions here
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_LINEBRESENHAMDLG_H__00F869DD_546B_46D2_9D34_FAA6C1A17296__INCLUDED_)

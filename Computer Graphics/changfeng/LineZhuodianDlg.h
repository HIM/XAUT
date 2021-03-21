#if !defined(AFX_LINEZHUODIANDLG_H__CBEF3920_E597_448F_8121_6AB126BCD080__INCLUDED_)
#define AFX_LINEZHUODIANDLG_H__CBEF3920_E597_448F_8121_6AB126BCD080__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000
// LineZhuodianDlg.h : header file
//

/////////////////////////////////////////////////////////////////////////////
// LineZhuodianDlg dialog

class LineZhuodianDlg : public CDialog
{
// Construction
public:
	LineZhuodianDlg(CWnd* pParent = NULL);   // standard constructor

// Dialog Data
	//{{AFX_DATA(LineZhuodianDlg)
	enum { IDD = IDD_DIALOG3 };
	int		m_LineZhuodianX1;
	int		m_LineZhuodianX2;
	int		m_LineZhuodianY1;
	int		m_LineZhuodianY2;
	//}}AFX_DATA


// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(LineZhuodianDlg)
	protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support
	//}}AFX_VIRTUAL

// Implementation
protected:

	// Generated message map functions
	//{{AFX_MSG(LineZhuodianDlg)
		// NOTE: the ClassWizard will add member functions here
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_LINEZHUODIANDLG_H__CBEF3920_E597_448F_8121_6AB126BCD080__INCLUDED_)

// LineZhuodianDlg.cpp : implementation file
//

#include "stdafx.h"
#include "changfeng.h"
#include "LineZhuodianDlg.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// LineZhuodianDlg dialog


LineZhuodianDlg::LineZhuodianDlg(CWnd* pParent /*=NULL*/)
	: CDialog(LineZhuodianDlg::IDD, pParent)
{
	//{{AFX_DATA_INIT(LineZhuodianDlg)
	m_LineZhuodianX1 = 0;
	m_LineZhuodianX2 = 0;
	m_LineZhuodianY1 = 0;
	m_LineZhuodianY2 = 0;
	//}}AFX_DATA_INIT
}


void LineZhuodianDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(LineZhuodianDlg)
	DDX_Text(pDX, IDC_LineZhuodianX1, m_LineZhuodianX1);
	DDX_Text(pDX, IDC_LineZhuodianX2, m_LineZhuodianX2);
	DDX_Text(pDX, IDC_LineZhuodianY1, m_LineZhuodianY1);
	DDX_Text(pDX, IDC_LineZhuodianY2, m_LineZhuodianY2);
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(LineZhuodianDlg, CDialog)
	//{{AFX_MSG_MAP(LineZhuodianDlg)
		// NOTE: the ClassWizard will add message map macros here
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// LineZhuodianDlg message handlers

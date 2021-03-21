// LineMidDlg.cpp : implementation file
//

#include "stdafx.h"
#include "changfeng.h"
#include "LineMidDlg.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// LineMidDlg dialog


LineMidDlg::LineMidDlg(CWnd* pParent /*=NULL*/)
	: CDialog(LineMidDlg::IDD, pParent)
{
	//{{AFX_DATA_INIT(LineMidDlg)
	m_LineMidX1 = 0;
	m_LineMidX2 = 0;
	m_LineMidY1 = 0;
	m_LineMidY2 = 0;
	//}}AFX_DATA_INIT
}


void LineMidDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(LineMidDlg)
	DDX_Text(pDX, IDC_LineMidX1, m_LineMidX1);
	DDX_Text(pDX, IDC_LineMidX2, m_LineMidX2);
	DDX_Text(pDX, IDC_LineMidY1, m_LineMidY1);
	DDX_Text(pDX, IDC_LineMidY2, m_LineMidY2);
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(LineMidDlg, CDialog)
	//{{AFX_MSG_MAP(LineMidDlg)
		// NOTE: the ClassWizard will add message map macros here
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// LineMidDlg message handlers

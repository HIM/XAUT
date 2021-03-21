// LineDDADlg.cpp : implementation file
//

#include "stdafx.h"
#include "changfeng.h"
#include "LineDDADlg.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// LineDDADlg dialog


LineDDADlg::LineDDADlg(CWnd* pParent /*=NULL*/)
	: CDialog(LineDDADlg::IDD, pParent)
{
	//{{AFX_DATA_INIT(LineDDADlg)
	m_LineDDAX1 = 0.0;
	m_LineDDAY2 = 0.0;
	m_LIneDDAY1 = 0.0;
	m_LineDDAX2 = 0.0;
	//}}AFX_DATA_INIT
}


void LineDDADlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(LineDDADlg)
	DDX_Text(pDX, IDC_LineDDAX1, m_LineDDAX1);
	DDX_Text(pDX, IDC_LineDDAY2, m_LineDDAY2);
	DDX_Text(pDX, IDC_LineDDAY1, m_LIneDDAY1);
	DDX_Text(pDX, IDC_LineDDAX2, m_LineDDAX2);
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(LineDDADlg, CDialog)
	//{{AFX_MSG_MAP(LineDDADlg)
		// NOTE: the ClassWizard will add message map macros here
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// LineDDADlg message handlers

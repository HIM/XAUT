// circleBreDlg.cpp : implementation file
//

#include "stdafx.h"
#include "testfirst.h"
#include "circleBreDlg.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// circleBreDlg dialog


circleBreDlg::circleBreDlg(CWnd* pParent /*=NULL*/)
	: CDialog(circleBreDlg::IDD, pParent)
{
	//{{AFX_DATA_INIT(circleBreDlg)
	m_CircleBreR = 0;
	m_CircleBreX = 0;
	m_CircleBreY = 0;
	//}}AFX_DATA_INIT
}


void circleBreDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(circleBreDlg)
	DDX_Text(pDX, IDC_R, m_CircleBreR);
	DDX_Text(pDX, IDC_X, m_CircleBreX);
	DDX_Text(pDX, IDC_Y, m_CircleBreY);
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(circleBreDlg, CDialog)
	//{{AFX_MSG_MAP(circleBreDlg)
		// NOTE: the ClassWizard will add message map macros here
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// circleBreDlg message handlers

// circleBreDlg.cpp : implementation file
//

#include "stdafx.h"
#include "changfeng.h"
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
	m_circleBreR = 0.0;
	m_circleBreX = 0.0;
	m_circleBreY = 0.0;
	//}}AFX_DATA_INIT
}


void circleBreDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(circleBreDlg)
	DDX_Text(pDX, IDC_circleBreR, m_circleBreR);
	DDX_Text(pDX, IDC_circleBreX, m_circleBreX);
	DDX_Text(pDX, IDC_circleBreY, m_circleBreY);
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(circleBreDlg, CDialog)
	//{{AFX_MSG_MAP(circleBreDlg)
	ON_COMMAND(ID_circleBrehasenham, OncircleBrehasenham)
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// circleBreDlg message handlers

void circleBreDlg::OncircleBrehasenham() 
{
	// TODO: Add your command handler code here
	
}

// circleMidDlg.cpp : implementation file
//

#include "stdafx.h"
#include "changfeng.h"
#include "circleMidDlg.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// circleMidDlg dialog


circleMidDlg::circleMidDlg(CWnd* pParent /*=NULL*/)
	: CDialog(circleMidDlg::IDD, pParent)
{
	//{{AFX_DATA_INIT(circleMidDlg)
	m_circleMidR = 0;
	m_circleMidX = 0;
	m_circleMidY = 0;
	//}}AFX_DATA_INIT
}


void circleMidDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(circleMidDlg)
	DDX_Text(pDX, IDC_circleMidR, m_circleMidR);
	DDX_Text(pDX, IDC_circleMidX, m_circleMidX);
	DDX_Text(pDX, IDC_circleMidY, m_circleMidY);
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(circleMidDlg, CDialog)
	//{{AFX_MSG_MAP(circleMidDlg)
		// NOTE: the ClassWizard will add message map macros here
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// circleMidDlg message handlers

// LineBresenhamDlg.cpp : implementation file
//

#include "stdafx.h"
#include "changfeng.h"
#include "LineBresenhamDlg.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// LineBresenhamDlg dialog


LineBresenhamDlg::LineBresenhamDlg(CWnd* pParent /*=NULL*/)
	: CDialog(LineBresenhamDlg::IDD, pParent)
{
	//{{AFX_DATA_INIT(LineBresenhamDlg)
	m_LineBreX1 = 0;
	m_LineBreX2 = 0;
	m_LineBreY1 = 0;
	m_LineBreY2 = 0;
	//}}AFX_DATA_INIT
}


void LineBresenhamDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialog::DoDataExchange(pDX);
	//{{AFX_DATA_MAP(LineBresenhamDlg)
	DDX_Text(pDX, IDC_LineBreX1, m_LineBreX1);
	DDX_Text(pDX, IDC_LineBreX2, m_LineBreX2);
	DDX_Text(pDX, IDC_LineBreY1, m_LineBreY1);
	DDX_Text(pDX, IDC_LineBreY2, m_LineBreY2);
	//}}AFX_DATA_MAP
}


BEGIN_MESSAGE_MAP(LineBresenhamDlg, CDialog)
	//{{AFX_MSG_MAP(LineBresenhamDlg)
		// NOTE: the ClassWizard will add message map macros here
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// LineBresenhamDlg message handlers

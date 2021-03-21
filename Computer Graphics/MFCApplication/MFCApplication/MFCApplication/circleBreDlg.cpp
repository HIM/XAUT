// circleBreDlg.cpp: 实现文件
//

#include "pch.h"
#include "MFCApplication.h"
#include "circleBreDlg.h"
#include "afxdialogex.h"


// circleBreDlg 对话框

IMPLEMENT_DYNAMIC(circleBreDlg, CDialogEx)

circleBreDlg::circleBreDlg(CWnd* pParent /*=nullptr*/)
	: CDialogEx(IDD_DIALOG1, pParent)
	, m_CircleBreR(0)
	, m_CircleBreX(0)
	, m_CircleBreY(0)
{

}

circleBreDlg::~circleBreDlg()
{
}

void circleBreDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
	DDX_Text(pDX, IDC_R, m_CircleBreR);
	DDX_Text(pDX, IDC_X, m_CircleBreX);
	DDX_Text(pDX, IDC_Y, m_CircleBreY);
}


BEGIN_MESSAGE_MAP(circleBreDlg, CDialogEx)
END_MESSAGE_MAP()


// circleBreDlg 消息处理程序

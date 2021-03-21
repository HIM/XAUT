// circleMidDlg.cpp: 实现文件
//

#include "pch.h"
#include "MFCApplication.h"
#include "circleMidDlg.h"
#include "afxdialogex.h"


// circleMidDlg 对话框

IMPLEMENT_DYNAMIC(circleMidDlg, CDialogEx)

circleMidDlg::circleMidDlg(CWnd* pParent /*=nullptr*/)
	: CDialogEx(IDD_DIALOG3, pParent)
	, m_circleMidR(0)
	, circleMidX(0)
	, circleMidY(0)
{

}

circleMidDlg::~circleMidDlg()
{
}

void circleMidDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
	DDX_Text(pDX, IDC_circleMidR, m_circleMidR);
	DDX_Text(pDX, IDC_circleMidX, circleMidX);
	DDX_Text(pDX, IDC_EcircleMidY, circleMidY);
}


BEGIN_MESSAGE_MAP(circleMidDlg, CDialogEx)
END_MESSAGE_MAP()


// circleMidDlg 消息处理程序

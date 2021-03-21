// onePoint.cpp: 实现文件
//

#include "pch.h"
#include "MFCApplication.h"
#include "onePoint.h"
#include "afxdialogex.h"


// onePoint 对话框

IMPLEMENT_DYNAMIC(onePoint, CDialogEx)

onePoint::onePoint(CWnd* pParent /*=nullptr*/)
	: CDialogEx(IDD_DIALOG4, pParent)
	, m_onePointX(0)
	, m_onePointY(0)
{

}

onePoint::~onePoint()
{
}

void onePoint::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
	DDX_Text(pDX, IDC_onePointX, m_onePointX);
	DDX_Text(pDX, IDC_onePointY, m_onePointY);
}


BEGIN_MESSAGE_MAP(onePoint, CDialogEx)
END_MESSAGE_MAP()


// onePoint 消息处理程序

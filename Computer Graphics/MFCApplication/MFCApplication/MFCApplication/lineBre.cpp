// lineBre.cpp: 实现文件
//

#include "pch.h"
#include "MFCApplication.h"
#include "lineBre.h"
#include "afxdialogex.h"


// lineBre 对话框

IMPLEMENT_DYNAMIC(lineBre, CDialogEx)

lineBre::lineBre(CWnd* pParent /*=nullptr*/)
	: CDialogEx(IDD_DIALOG2, pParent)
	, m_LineBreX1(0)
	, m_LineBreX2(0)
	, m_LineBreY1(0)
	, m_LineBreY2(0)
{

}

lineBre::~lineBre()
{
}

void lineBre::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
	//  DDX_Text(pDX, IDC_X0, m_LineMidX1);
	//  DDX_Text(pDX, IDC_X1, m_LineMidY1);
	//  DDX_Text(pDX, IDC_X0, m_LineMidX0);
	//  DDX_Text(pDX, IDC_X1, m_LineMidX1);
	//  DDX_Text(pDX, IDC_Y0, m_LineMidY0);
	//  DDX_Text(pDX, IDC_Y1, m_LineMidY1);
	DDX_Text(pDX, IDC_X0, m_LineBreX1);
	DDX_Text(pDX, IDC_X1, m_LineBreX2);
	DDX_Text(pDX, IDC_Y0, m_LineBreY1);
	DDX_Text(pDX, IDC_Y1, m_LineBreY2);
}


BEGIN_MESSAGE_MAP(lineBre, CDialogEx)
END_MESSAGE_MAP()


// lineBre 消息处理程序

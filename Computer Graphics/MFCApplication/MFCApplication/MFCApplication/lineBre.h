#pragma once


// lineBre 对话框

class lineBre : public CDialogEx
{
	DECLARE_DYNAMIC(lineBre)

public:
	lineBre(CWnd* pParent = nullptr);   // 标准构造函数
	virtual ~lineBre();

// 对话框数据
#ifdef AFX_DESIGN_TIME
	enum { IDD = IDD_DIALOG2 };
#endif

protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV 支持

	DECLARE_MESSAGE_MAP()
public:
//	int m_LineMidX0;
//	int m_LineMidX1;
//	int m_LineMidY0;
//	int m_LineMidY1;
	int m_LineBreX1;
	int m_LineBreX2;
	int m_LineBreY1;
	int m_LineBreY2;
};

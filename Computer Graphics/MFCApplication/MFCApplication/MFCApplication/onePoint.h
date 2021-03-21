#pragma once


// onePoint 对话框

class onePoint : public CDialogEx
{
	DECLARE_DYNAMIC(onePoint)

public:
	onePoint(CWnd* pParent = nullptr);   // 标准构造函数
	virtual ~onePoint();

// 对话框数据
#ifdef AFX_DESIGN_TIME
	enum { IDD = IDD_DIALOG4 };
#endif

protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV 支持

	DECLARE_MESSAGE_MAP()
public:
	int m_onePointX;
	int m_onePointY;
};

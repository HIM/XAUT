#pragma once


// circleMidDlg 对话框

class circleMidDlg : public CDialogEx
{
	DECLARE_DYNAMIC(circleMidDlg)

public:
	circleMidDlg(CWnd* pParent = nullptr);   // 标准构造函数
	virtual ~circleMidDlg();

// 对话框数据
#ifdef AFX_DESIGN_TIME
	enum { IDD = IDD_DIALOG3 };
#endif

protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV 支持

	DECLARE_MESSAGE_MAP()
public:
	int m_circleMidR;
	int circleMidX;
	int circleMidY;
};

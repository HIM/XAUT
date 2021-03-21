
// MFCApplicationView.h: CMFCApplicationView 类的接口
//

#pragma once


class CMFCApplicationView : public CView
{
protected: // 仅从序列化创建
	CMFCApplicationView() noexcept;
	DECLARE_DYNCREATE(CMFCApplicationView)

// 特性
public:
	CMFCApplicationDoc* GetDocument() const;

	int x0;
	int y0;
	int R;

	//bre画线
	int X1,X2,Y1,Y2;
	//中点画圆
	double circleBreR;

// 操作
public:
	void circlePoint(int x, int y);
	void circleBre();
	//bre画线
	void LineBrehsenham(int x1, int y1, int x2, int y2);
	void swap_value(int* a, int* b);
	//中点画圆
	void circleMid(double x0, double y0, double r);

// 重写
public:
	virtual void OnDraw(CDC* pDC);  // 重写以绘制该视图
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
protected:
	virtual BOOL OnPreparePrinting(CPrintInfo* pInfo);
	virtual void OnBeginPrinting(CDC* pDC, CPrintInfo* pInfo);
	virtual void OnEndPrinting(CDC* pDC, CPrintInfo* pInfo);

// 实现
public:
	virtual ~CMFCApplicationView();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// 生成的消息映射函数
protected:
	afx_msg void OnFilePrintPreview();
	afx_msg void OnRButtonUp(UINT nFlags, CPoint point);
	afx_msg void OnContextMenu(CWnd* pWnd, CPoint point);
	DECLARE_MESSAGE_MAP()
public:
	afx_msg void OnCirclebre();
	afx_msg void OnLinebresenham();
	afx_msg void OnLinemid();
	afx_msg void Ononepoint();
};

#ifndef _DEBUG  // MFCApplicationView.cpp 中的调试版本
inline CMFCApplicationDoc* CMFCApplicationView::GetDocument() const
   { return reinterpret_cast<CMFCApplicationDoc*>(m_pDocument); }
#endif


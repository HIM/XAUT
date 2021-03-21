// changfengView.h : interface of the CChangfengView class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_CHANGFENGVIEW_H__7908BDA7_FD80_4557_AC6D_5C105893FB72__INCLUDED_)
#define AFX_CHANGFENGVIEW_H__7908BDA7_FD80_4557_AC6D_5C105893FB72__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CChangfengView : public CView
{
protected: // create from serialization only
	CChangfengView();
	DECLARE_DYNCREATE(CChangfengView)

// Attributes
public:
	CChangfengDoc* GetDocument();
	//直线算法相关函数定义
	void LineDDA(double x1, double y1, double x2, double y2);
	void LineZhudian(int x1, int y1, int x2, int y2);

	void swap_value(int *a, int *b);
	void LineBrehsenham(int x1, int y1, int x2, int y2);
	void LineMid(int x0, int y0, int x1, int y1);
	//曲线算法相关函数定义
	void circlePoint(double x, double y);
	void circleBre();
	void circleMid(double x0, double y0, double r);
// Operations
public:
	//直线算法顶点变量坐标定义
	double DDAx1,DDAx2,DDAy1,DDAy2;
	int X1,X2,Y1,Y2;

	//曲线算法相关点坐标变量定义
	double x0,y0;
	double circleBreR;


// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CChangfengView)
	public:
	virtual void OnDraw(CDC* pDC);  // overridden to draw this view
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
	protected:
	virtual BOOL OnPreparePrinting(CPrintInfo* pInfo);
	virtual void OnBeginPrinting(CDC* pDC, CPrintInfo* pInfo);
	virtual void OnEndPrinting(CDC* pDC, CPrintInfo* pInfo);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CChangfengView();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CChangfengView)
	afx_msg void OncircleBresenham();
	afx_msg void OnLineDDA();
	afx_msg void OnLineZhudian();
	afx_msg void OnLineBresenham();
	afx_msg void OnLineMid();
	afx_msg void OncircleMid();
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

#ifndef _DEBUG  // debug version in changfengView.cpp
inline CChangfengDoc* CChangfengView::GetDocument()
   { return (CChangfengDoc*)m_pDocument; }
#endif

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_CHANGFENGVIEW_H__7908BDA7_FD80_4557_AC6D_5C105893FB72__INCLUDED_)

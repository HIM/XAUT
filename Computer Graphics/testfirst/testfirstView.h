// testfirstView.h : interface of the CTestfirstView class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_TESTFIRSTVIEW_H__973E17A9_268A_4A6B_967D_E6ECE5C44D52__INCLUDED_)
#define AFX_TESTFIRSTVIEW_H__973E17A9_268A_4A6B_967D_E6ECE5C44D52__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CTestfirstView : public CView
{
protected: // create from serialization only
	CTestfirstView();
	DECLARE_DYNCREATE(CTestfirstView)

// Attributes
public:
	CTestfirstDoc* GetDocument();

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CTestfirstView)
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
	virtual ~CTestfirstView();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CTestfirstView)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

#ifndef _DEBUG  // debug version in testfirstView.cpp
inline CTestfirstDoc* CTestfirstView::GetDocument()
   { return (CTestfirstDoc*)m_pDocument; }
#endif

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_TESTFIRSTVIEW_H__973E17A9_268A_4A6B_967D_E6ECE5C44D52__INCLUDED_)

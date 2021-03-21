// testfirstDoc.h : interface of the CTestfirstDoc class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_TESTFIRSTDOC_H__08D405A5_4E8F_49B0_B264_4B768DA278F0__INCLUDED_)
#define AFX_TESTFIRSTDOC_H__08D405A5_4E8F_49B0_B264_4B768DA278F0__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CTestfirstDoc : public CDocument
{
protected: // create from serialization only
	CTestfirstDoc();
	DECLARE_DYNCREATE(CTestfirstDoc)

// Attributes
public:

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CTestfirstDoc)
	public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CTestfirstDoc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CTestfirstDoc)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_TESTFIRSTDOC_H__08D405A5_4E8F_49B0_B264_4B768DA278F0__INCLUDED_)

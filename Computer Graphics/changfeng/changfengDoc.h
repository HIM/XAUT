// changfengDoc.h : interface of the CChangfengDoc class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_CHANGFENGDOC_H__37F08D5D_0AEC_479F_A407_3273B984AE31__INCLUDED_)
#define AFX_CHANGFENGDOC_H__37F08D5D_0AEC_479F_A407_3273B984AE31__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CChangfengDoc : public CDocument
{
protected: // create from serialization only
	CChangfengDoc();
	DECLARE_DYNCREATE(CChangfengDoc)

// Attributes
public:

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CChangfengDoc)
	public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CChangfengDoc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CChangfengDoc)
		// NOTE - the ClassWizard will add and remove member functions here.
		//    DO NOT EDIT what you see in these blocks of generated code !
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
};

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_CHANGFENGDOC_H__37F08D5D_0AEC_479F_A407_3273B984AE31__INCLUDED_)

// testfirstDoc.cpp : implementation of the CTestfirstDoc class
//

#include "stdafx.h"
#include "testfirst.h"

#include "testfirstDoc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CTestfirstDoc

IMPLEMENT_DYNCREATE(CTestfirstDoc, CDocument)

BEGIN_MESSAGE_MAP(CTestfirstDoc, CDocument)
	//{{AFX_MSG_MAP(CTestfirstDoc)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CTestfirstDoc construction/destruction

CTestfirstDoc::CTestfirstDoc()
{
	// TODO: add one-time construction code here

}

CTestfirstDoc::~CTestfirstDoc()
{
}

BOOL CTestfirstDoc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: add reinitialization code here
	// (SDI documents will reuse this document)

	return TRUE;
}



/////////////////////////////////////////////////////////////////////////////
// CTestfirstDoc serialization

void CTestfirstDoc::Serialize(CArchive& ar)
{
	if (ar.IsStoring())
	{
		// TODO: add storing code here
	}
	else
	{
		// TODO: add loading code here
	}
}

/////////////////////////////////////////////////////////////////////////////
// CTestfirstDoc diagnostics

#ifdef _DEBUG
void CTestfirstDoc::AssertValid() const
{
	CDocument::AssertValid();
}

void CTestfirstDoc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CTestfirstDoc commands

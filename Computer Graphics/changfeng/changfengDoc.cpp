// changfengDoc.cpp : implementation of the CChangfengDoc class
//

#include "stdafx.h"
#include "changfeng.h"

#include "changfengDoc.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CChangfengDoc

IMPLEMENT_DYNCREATE(CChangfengDoc, CDocument)

BEGIN_MESSAGE_MAP(CChangfengDoc, CDocument)
	//{{AFX_MSG_MAP(CChangfengDoc)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CChangfengDoc construction/destruction

CChangfengDoc::CChangfengDoc()
{
	// TODO: add one-time construction code here

}

CChangfengDoc::~CChangfengDoc()
{
}

BOOL CChangfengDoc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: add reinitialization code here
	// (SDI documents will reuse this document)

	return TRUE;
}



/////////////////////////////////////////////////////////////////////////////
// CChangfengDoc serialization

void CChangfengDoc::Serialize(CArchive& ar)
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
// CChangfengDoc diagnostics

#ifdef _DEBUG
void CChangfengDoc::AssertValid() const
{
	CDocument::AssertValid();
}

void CChangfengDoc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CChangfengDoc commands

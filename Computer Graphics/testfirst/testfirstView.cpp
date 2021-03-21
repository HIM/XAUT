// testfirstView.cpp : implementation of the CTestfirstView class
//

#include "stdafx.h"
#include "testfirst.h"

#include "testfirstDoc.h"
#include "testfirstView.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CTestfirstView

IMPLEMENT_DYNCREATE(CTestfirstView, CView)

BEGIN_MESSAGE_MAP(CTestfirstView, CView)
	//{{AFX_MSG_MAP(CTestfirstView)
		// NOTE - the ClassWizard will add and remove mapping macros here.
		//    DO NOT EDIT what you see in these blocks of generated code!
	//}}AFX_MSG_MAP
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, CView::OnFilePrintPreview)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CTestfirstView construction/destruction

CTestfirstView::CTestfirstView()
{
	// TODO: add construction code here

}

CTestfirstView::~CTestfirstView()
{
}

BOOL CTestfirstView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CView::PreCreateWindow(cs);
}

/////////////////////////////////////////////////////////////////////////////
// CTestfirstView drawing

void CTestfirstView::OnDraw(CDC* pDC)
{
	CTestfirstDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	// TODO: add draw code for native data here
}

/////////////////////////////////////////////////////////////////////////////
// CTestfirstView printing

BOOL CTestfirstView::OnPreparePrinting(CPrintInfo* pInfo)
{
	// default preparation
	return DoPreparePrinting(pInfo);
}

void CTestfirstView::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add extra initialization before printing
}

void CTestfirstView::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add cleanup after printing
}

/////////////////////////////////////////////////////////////////////////////
// CTestfirstView diagnostics

#ifdef _DEBUG
void CTestfirstView::AssertValid() const
{
	CView::AssertValid();
}

void CTestfirstView::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CTestfirstDoc* CTestfirstView::GetDocument() // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CTestfirstDoc)));
	return (CTestfirstDoc*)m_pDocument;
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CTestfirstView message handlers

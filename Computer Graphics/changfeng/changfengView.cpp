// changfengView.cpp : implementation of the CChangfengView class
//

#include "stdafx.h"
#include "changfeng.h"

#include "changfengDoc.h"
#include "changfengView.h"

#include "circleBreDlg.h"
#include "LineDDADlg.h"
#include "LineZhuodianDlg.h"
#include "LineBresenhamDlg.h"
#include "LineMidDlg.h"
#include "circleMidDlg.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#undef THIS_FILE
static char THIS_FILE[] = __FILE__;
#endif

/////////////////////////////////////////////////////////////////////////////
// CChangfengView

IMPLEMENT_DYNCREATE(CChangfengView, CView)

BEGIN_MESSAGE_MAP(CChangfengView, CView)
	//{{AFX_MSG_MAP(CChangfengView)
	ON_COMMAND(ID_circleBresenham, OncircleBresenham)
	ON_COMMAND(ID_LineDDA, OnLineDDA)
	ON_COMMAND(ID_LineZhudian, OnLineZhudian)
	ON_COMMAND(ID_LineBresenham, OnLineBresenham)
	ON_COMMAND(ID_LineMid, OnLineMid)
	ON_COMMAND(ID_circleMid, OncircleMid)
	//}}AFX_MSG_MAP
	// Standard printing commands
	ON_COMMAND(ID_FILE_PRINT, CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, CView::OnFilePrintPreview)
END_MESSAGE_MAP()

/////////////////////////////////////////////////////////////////////////////
// CChangfengView construction/destruction

CChangfengView::CChangfengView()
{
	// TODO: add construction code here

}

CChangfengView::~CChangfengView()
{
}

BOOL CChangfengView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: Modify the Window class or styles here by modifying
	//  the CREATESTRUCT cs

	return CView::PreCreateWindow(cs);
}

/////////////////////////////////////////////////////////////////////////////
// CChangfengView drawing

void CChangfengView::OnDraw(CDC* pDC)
{
	CChangfengDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	// TODO: add draw code for native data here
}

/////////////////////////////////////////////////////////////////////////////
// CChangfengView printing

BOOL CChangfengView::OnPreparePrinting(CPrintInfo* pInfo)
{
	// default preparation
	return DoPreparePrinting(pInfo);
}

void CChangfengView::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add extra initialization before printing
}

void CChangfengView::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: add cleanup after printing
}

/////////////////////////////////////////////////////////////////////////////
// CChangfengView diagnostics

#ifdef _DEBUG
void CChangfengView::AssertValid() const
{
	CView::AssertValid();
}

void CChangfengView::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CChangfengDoc* CChangfengView::GetDocument() // non-debug version is inline
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CChangfengDoc)));
	return (CChangfengDoc*)m_pDocument;
}
#endif //_DEBUG

/////////////////////////////////////////////////////////////////////////////
// CChangfengView message handlers
//***********************************Bresenham画圆算法begin*******************************///
void CChangfengView::OncircleBresenham() 
{
	// TODO: Add your command handler code here
	circleBreDlg dlg; //定义输入框
	//dlg.DoModal();
	if(dlg.DoModal()==IDOK){ //输入框显示时
		circleBreR=dlg.m_circleBreR; //给全局变量进行赋值
		x0=dlg.m_circleBreX;
		y0=dlg.m_circleBreY;
	}
	AfxGetMainWnd()->SetWindowText("Bresenham画圆法"); //设置窗口的文字
	RedrawWindow(); //绘制窗口

	circleBre(); //调用画圆函数
}
void CChangfengView::circleBre() 
{
	// TODO: Add your command handler code here
	double x,y,d;
	x=0;
	y=(int)circleBreR;
	d=int(3-2*circleBreR);
	while(x<y){
		circlePoint(x,y);
		if(d<0){
			d=d+4*x+6;
		}else{
			d=d+4*(x-y)+10;
			y--;
		}
		x++;
	}
	if(x==y){
		circlePoint(x,y);
	}
}
void CChangfengView::circlePoint(double x, double y) 
{
	// TODO: Add your command handler code here
	CClientDC dc(this); //添加上下文，确定画布
	COLORREF rgb=RGB(0,0,225); //添加画笔颜色

	dc.SetPixel(x0+x, y0+y, rgb);
	dc.SetPixel(x0+y, y0+x, rgb);
	dc.SetPixel(x0+y, y0-x, rgb);
	dc.SetPixel(x0+x, y0-y, rgb);
	dc.SetPixel(x0-x, y0-y, rgb);
	dc.SetPixel(x0-y, y0-x, rgb);
	dc.SetPixel(x0-y, y0+x, rgb);
	dc.SetPixel(x0-x, y0+y, rgb);
}
//***********************************Bresenham画圆算法end*******************************///

//***********************************DDA直线算法begin*******************************///
void CChangfengView::OnLineDDA() 
{
	// TODO: Add your command handler code here
	LineDDADlg dlg;
	if(dlg.DoModal()==IDOK){
		DDAx1=dlg.m_LineDDAX1;
		DDAx2=dlg.m_LineDDAX2;
		DDAy1=dlg.m_LIneDDAY1;
		DDAy2=dlg.m_LineDDAY2;
	}
	AfxGetMainWnd()->SetWindowText("DDA直线算法");
	RedrawWindow();

	LineDDA(DDAx1, DDAy1, DDAx2, DDAy2);
}
void CChangfengView::LineDDA(double x1, double y1, double x2, double y2)
{
	// TODO: Add your command handler code here
	CClientDC dc(this);
	COLORREF rgb=RGB(0,0,225);

	double dm=0;
	if(abs(x2-x1)>=abs(y2-y1)){
		dm=abs(x2-x1);
	}else{
		dm=abs(y2-y1);
	}
	double dx=(x2-x1)/dm;
	double dy=(y2-y1)/dm;
	double x=x1+0.5;
	double y=y1+0.5;
	for(int i=0;i<dm;i++){
		dc.SetPixel(x, y, rgb);
		x=x+dx;
		y=y+dy;
	}
}
//***********************************DDA直线算法end*******************************///

//***********************************逐点比较直线算法begin*******************************///
void CChangfengView::OnLineZhudian() 
{
	// TODO: Add your command handler code here
	LineZhuodianDlg dlg;
	if(dlg.DoModal()==IDOK){
		X1=dlg.m_LineZhuodianX1;
		X2=dlg.m_LineZhuodianX2;
		Y1=dlg.m_LineZhuodianY1;
		Y2=dlg.m_LineZhuodianY2;
	}
	AfxGetMainWnd()->SetWindowText("逐点比较直线算法");
	RedrawWindow();

	LineZhudian(X1, Y1, X2, Y2);
}
void CChangfengView::LineZhudian(int x1, int y1, int x2, int y2)
{
	// TODO: Add your command handler code here
	CClientDC dc(this);
	COLORREF rgb=RGB(0,0,225);
	
	int x,y,xA,yA;
	if(y1>y2){
		yA=y1-y2;
		xA=x1-x2;
	}else{
		yA=y2-y1;
		xA=x2-x1;
	}
	int F=x=y=0;
	int n=abs(xA)+abs(yA);
	for(int i=0;i<n;i++){
		if(xA>0){
			if(F>=0){ //斜率为正
				x++;
				F=F-yA;
			}else{
				y++;
				F=F+xA;
			}
		}else{ //斜率为负
			if(F>=0){
				y++;
				F=F+yA;
			}else{
				x--;
				F=F+yA;
			}
		}
		
		if(y1>y2){
			dc.SetPixel(x+x2, y+y2, rgb);
		}else{
			dc.SetPixel(x+x1, y+y1, rgb);
		}
	}
	
}
//***********************************逐点比较直线算法end*******************************///

//***********************************Bresenham直线算法begin*******************************///

void CChangfengView::OnLineBresenham() 
{
	// TODO: Add your command handler code here
	LineBresenhamDlg dlg;
	if(dlg.DoModal()==IDOK){
		X1=dlg.m_LineBreX1;
		X2=dlg.m_LineBreX2;
		Y1=dlg.m_LineBreY1;
		Y2=dlg.m_LineBreY2;
	}
	AfxGetMainWnd()->SetWindowText("Bresenham直线算法");
	RedrawWindow();

	LineBrehsenham(X1, Y1, X2, Y2);

}

void CChangfengView::swap_value(int *a, int *b){
	int temp=*a;
	*a=*b;
	*b=temp;
}


void CChangfengView::LineBrehsenham(int x1, int y1, int x2, int y2) 
{
	// TODO: Add your command handler code here
	CClientDC dc(this);
	COLORREF rgb=RGB(0,0,225);

	dc.SetPixel(x1, x2, rgb);
	int dx=abs(x2-x1);
	int dy=abs(y2-y1); 
	if(dx==0 && dy==0){
		return;
	}
	int flag=0;
	if(dx<dy){ //将斜率的绝对值变换为[0,1]之间
		flag=1;
		swap_value(&x1, &y1);
		swap_value(&x2, &y2);
		swap_value(&dx, &dy);
	}
	int tx=(x2-x1)>0 ? 1 : -1;
	int ty=(y2-y1)>0 ? 1 : -1;
	int curx=x1+1;
	int cury=y1;
	int ds=2*dy;
	int dt=2*(dy-dx);
	int d=ds-dx;
	while(curx != x2){
		if(d<0){
			d=d+ds;
		}else{
			cury=cury+ty;
			d=d+dt;
		}

		if(flag){
			dc.SetPixel(cury, curx, rgb);
		}else{
			dc.SetPixel(curx, cury, rgb);
		}

		curx=curx+tx;
	}
}

//***********************************Bresenham直线算法end*******************************///

//***********************************中点画线法begin*******************************///
void CChangfengView::OnLineMid() 
{
	// TODO: Add your command handler code here
	LineMidDlg dlg;
	if(dlg.DoModal()==IDOK){
		X1=dlg.m_LineMidX1;
		X2=dlg.m_LineMidX2;
		Y1=dlg.m_LineMidY1;
		Y2=dlg.m_LineMidY2;
	}
	AfxGetMainWnd()->SetWindowText("中点画线法");
	RedrawWindow();

	LineMid(X1, Y1, X2, Y2);
}
void CChangfengView::LineMid(int x0, int y0, int x1, int y1) 
{
	// TODO: Add your command handler code here
	CClientDC dc(this);
	COLORREF rgb=RGB(0,0,225);

	int a,b,d,x,y,tag=0;
	if(abs(x1-x0)<abs(y1-y0)){
		swap_value(&x0, &y0);
		swap_value(&x1, &y1);
		tag=1;
	}
	if(x0>x1){
		swap_value(&x0, &x1);
		swap_value(&y0, &y1);
	}
	a=y0-y1;
	b=x1-x0;
	d=a+b/2;

	if(y0<y1){ //斜率为正
		x=x0;
		y=y0;
		dc.SetPixel(x,y,rgb);
		while(x<x1){
			if(d<0){
				x++;
				y++;
				d=d+a+b;
			}else{
				x++;
				d=d+a;
			}
			if(tag){
				dc.SetPixel(y,x,rgb);
			}else{
				dc.SetPixel(x,y,rgb);
			}
		}
	}else{ //斜率为负
		x=x1;
		y=y1;
		dc.SetPixel(x,y,rgb);
		while(x>x0){
			if(d<0){
				x--;
				y++;
				d=d-a+b;
			}else{
				x--;
				d=d-a;
			}

			if(tag){
				dc.SetPixel(y,x,rgb);
			}else{
				dc.SetPixel(x,y,rgb);
			}
		}
	}
	
}

//***********************************中点画线法end*******************************///

void CChangfengView::OncircleMid() 
{
	// TODO: Add your command handler code here
	circleMidDlg dlg;
	if(dlg.DoModal()==IDOK){
		circleBreR=dlg.m_circleMidR;
		x0=dlg.m_circleMidX;
		y0=dlg.m_circleMidY;
	}
	AfxGetMainWnd()->SetWindowText("中点画圆法");
	RedrawWindow();

	circleMid(x0, y0, circleBreR);
}

void CChangfengView::circleMid(double x0, double y0, double r) 
{
	// TODO: Add your command handler code here
	double x=0;
	double y=r;
	double d=1-r;
	circlePoint(x,y);

	while(x<y){
		if(d<0){
			d=d+2*x+3;
		}else{
			d=d+2*(x-y)+5;
			y--;
		}
		x++;
		circlePoint(x,y);
	}

}

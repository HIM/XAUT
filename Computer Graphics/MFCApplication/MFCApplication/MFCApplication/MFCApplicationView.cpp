
// MFCApplicationView.cpp: CMFCApplicationView 类的实现
//

#include "pch.h"
#include "framework.h"
// SHARED_HANDLERS 可以在实现预览、缩略图和搜索筛选器句柄的
// ATL 项目中进行定义，并允许与该项目共享文档代码。
#ifndef SHARED_HANDLERS
#include "MFCApplication.h"
#endif

#include "MFCApplicationDoc.h"
#include "MFCApplicationView.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif

#include "circleBreDlg.h"
#include "lineBre.h"
#include "circleMidDlg.h"
#include "onePoint.h"


// CMFCApplicationView

IMPLEMENT_DYNCREATE(CMFCApplicationView, CView)

BEGIN_MESSAGE_MAP(CMFCApplicationView, CView)
	// 标准打印命令
	ON_COMMAND(ID_FILE_PRINT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, &CMFCApplicationView::OnFilePrintPreview)
	ON_WM_CONTEXTMENU()
	ON_WM_RBUTTONUP()
	ON_COMMAND(ID_CircleBre, &CMFCApplicationView::OnCirclebre)
	ON_COMMAND(ID_LineBresenham, &CMFCApplicationView::OnLinebresenham)
	ON_COMMAND(ID_LineMid, &CMFCApplicationView::OnLinemid)
	ON_COMMAND(ID_onePoint, &CMFCApplicationView::Ononepoint)
END_MESSAGE_MAP()

// CMFCApplicationView 构造/析构

CMFCApplicationView::CMFCApplicationView() noexcept
{
	// TODO: 在此处添加构造代码

}

CMFCApplicationView::~CMFCApplicationView()
{
}

BOOL CMFCApplicationView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: 在此处通过修改
	//  CREATESTRUCT cs 来修改窗口类或样式

	return CView::PreCreateWindow(cs);
}

// CMFCApplicationView 绘图

void CMFCApplicationView::OnDraw(CDC* /*pDC*/)
{
	CMFCApplicationDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;

	// TODO: 在此处为本机数据添加绘制代码
}


// CMFCApplicationView 打印


void CMFCApplicationView::OnFilePrintPreview()
{
#ifndef SHARED_HANDLERS
	AFXPrintPreview(this);
#endif
}

BOOL CMFCApplicationView::OnPreparePrinting(CPrintInfo* pInfo)
{
	// 默认准备
	return DoPreparePrinting(pInfo);
}

void CMFCApplicationView::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加额外的打印前进行的初始化过程
}

void CMFCApplicationView::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加打印后进行的清理过程
}

void CMFCApplicationView::OnRButtonUp(UINT /* nFlags */, CPoint point)
{
	ClientToScreen(&point);
	OnContextMenu(this, point);
}

void CMFCApplicationView::OnContextMenu(CWnd* /* pWnd */, CPoint point)
{
#ifndef SHARED_HANDLERS
	theApp.GetContextMenuManager()->ShowPopupMenu(IDR_POPUP_EDIT, point.x, point.y, this, TRUE);
#endif
}


// CMFCApplicationView 诊断

#ifdef _DEBUG
void CMFCApplicationView::AssertValid() const
{
	CView::AssertValid();
}

void CMFCApplicationView::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CMFCApplicationDoc* CMFCApplicationView::GetDocument() const // 非调试版本是内联的
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CMFCApplicationDoc)));
	return (CMFCApplicationDoc*)m_pDocument;
}
#endif //_DEBUG


// CMFCApplicationView 消息处理程序


void CMFCApplicationView::OnCirclebre()
{
	// TODO: 在此添加命令处理程序代码
	circleBreDlg dlg;
	if (dlg.DoModal() == IDOK) {//输入框显示时
		R = dlg.m_CircleBreR;
		x0 = dlg.m_CircleBreX;
		y0 = dlg.m_CircleBreY;
	}
	RedrawWindow();//绘制窗口

	circleBre();//调用画图函数
	//dlg.DoModal();
}

void CMFCApplicationView::circleBre()
{
	// TODO: Add your command handler code here
	int x, y, d;
	x = 0;
	y = R;
	d = 3 - 2 * R;
	while (x < y) {
		circlePoint(x, y);
		if (d < 0) {
			d = d + 4 * x + 6;
		}
		else {
			d = d + 4 * (x - y) + 10;
			y--;
		}
		x++;
	}
	if (x == y) {
		circlePoint(x, y);
	}
}

void CMFCApplicationView::circlePoint(int x, int y)

{
	// TODO: Add your command handler code here
	CClientDC dc(this); //添加上下文，确定画布
	COLORREF rgb = RGB(0, 0, 225); //添加画笔颜色
	dc.SetPixel(x0 + x, y0 + y, rgb);
	dc.SetPixel(x0 + y, y0 + x, rgb);
	dc.SetPixel(x0 + y, y0 - x, rgb);
	dc.SetPixel(x0 + x, y0 - y, rgb);
	dc.SetPixel(x0 - x, y0 - y, rgb);
	dc.SetPixel(x0 - y, y0 - x, rgb);
	dc.SetPixel(x0 - y, y0 + x, rgb);
	dc.SetPixel(x0 - x, y0 + y, rgb);
}


// ----------------------------------------------------------------------------bre画线
void CMFCApplicationView::OnLinebresenham()
{
	// TODO: 在此添加命令处理程序代码
	// TODO: Add your command handler code here
	lineBre dlg;
	if (dlg.DoModal() == IDOK) {
		X1 = dlg.m_LineBreX1;
		X2 = dlg.m_LineBreX2;
		Y1 = dlg.m_LineBreY1;
		Y2 = dlg.m_LineBreY2;
	}
	//AfxGetMainWnd()->SetWindowText("Bresenham直线算法");
	RedrawWindow();

	LineBrehsenham(X1, Y1, X2, Y2);
}
void CMFCApplicationView::swap_value(int* a, int* b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}


void CMFCApplicationView::LineBrehsenham(int x1, int y1, int x2, int y2)
{
	// TODO: Add your command handler code here
	CClientDC dc(this);
	COLORREF rgb = RGB(0, 0, 225);

	dc.SetPixel(x1, x2, rgb);
	int dx = abs(x2 - x1);
	int dy = abs(y2 - y1);
	if (dx == 0 && dy == 0) {
		return;
	}
	int flag = 0;
	if (dx < dy) { //将斜率的绝对值变换为[0,1]之间
		flag = 1;
		swap_value(&x1, &y1);
		swap_value(&x2, &y2);
		swap_value(&dx, &dy);
	}
	int tx = (x2 - x1) > 0 ? 1 : -1;
	int ty = (y2 - y1) > 0 ? 1 : -1;
	int curx = x1 + 1;
	int cury = y1;
	int ds = 2 * dy;
	int dt = 2 * (dy - dx);
	int d = ds - dx;
	while (curx != x2) {
		if (d < 0) {
			d = d + ds;
		}
		else {
			cury = cury + ty;
			d = d + dt;
		}

		if (flag) {
			dc.SetPixel(cury, curx, rgb);
		}
		else {
			dc.SetPixel(curx, cury, rgb);
		}
		curx = curx + tx;
	}
}

//------------------------------------------------------中点画圆
void CMFCApplicationView::OnLinemid()
{
	// TODO: 在此添加命令处理程序代码
	circleMidDlg dlg;
	if (dlg.DoModal() == IDOK) {
		circleBreR = dlg.m_circleMidR;
		x0 = dlg.circleMidX;
		y0 = dlg.circleMidY;
	}
	//AfxGetMainWnd()->SetWindowText("中点画圆法");
	RedrawWindow();

	circleMid(x0, y0, circleBreR);
}

void CMFCApplicationView::circleMid(double x0, double y0, double r)
{
	// TODO: Add your command handler code here
	double x = 0;
	double y = r;
	double d = 1 - r;
	circlePoint(x, y);

	while (x < y) {
		if (d < 0) {
			d = d + 2 * x + 3;
		}
		else {
			d = d + 2 * (x - y) + 5;
			y--;
		}
		x++;
		circlePoint(x, y);
	}

}

//-------------------------------------------------------画点
void CMFCApplicationView::Ononepoint()
{
	// TODO: 在此添加命令处理程序代码
	onePoint dlg;
	if (dlg.DoModal() == IDOK) {
		x0 = dlg.m_onePointX;
		y0 = dlg.m_onePointY;
	}

	RedrawWindow();

	CClientDC dc(this);
	COLORREF rgb = RGB(0, 0, 225);
	dc.SetPixel(x0, y0, rgb);
}

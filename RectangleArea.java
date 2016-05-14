import java.util.Scanner;

//题意描述：计算2D平面上的的矩形面积（两个矩形有重叠部分），每个矩形给出左下角和右上角的坐标

public class RectangleArea {

	//解题思路：由题目已知，矩形面积有重叠部分，则要么分块累加求和，要么求两个矩形的面积之和再减去重叠部分的面积
	//对比发现求两面积之和再减去重叠部分的面积做法比较简单，因此这里采用该方法
	//矩形一：(A,B),(C,D)，矩形二：(E,F),(G,H)
	
	//实际做题发现需要考虑的问题还是比较全面的：
	//一、两矩形没有重叠(ovreRect = 0)
	//(1)其中一个或两个矩形的面积为0；
	//(2)两个矩形要么（rightA<leftB || topA<bottomB）；
	//二、两矩形有重叠
	//(1)矩形A的右下与矩形B的左上重叠；
	//(2)矩形A的右上与矩形B的左下重叠；
	//(3)矩形A被矩形B覆盖

	private static int  computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int rect1 = (C-A) * (D-B);
		int rect2 = (G-E) * (H-F);
		
		//构建重叠矩形，得到左下、右上坐标
		int overRectLeft = Math.max(A, E);
		int overRectBottom = Math.max(B, F);
		int overRectRight = Math.min(C, G);
		int overRectTop = Math.min(D, H);
		
		int overRect;//重叠面积
		if(overRectRight<overRectLeft || overRectTop<overRectBottom){
			overRect = 0;//如果新矩形的右上坐标比左下坐标小，则两矩形无重叠部分
		}else{//否则两矩形有部分重叠
			overRect = (overRectRight - overRectLeft) * (overRectTop - overRectBottom);
		}
		
		return rect1 + rect2 - overRect;
	}
	
	public static void main(String[] args) {
		System.out.println(computeArea(-3,0,3,4,0,-1,9,2));//45 两矩形有重叠部分
		System.out.println(computeArea(0,0,0,0,-1,-1,1,1));//4  一个矩形面积为0
		System.out.println(computeArea(-2,-2,2,2,3,3,4,4));//17 两矩形无重叠部分，且位置为绝对的（上下&&左右）关系，即斜对角关系  
		System.out.println(computeArea(-1500000001,0,-1500000000,1,
				1500000000,0,1500000001,1));//2  两矩形无重叠部分，但位置仅为（上下）||（左右）关系，即平行关系  
	}

}

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sort {

	//直接插入排序
	static void InsertSort(int[] a, int n){
		for(int i=1; i<n; i++){
			if(a[i] < a[i-1]){
				int temp = a[i];
				int j = i-1;
				while(j>=0 && temp<a[j]){
					a[j+1] = a[j];
					j--;
				}
				a[j+1] = temp;
			}
			for(int t = 0; t < n; t++)
				System.out.print(a[t] + "\t");
			System.out.println();
		}
	}
	
	//折半插入排序
	static void HalfInsertSort(int[] a, int n){
		for(int i=1; i<n; i++){
			if(a[i] < a[i-1]){
				int temp = a[i];
				int low = 0,high = i-1;
				while(low <= high){
					int mid = (low + high)/2;
					if(a[mid] > temp) 
						high = mid - 1;
					else low = mid + 1;
				}
				for(int j=i-1; j>=high+1; j--)
					a[j+1] = a[j];
				a[high+1] = temp;
			}
			for(int t = 0; t < n; t++)
				System.out.print(a[t] + "\t");
			System.out.println();
		}
	}	
	
	//希尔排序
	static void ShellSort(int[] a, int n){
		for(int dk=n/2; dk>=1; dk=dk/2){
			for(int i=dk; i<n; i++){
				if(a[i] < a[i-dk]){
					int temp = a[i];
					int j=i-dk;
					for(; j>=0&&temp<a[j]; j-=dk)
						a[j+dk] = a[j];
					a[j+dk] = temp;
				}
			}
			for(int t = 0; t < n; t++)
				System.out.print(a[t] + "\t");
			System.out.println();
		}
	}
	
	//冒泡排序
	static void BubbleSort(int[] a, int n){
		for(int i=0; i<n-1; i++){
			boolean flag = false; //设置标志
			for(int j=n-1; j>i; j--){
				if(a[j] < a[j-1]){
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
					flag = true;
				}
			}
			if(flag == false) //如果一趟下来没有发生交换则已有序 
				return;
			for(int t = 0; t < n; t++)
				System.out.print(a[t] + "\t");
			System.out.println();
		}
	}
	
	//快速排序
	static void QuickSort(int[]a, int low, int high){
		if(low < high){
			int pos = Partition(a, low, high);			
			QuickSort(a, low, pos-1);
			QuickSort(a, pos+1, high);
		}
		
		for(int t = 0; t < high; t++)
			System.out.print(a[t] + "\t");
		System.out.println();
	}
	static int Partition(int[]a, int low, int high){
		int temp =  a[low];
		while(low < high){
			while((low < high) && (a[high] >= temp))
				high--;
			a[low] = a[high];
			while((low < high) && (a[low] <= temp))
				low++;
			a[high] = a[low];			
		}		
		a[low] = temp;
		return low;
	}
	
	//选择排序
	static void SelectSort(int[] a, int n){
		for(int i=0; i<n; i++){
			int min = i;
			for(int j=i+1; j<n; j++)
				if(a[j] < a[min])
					min = j;
			if(min != i){
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
			for(int t = 0; t < n; t++)
				System.out.print(a[t] + "\t");
			System.out.println();
		}
	}
	
	//堆排序
	static void BuildMaxHeap(int[] a, int n){//创建大根堆
		for(int i=(n-1)/2; i>=0; i--){
			AdjustDown(a, i, n-1);
			
//			for(int t = 0; t < n; t++)
//				System.out.print(a[t] + "\t");
//			System.out.println();
		}
	}
	static void AdjustDown(int[] a, int k, int n){//调整大根堆
		int temp = a[k];
		for(int i=2*k+1; i<=n; i*=2){//数组下标从1开始，则双亲与子女下标关系：Parent*2+1=LeftChild
			if((i<n)&&(a[i]<a[i+1]))//比较左右子树，取较大者
				i++;
			if(temp>=a[i]) break;//本身是大根堆就什么都不做
			else{//否则就选取左右子孩子中较大值交换
				a[k] = a[i];
				k = i;
			}
		}
		a[k] = temp;
	}
	static void HeapSort(int[] a, int n){//堆排序
		BuildMaxHeap(a, n);
		for(int i=n-1; i>1; i--){
			int temp = a[i];
			a[i] = a[0];
			a[0] = temp;
			AdjustDown(a, 0, i-1);	
			
			for(int t = 0; t < n; t++)
				System.out.print(a[t] + "\t");
			System.out.println();
		}		
	}
	
	//归并排序
	static void Merge(int[] a, int low, int mid, int high){
		int[] b = new int[a.length];
		for(int k=low; k<=high; k++)
			b[k] = a[k];
		int i=low, j=mid+1, k=i;
		for(; i<=mid&&j<=high; k++){
			if(b[i] <= b[j])
				a[k] = b[i++];
			else a[k] =  b[j++];
		}
		while(i <= mid) a[k++] = b[i++];
		while(j <= high) a[k++] = b[j++];
	}
	static void MergeSort(int[] a, int low, int high){
		if(low < high){
			int mid = (low+high)/2;
			MergeSort(a, low, mid);
			MergeSort(a, mid+1, high);
			Merge(a, low, mid, high);
		}
		for(int t = 0; t < high; t++)
			System.out.print(a[t] + "\t");
		System.out.println();
	}
	
	 //基数排序
	static void RadixSort(int[] data, int radix, int distance){
		int [] temp = new int[data.length];//用于暂存元素
		int[] count = new int[radix];//用于计数排序  
		int divide = 1;
		
		for(int i=0; i<distance; i++){
			System.arraycopy(data, 0, temp, 0, data.length);
			Arrays.fill(count, 0);
			
			for(int j=0; j<data.length; j++){
				int tempKey = (temp[j]/divide)%radix;
				count[tempKey]++;
			}
			
			for(int j=1; j<radix; j++)
				count[j] = count[j] + count[j-1];
			
			for (int j = data.length - 1; j >= 0; j--) {  
                int tempKey = (temp[j]/divide)%radix;  
                count[tempKey]--;  
                data[count[tempKey]] = temp[j];  
            }  
              
            divide = divide * radix; 
		}		
		
		for (int i = 0; i < data.length; i++) {  
            System.out.print("  " + data[i]);  
        } 
	}
	
	public static void main(String[] args) {
		//int[] a = {3,1,5,7,2,4,9,6};		
		//InsertSort(a, 8);
		//HalfInsertSort(a, 8);
		//ShellSort(a, 8);
		//BubbleSort(a, 8);
		//QuickSort(a, 0, 7);
		//SelectSort(a, 8);
		//HeapSort(a, 8);
		//MergeSort(a, 0, 7);
		int[] data = new int[] { 1100, 192, 221, 12, 23 };
		RadixSort(data, 10, 4);
		
	}
}

# include <stdio.h>

void applymergeSort(int a[],int temp[],int size);
void mergeSort(int a[],int temp[],int left, int right);
void merge(int a[],int temp[],int left, int mid,int right);

int main (){
	int array[]={12,3,3,43,4456,34};
	int size=(sizeof(array)/sizeof(array[0]));
	int temp[size];
	printf("size is %d \n",size);
	for(int i=0;i<size;i++){
		printf("%d ",array[i]);
	}
	printf("\n");
	
	applymergeSort(array,temp,size);

 	size=(sizeof(array)/sizeof(array[0]));
	printf("size is %d \n",size);
	for(int i=0;i<size;i++){
		printf("%d ",array[i]);
	}
	printf("\n");
}

void applymergeSort(int a[],int temp[],int size){
	 
	mergeSort(a,temp,0,size-1);
}

void mergeSort(int array[],int temp[],int left, int right){
	int mid;
	if(right>left){
		mid=(left+right)/2;
		mergeSort(array,temp,left,mid);
		mergeSort(array,temp,mid+1,right);
		merge(array,temp,left,mid+1,right);

	}
}
 void merge(int array[],int temp[],int left, int mid,int right){

 	int left_end=mid-1;
 	int number_of_elements = right-left+1;
 	int temp_pos=left;
//printf("left is %d and left_end %d and temp_pos %d \n",left,left_end,temp_pos);
 	while((left<=left_end) && (mid<=right)){

 		if(array[left]<=array[mid]){
 			temp[temp_pos]=array[left];
 			left++;
 			temp_pos++;
 		}else{
 			//printf("mid %d and temp_pos %d\n",mid,temp_pos);
 			//printf("temp[%d] %d=array[%d] %d\n",temp_pos,temp[temp_pos],mid,array[mid]);
 			temp[temp_pos]=array[mid];
 			mid++;
 			temp_pos++;
			//printf("mid %d and temp_pos %d\n",mid,temp_pos); 			
 		}
 	}

 		while(left<=left_end){
	//printf("left %d and temp_pos %d\n",left,temp_pos); 			
	//printf("array[%d] %d=array[%d] %d\n",temp_pos,array[temp_pos],left,array[left]); 			
 			temp[temp_pos]=array[left];
 			left++;
 			temp_pos++;
	//printf("left %d and temp_pos %d\n",left,temp_pos); 			 			
 		}

 		while(mid<=right){
 			temp[temp_pos]=array[mid];
 			mid++;
 			temp_pos++;
 		}

 		//printf("number of elments %d \n",number_of_elements);
 		for(int i=0;i<=number_of_elements;i++){
 			array[right]=temp[right];
 			right--;
 		}
 	


 }
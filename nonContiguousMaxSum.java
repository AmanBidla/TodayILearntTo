int sum(int *arr,int size) {
        int *sum = malloc(sizeof(int) * size);
        int i;

        for(i=0;i<size;i++) {
                if(i==0) {
                        sum[0] = arr[0];
                }else if(i==1) {
                        sum[1] = max(sum[0],arr[1]);
                }else{
                        sum[i] = max(sum[i-2]+arr[i],sum[i-1]);
                }
        }    
        return sum[size-1];
}
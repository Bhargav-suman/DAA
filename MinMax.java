import java.util.Scanner;
class Data{
    int min,max;
}
class MinMax{
    public static Data FindMinMax(int a[] , int lb, int ub){
        int n = ub-lb+1;
        Data x = new Data();
        Data y = new Data();
        Data z = new Data();
        if(n==1){
            x.min = a[lb];
            x.max = a[lb];
            return x;
        }
        else if(n==2){
            x.min = (a[lb]<a[ub])?a[lb]:a[ub];
            x.max = (a[lb]<a[ub])?a[ub]:a[lb];
            return x;
        }
        else{
            int mid = (ub+lb)/2;
            x = FindMinMax(a,lb,mid);
            y = FindMinMax(a,mid+1,ub);
            z.min = (x.min < y.min)?x.min:y.min;
            z.max = (x.max > y.max)?x.max:y.max;
        }
        return z;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the array size:");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("enter the array elements:");
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int lb=0,ub = n-1;
        Data p = FindMinMax(a,lb,ub);
        System.out.println("min="+p.min +"\t" +"max="+p.max);
    }
}

import java.util.*;
class MergesortAlgo{
    public static void mergePass(int l[],int lb,int ub){
        if(lb!=ub){
            int mid = (lb+ub)/2;
            mergePass(l,lb,mid);
            mergePass(l,mid+1,ub);
            mergeSort(l,lb,mid,ub);
        }
    }
    public static void mergeSort(int l[],int lb,int mid,int ub){
        int i=lb;
        int j = mid+1;
        int k=lb;
        int temp[] = new int[l.length];
        while((i<=mid)&&(j<=ub)){
            if(l[i]<l[j]){
                temp[k++]=l[i++];
            }
            else{
                temp[k++]=l[j++];
            }
        }
        while(i<=mid){
            temp[k++]=l[i++];
        }
        while(j<=ub){
            temp[k++]=l[j++];
        }
        for(int x=lb;x<=ub;x++){
            l[x]=temp[x];
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the list size:");
        int n = sc.nextInt();
        int l[] = new int[n];
        System.out.println("enter the elements in the list:");
        for(int i=0;i<n;i++){
            l[i] = sc.nextInt();
        }
        mergePass(l,0,n-1);
        System.out.println("after sorting:");
        for(int i=0;i<n;i++){
            System.out.print(l[i] + "\t");
        }
    }
}

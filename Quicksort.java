import java.util.*;
class QuickSort{
    public static void sort(int l[],int first , int last){
        int temp;
        int i = first;
        int j=last;
        int pivot = first;
        while(i<j){
            while(l[i]<l[pivot] && pivot!=i){
                i++;
            }
            if(pivot != i){
                temp = l[pivot];
                l[pivot]  =l[i];
                l[i] = temp;
                pivot = i;
            }
            while(l[j]>l[pivot] && pivot!=j){
                j--;
            }
            if(pivot != j){
                temp = l[pivot];
                l[pivot] = l[j];
                l[j] = temp;
                pivot = j;
            }
            if(first<pivot){
                sort(l,first,pivot-1);
            }
            if(last > pivot){
                sort(l,pivot+1,last);
            }
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
        sort(l,0,n-1);
        System.out.println("after sorting:");
        for(int i=0;i<n;i++){
            System.out.print(l[i] + "\t");
        }
    }
}

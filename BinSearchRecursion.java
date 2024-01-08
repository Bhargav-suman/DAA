import java.util.*;
public class BinSearchRecursion{
    public static int BinarySearch(int a[],int lb ,int ub,int key){
        
        if(lb<=ub){
            int mid = (lb+ub)/2;
            if(a[mid]==key){
                return mid;
            }
            else if(a[mid]>key){
                return BinarySearch(a,lb,mid-1,key);
            }
            else{
                return BinarySearch(a,mid+1,ub,key);
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array:");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("enter the array elements:");
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        System.out.println("enter the element to search:");
        int key = sc.nextInt();
        int r = BinarySearch(a ,0, n-1 , key);
        if(r == -1){
            System.out.println(key + "not found.");
        }
        else{
            System.out.println("posistion of the element:"+r);
        }
        
    }
}
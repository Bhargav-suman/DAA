import java.util.Scanner;

public class Main{
    public static int edit(String s1,String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        int c = 0;
        if(n1<n2){
            c += n2-n1;
            for(int i=0;i<n1;i++){
                if(s1.charAt(i)!=s2.charAt(i)){
                    c++;
                }
            }
        }
        else if(n1>n2){
            c += n1-n2;
            for(int i=0;i<n1;i++){
                if(s1.charAt(i)!=s2.charAt(i)){
                    c++;
                }
            }
        }
        else{
            for(int i=0;i<n1;i++){
                if(s1.charAt(i)!=s2.charAt(i)){
                    c++;
                }
            }
        }
        return c;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string1:");
        String s1 = sc.nextLine();
        System.out.println("enter string2:");
        String s2 = sc.nextLine();
        int c = edit(s1,s2);
        System.out.println("no.of words need to be edited between '"+s1+"' and '"+s2+"' is:"+c);
    }
}

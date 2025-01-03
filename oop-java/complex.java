import java.util.*;
class complex{
    int rr;
    int ii;
    complex(){
        rr=0;
        ii=0;

    }
    complex(int rr,int ii){
        this.rr=rr;
        this.ii=ii;
    }
    void addcomplex(complex c,complex c1)
    {
        this.rr=c1.rr+c.rr;
        this.ii=c1.ii+c.ii;

    }

}

class ComplexDemo{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("enter real number: ");
        int r=sc.nextInt();
        System.out.print("enter imagnary number: ");
        int i=sc.nextInt();
        complex c1=new complex(r,i);
        System.out.print("enter real number: ");
        r=sc.nextInt();
        System.out.print("enter imagnary number: ");
        i=sc.nextInt();
        complex c2=new complex(r,i);
        complex c3=new complex();
        c3.addcomplex(c1,c2);
        System.out.print(c3.rr+" "+c3.ii);
        System.out.print("");

    }
}
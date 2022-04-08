import java.util.Scanner;

public class JavaHw01_02 {
    public static void main(String[] args){

        /* 캐시백 계산 문제
        *
        * Developer : 조성만
        *
        * */

        System.out.println("[캐시백 계산]");
        Scanner sc = new Scanner(System.in);
        System.out.print("결제 금액을 입력해주세요.(금액):");
        int payMoney= sc.nextInt();
        sc.close();

        int cb= (int) Math.floor(payMoney*0.1/100)*100;
        if(cb>=300) {
            System.out.println("결제 금액은 "+payMoney+"원이고, 캐시백은 300원 입니다.");
        }else {
            System.out.println("결제 금액은 " + payMoney + "원이고, 캐시백은 "+cb+"원 입니다.");
        }
    }
}

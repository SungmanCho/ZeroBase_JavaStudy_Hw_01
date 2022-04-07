import java.util.Scanner;

public class JavaHw01_03 {
    public static void main(String[] args){

        int pay = 10000;

        System.out.println("[입장권계산]");
        Scanner sc = new Scanner(System.in);
        System.out.print("나이를 입력해 주세요.(숫자):");
        int age = sc.nextInt();
        System.out.print("입장시간을 입력해 주세요. (숫자입력):");
        int time = sc.nextInt();
        System.out.print("국가유공자 여부를 입력해 주세요.(y/n):");
        String nmCheck = sc.next();
        System.out.print("복지카드 여부를 입력해 주세요.(y/n):");
        String cdCheck = sc.next();

        if (age<3){
            pay = 0;
        }
        else if(age<13){
            pay = 4000;
        }else if(time>16){
            pay = 4000;
        }
        else if(nmCheck.equals("y")||cdCheck.equals("y")){
            pay = 8000;
        }

        System.out.print("입장료: "+pay);

        sc.close();

    }
}

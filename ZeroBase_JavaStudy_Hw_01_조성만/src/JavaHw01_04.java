import java.util.Scanner;
import java.util.Random;

public class JavaHw01_04 {
    public static void main(String[] args){


        /*주민번호 계산 문제
        *
        * Developer : 조성만
        *
        *
        * */




        String gdChk ="";

        System.out.println("[주민등록번호 계산]");
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.print("출생년도를 입력해 주세요.(yyyy):");
        String yyyy = sc.nextLine();
        System.out.print("출생월을 입력해 주세요.(mm):");
        String mm = sc.nextLine();
        System.out.print("출생일을 입력해 주세요.(dd):");
        String dd = sc.nextLine();
        System.out.print("성별을 입력해 주세요.(m/f):");
        String gender = sc.nextLine();

        if (gender.equals("m")){
            gdChk = "3";
        }else if(gender.equals("f")){
            gdChk = "4";
        }

        System.out.print(yyyy+mm+dd+"-"+gdChk+(random.nextInt(1000000)));
        sc.close();
    }
}

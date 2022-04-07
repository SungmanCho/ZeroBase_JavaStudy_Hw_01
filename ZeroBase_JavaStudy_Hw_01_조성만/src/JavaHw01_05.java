import java.time.LocalDate;
import java.util.Scanner;

public class JavaHw01_05 {
    public static void main(String[] args){

        System.out.println("[달력 출력 프로그램]");
        Scanner sc = new Scanner(System.in);
        System.out.print("달력의 년도를 입력해 주세요.(yyyy):");
        int year = sc.nextInt();
        System.out.print("달력의 월을 입력해 주세요.(mm):");
        int month = sc.nextInt();

        sc.close();

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("["+year+"년 "+month+"월]");
        System.out.println("일\t월\t화\t수\t목\t금\t토");
        LocalDate ld= LocalDate.of(year,month,1);
        int fDay = ld.getDayOfWeek().getValue();
        int lDay = ld.lengthOfMonth();

        int day = fDay;
        for(int i=0;i<day;i++){
            System.out.print("\t");
        }

        for(int i=1;i<=lDay;i++){
            if(day%7==0){
                System.out.print("\n");
            }
            System.out.printf("%02d\t",i);
            day++;
        }
    }
}

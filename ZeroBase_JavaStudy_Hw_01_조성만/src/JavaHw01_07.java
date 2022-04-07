import java.util.*;

public class JavaHw01_07 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] realLtArr = new int[6];
        int[] ltArr = new int[6];

        for (int i = 0; i < realLtArr.length; i++) {
            realLtArr[i] = (int) (Math.random() * 45 + 1);
        }
        for (int i=0;i<realLtArr.length;i++){
            for (int j=i+1;j< realLtArr.length;j++){
                if (realLtArr[j - 1] == realLtArr[j]) {
                    realLtArr[j] = (int) (Math.random() * 45 + 1);
                    j--;
                }
            }
        }

        System.out.println("[로또 당첨 프로그램]");
        System.out.println();
        System.out.print("로또 개수를 입력해주세요.(숫자 1~10):");

        int cnt = sc.nextInt();
        int [][] arr = new int[cnt][ltArr.length];

        sc.close();

        for (int i=0;i<cnt;i++) {
            for (int j = 0; j < ltArr.length; j++) {
                ltArr[j] = (int) (Math.random() * 45 + 1);
                arr[i][j] = ltArr[j];
            }
        }
        for (int i=0;i<cnt;i++){
            for (int j=0;j< ltArr.length-1;j++){
                for (int k=j+1;k< ltArr.length;k++){
                    if (arr[i][j] == arr[i][k]) {
                        arr[i][k] = (int) (Math.random() * 45 + 1);
                        k--;
                    }
                    if (arr[i][j]>arr[i][k]){
                        int tmp = arr[i][j];
                        arr[i][j]=arr[i][k];
                        arr[i][k] = tmp;
                    }
                }
            }
        }
        for (int i=0;i<cnt;i++){
            System.out.print(String.format(("%c\t"),(char)(65+i)));
            for (int j = 0; j < ltArr.length; j++) {
                ltArr[j] = (int) (Math.random() * 45 + 1);
                System.out.print(String.format(("%02d"), arr[i][j]));
                if(j+1==ltArr.length){
                    System.out.println();
                }else if(j+1< ltArr.length){
                    System.out.print(",");
                }
            }
        }

        Arrays.sort(realLtArr);

        System.out.println();
        System.out.println("[로또 발표]");
        for (int i = 0; i < realLtArr.length ; i++) {
            if (i == 0) {
                System.out.printf("\t%02d,", realLtArr[i]);
            } else if (i < 5) {
                System.out.printf("%02d,", realLtArr[i]);
            } else {
                System.out.printf("%02d\n", realLtArr[i]);
            }
        }

     int[] eq = new int[cnt];
        for(int i=0;i<ltArr.length;i++){
            for(int j=0;j<cnt;j++){
                for(int k=0;k<ltArr.length;k++){
                    if(realLtArr[i]==arr[j][k]){
                            eq[j]++;
                    }
                }
            }
        }

        System.out.println();
        System.out.println("[내 로또 결과]");

        for (int i=0;i<cnt;i++){
            System.out.print(String.format(("%c\t"),(char)(65+i)));
            for (int j = 0; j < ltArr.length; j++) {
                ltArr[j] = (int) (Math.random() * 45 + 1);
                System.out.print(String.format(("%02d"), arr[i][j]));
                if(j+1==ltArr.length){
                    System.out.print(String.format((" =>%d개 일치"),eq[i]));
                    System.out.println();
                }else if(j+1< ltArr.length){
                    System.out.print(",");
                }
            }
        }
    }
}





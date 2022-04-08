import java.util.Scanner;

public class JavaHw01_08 {

    public static void main(String[] args) {

        /*과세금액 계산 문제
        *
        *
        * Developer : 조성만
        *
        * */


        Scanner sc = new Scanner(System.in);
        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");

        int yIncome = sc.nextInt();
        sc.close();
        Tax_cal tax_cal = new Tax_cal();
        tax_cal.cal_Tax(yIncome);
        tax_cal.cal_Pro_Tax(yIncome);

    }
}
    class Tax_cal {

        int[] yIncome_arrays = {12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};
        int[] tax_rate_arrays = {6, 15, 24, 35, 38, 40, 42, 45};
        int[] tax_arrays = {12000000, 34000000, 42000000, 62000000, 150000000, 200000000, 500000000};
        int[] pro_tax_arrays = {1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000};

        public void mul_print(int income, int taxRate, int sum) {
            System.out.printf("%10d * %2d", income, taxRate);
            System.out.print("% =");
            System.out.printf("%10d \n", sum);
        }

        public int total_Tax (int yIncome, int rest_Income, int step){

            int rest_tax = rest_Income*tax_rate_arrays[step]/100;
            int tax = rest_tax;

            for(int i =0;i<step;i++ ) {
                int tax_step = tax_arrays[i] * tax_rate_arrays[i] / 100;
                tax += tax_step;
                mul_print(tax_arrays[i], tax_rate_arrays[i], tax_step);
            }

            mul_print(rest_Income, tax_rate_arrays[step], rest_tax);

            return tax;
        }

        public void cal_Tax(int yIncome) {
            int tax = 0;
            int step = 0;
            if(yIncome<=yIncome_arrays[0]){
                tax += yIncome*tax_rate_arrays[step]/100;

                mul_print(yIncome,6,tax);
            }
            else if(yIncome<=yIncome_arrays[1]){
                int rest_Income = yIncome-yIncome_arrays[0];
                step = 1;
                tax = total_Tax(yIncome,rest_Income,step);
            }
            else if(yIncome<=yIncome_arrays[2]){
                int rest_Income = yIncome-yIncome_arrays[1];
                step = 2;
                tax = total_Tax(yIncome,rest_Income,step);
            }
            else if(yIncome<=yIncome_arrays[3]){
                int rest_Income = yIncome-yIncome_arrays[2];
                step = 3;
                tax = total_Tax(yIncome,rest_Income,step);
            }
            else if(yIncome<=yIncome_arrays[4]){
                int rest_Income = yIncome-yIncome_arrays[3];
                step = 4;
                tax = total_Tax(yIncome,rest_Income,step);
            }
            else if(yIncome<=yIncome_arrays[5]){
                int rest_Income = yIncome-yIncome_arrays[4];
                step = 5;
                tax = total_Tax(yIncome,rest_Income,step);
            }
            else if (yIncome<=yIncome_arrays[6]){
                int rest_Income = yIncome-yIncome_arrays[5];
                step = 6;
                tax = total_Tax(yIncome,rest_Income,step);
            }else{
                int rest_Income = yIncome-yIncome_arrays[6];
                step = 7;
                tax = total_Tax(yIncome,rest_Income,step);
            }
            System.out.println("\n");
            System.out.printf("[세율에 의한 세금]:\t\t\t%d\n",tax);
        }

        public void cal_Pro_Tax(int y_Income){
            Long tax;
            Long yIncome =(long)y_Income;
            if(yIncome<=yIncome_arrays[0]){
                tax=yIncome*tax_rate_arrays[0]/100;
            }
            else if(yIncome<=yIncome_arrays[1]){
                tax=yIncome*tax_rate_arrays[1]/100-pro_tax_arrays[0];
            }
             else if(yIncome<=yIncome_arrays[2]){
                tax=yIncome*tax_rate_arrays[2]/100-pro_tax_arrays[1];
            }
             else if(yIncome<=yIncome_arrays[3]){
                tax=yIncome*tax_rate_arrays[3]/100-pro_tax_arrays[2];
            }
               else if(yIncome<=yIncome_arrays[4]){
                tax=yIncome*tax_rate_arrays[4]/100-pro_tax_arrays[3];
            }
              else if(yIncome<=yIncome_arrays[5]){
                tax=yIncome*tax_rate_arrays[5]/100-pro_tax_arrays[4];
            }
              else if(yIncome<=yIncome_arrays[6]){
                tax=yIncome*tax_rate_arrays[6]/100-pro_tax_arrays[5];
            }
               else{
                tax=yIncome*tax_rate_arrays[7]/100-pro_tax_arrays[6];
            }
            System.out.printf("[누진공제 계산에 의한 세금]:\t%d\n",tax);
        }
}


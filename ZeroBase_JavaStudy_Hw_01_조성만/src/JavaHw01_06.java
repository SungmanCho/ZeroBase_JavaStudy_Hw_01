import java.util.*;
import java.util.Map.Entry;
import java.util.Random;

public class JavaHw01_06 {
    public static void main(String[] args){

        /*당선 확률 문제
        *
        * Developer : 조성만
        *
        * */


        int cnt = 0;

        HashMap<Integer,Integer> voteMap = new HashMap<>();

        voteMap.put(0,0);
        voteMap.put(1,0);
        voteMap.put(2,0);
        voteMap.put(3,0);

        double totalRate = 0.0;
        double leeRate = 0.0;
        double yoonRate = 0.0;
        double shimRate = 0.0;
        double ahnRate = 0.0;

        Random random = new Random();
        String candidate =null;
        for(int i=0;i<10000;i++){

            int vote = random.nextInt(4);
            cnt++;
            totalRate = (double) cnt/(double) 10000*100;
            if(voteMap.get(vote)!=null){
                voteMap.replace(vote,voteMap.get(vote),voteMap.get(vote)+1);
            }

            switch (vote){
                case 0:
                    candidate="이재명";
                    break;
                case 1:
                    candidate="윤석열";
                    break;
                case 2:
                    candidate="심상정";
                    break;
                default:
                    candidate="안철수";
                    break;
            }

            if(voteMap.get(0)!=0){
                leeRate=(double) voteMap.get(0)/(double) cnt*100;
            }
            if(voteMap.get(1)!=0){
                yoonRate=(double) voteMap.get(1)/(double) cnt*100;
            }
            if(voteMap.get(2)!=0){
                shimRate=(double) voteMap.get(2)/(double) cnt*100;
            }
            if(voteMap.get(3)!=0){
                ahnRate=(double) voteMap.get(3)/(double) cnt*100;
            }

            System.out.printf("[투표진행율]: %05.2f",totalRate);
            System.out.print("%");
            System.out.printf(", %d명 투표 => %s\n",cnt,candidate);
            System.out.printf("[기호:1] 이재명: %05.2f",leeRate);
            System.out.print("%");
            System.out.printf(", (투표수: %d)\n",voteMap.get(0));
            System.out.printf("[기호:2] 윤석열: %05.2f",yoonRate);
            System.out.print("%");
            System.out.printf(", (투표수: %d)\n",voteMap.get(1));
            System.out.printf("[기호:3] 심상정: %05.2f",shimRate);
            System.out.print("%");
            System.out.printf(", (투표수: %d)\n",voteMap.get(2));
            System.out.printf("[기호:4] 안철수: %05.2f",ahnRate);
            System.out.print("%");
            System.out.printf(", (투표수: %d)\n",voteMap.get(3));

            if(i<10000){
                try {
                    Thread.sleep(300);
                    System.out.flush();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        Entry<Integer, Integer> maxEntry = null;
        Set<Entry<Integer, Integer>> entrySet = voteMap.entrySet();
        for (Entry<Integer, Integer> entry : entrySet) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }

        String president;

        switch (maxEntry.getKey()){
            case 0:
                president="이재명";
                break;
            case 1:
                president="윤석열";
                break;
            case 2:
                president="심상정";
                break;
            default:
                president="안철수";
                break;
        }
            System.out.printf("[투표결과] 당선인: %s\n",president);
    }
}

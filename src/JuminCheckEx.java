import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Stream;


public class JuminCheckEx{

   public static void main(String[] args) {
      //준비단계
         //String juminNum;
      String juminNum ;
      int sum = 0;
      int temp,result;
      int[] weight = {2,3,4,5,6,7,0,8,9,2,3,4,5,};
      
      
      //입력단계
      Scanner scan = new Scanner(System.in);
      System.out.print("주민등록번호입력>>>");
      juminNum = scan.nextLine();
       
      //처리단계
      
      //1단계:sum값 구하기
      //"980209-******"
      /*[해결방법 1]
      for(int i=0; i<weight.length; i++) {
         if(juminNum.charAt(i)=='-') {continue;}
         else{sum = sum + (juminNum.charAt(i)-48)*weight[i];}
       */
      //[해결방법2]      
         for(int i=0; i<weight.length; i++) {
            if(juminNum.charAt(i)=='-') continue;
                sum = sum + (juminNum.charAt(i)-48)*weight[i];}   
         
       
         
      
      //2단계
          temp = 11-(sum%11);// 11 모듈러스 , temp값이 10또는 11인경우가 있다
        //3단계
          result = temp%10;
        //주민번호 정상 유뮤 체크
          if(result==juminNum.charAt(13)-48) {
             System.out.println("입력한 주민번호는 정상입니다.");
         //정상인 주민번호로부터 정보 추출하기
             //나이추출=>"시나리오"를 프로그램으로 코딩하기
             //년월일시분초요일 값을 가진 Calendar 클래스 타입의 객체 (instance)이다.
          Calendar cal = Calendar.getInstance(Locale.KOREA);
          int year = cal.get(Calendar.YEAR);//2022 얻어옴
          
          
          int yy = Integer.parseInt(juminNum.substring(0, 2));//"96"=>96
          
          if((juminNum.charAt(7)-48)<3){
            yy=yy+ 1900; //1996을 얻어옴 
          }else {
             yy=yy+2000;//3또는4이면
          }
          int age = year-yy+1;//본나이=>나중에"띠"를 얻어내기 위해서
          System.out.println("나이: "+age);
         //성별 추출
          
          if((juminNum.charAt(7)-48)%2==0) {
             System.out.println("성별:여자");
          }
          else {
             System.out.println("성별:남자");
          }
          /*String yyString = juminNum.substring(0, 2);
          int yy = Integer.parseInt(yyString);
          */
          
          //출생지역
          //2차원 배열로 초기화
          
          String[][]localeCode=  {{"서울","00","08"},{"부산","09","12"},
                                  {"인천","13","15"},{"경기","16","25"},
                                  {"강원","26","34"},{"충북","35","39"},
                                  {"대전","40","40"},{"충남","41","43"},
                                  {"충남","45","57"},{"세종","44","44"},
                                  {"세종","96","96"},{"전북","48","54"},
                                  {"전남","55","64"},{"광주","65","66"},
                                  {"대구","67","70"},{"경북","71","80"},
                                  {"경남","81","84"},{"경남","86","90"},
                                  {"울산","85","85"},{"제주","91","95"}};
                
          String localeString = juminNum.substring(8, 10);
          int locale = Integer.parseInt(localeString);
          String birthPlace =null;
        
          for(int j=0; j<19; j++) {
             if(locale>=Integer.parseInt(localeCode[j][1])&&
                   locale<=Integer.parseInt(localeCode[j][2])) {
                birthPlace=localeCode[j][0];
             
          }
          }
          
         System.out.println("출생지역: "+birthPlace);
          
         //생년월일
         System.out.println("생년월일:"+ yy +"/"+juminNum.substring(2, 4)+"/"+juminNum.substring(4,6 ));
         
         //"띠" 구하기 => 응용 => 출생년도%12 
         String ddi = null;
         String[] gangi = {"원숭이","닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","말","양"};
         
         ddi = gangi[yy%12];
         System.out.println("띠: "+ ddi);
         
         
         
          }else {System.out.println("입력한 주민번호 틀린 주민번호입니다.");}
      
        
      
      
      
      scan.close();
   

   }
}

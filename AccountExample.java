package Chapter06;

import java.util.Scanner;

public class AccountExample {

      private static Account[] accountArray = new Account[100];
      private static Scanner sc = new Scanner(System.in);
      
      public static void main(String[] args) {
         boolean run = true;
         
         while(run) {
            System.out.println("----------------------------------------------");
            System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
            System.out.println("----------------------------------------------");
            System.out.print("선택> ");
            
            int selectNo = sc.nextInt();
            
            if(selectNo == 1) {
               createAccount();
            }
            else if(selectNo == 2) {
               accountList();
            }
            else if(selectNo == 3) {
               deposit();
            }
            else if(selectNo == 4) {
               withdraw();
            }
            else if(selectNo == 5) {
               run = false;
            }
         }
         System.out.println("프로그램 종료");
      }
      
      private static void createAccount() {
         System.out.println("------");
         System.out.println("계좌생성");
         System.out.println("------");
         
         System.out.print("계좌번호: ");
         String ano = sc.next();
         
         System.out.print("계좌주: ");
         String owner = sc.next();
         
         System.out.print("초기입금액: ");
         int balance = sc.nextInt();
         
         Account a = new Account(ano, owner, balance);
         
         a.setAno(ano);
         a.setOwner(owner);
         a.setBalance(balance);
         
         for(int i=0; i<accountArray.length;i++) {
            if(accountArray[i]==null) {
               accountArray[i] = a;
               System.out.println("계좌가 생성되었습니다.");
               break;
            }
            
         }
         
         
      }
      
      private static void accountList() {
         System.out.println("------");
         System.out.println("계좌목록");
         System.out.println("------");
         
         for(int i=0; i<accountArray.length; i++) {
            if(accountArray[i] != null) {
            System.out.println(accountArray[i].getAno() +"  "+accountArray[i].getOwner() +"  "+accountArray[i].getBalance());
            }
            else {
               break;
            }
            }
         }
      
      
      private static void deposit() {
         System.out.println("-------");
         System.out.println("예금");
         System.out.println("-------");
         System.out.print("계좌번호: ");
         String ano = sc.next();
         
         Account account = findAccount(ano);
         
         
         System.out.print("예금액: ");
         int balance = sc.nextInt(); //예금액 입력
         
         if(balance>0) {
         if(account == null) {
        	 System.out.println("계좌가 존재하지 않습니다.");
        	 return;
         }
         
               
         account.setBalance(account.getBalance() + balance);
         System.out.println("예금이 성공되었습니다.");
            
         }
         else {
        	 System.out.println("예금액은 음수가 될 수 없습니다.");
         }
         
         
      }
      
      private static void withdraw() {
    	  System.out.println("-------");
    	  System.out.println("출금");
    	  System.out.println("-------");
    	  System.out.print("계좌 번호: ");
    	  String ano = sc.next();
    	  System.out.print("출금액: ");
    	  int balance = sc.nextInt();
    	  
    	  
    	  Account account = findAccount(ano);
    	  
    	  if(balance>0) {
    	  if(account==null) {
    		  System.out.println("계좌번호가 존재하지 않습니다.");
    		  return;
    	  }
    	  else if(account.getBalance()<balance){
    		  System.out.println("잔액이 부족합니다.");
    		  return;
    	  }
    	  
    	  account.setBalance(account.getBalance() - balance);
    	  System.out.println("출금에 성공하였습니다.");
    	  }
    	  else {
    		  System.out.println("출금액은 음수가 될 수 없습니다.");
    	  }
         
      }
      
      
      //Account 배열에서 ano와 동일한 Account 객체 찾기
      private static Account findAccount(String ano) {
         Account account = null;
         for(int i=0; i<accountArray.length; i++) {
            if(accountArray[i] !=null) {
               if(accountArray[i].getAno().equals(ano)) {
                  account = accountArray[i];
                  break;
               }
            }
               
         }
         return account;
         
      }

}
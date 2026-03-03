package workshop.account.control;

import workshop.account.entity.Account;
import workshop.account.exception.InsufficientBalanceException;

public class AccountTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Account객체 생성
		Account account = new Account();
		account.setCustId("A1100");
		account.setAcctId("221-22-3477");
		account.deposit(100000);
		
		System.out.println("고객번호 : " + account.getCustId());
		System.out.println("계좌번호 : " + account.getAcctId());
		System.out.println("잔액 :" + account.getBalance());
		
		try {
			//Overloaded 된 생성자 호출
			Account account2 = new Account("A1200", "321-22-3477");
			account2.deposit(15000);
			account2.withdraw(10000);
		
			//Account의 부모클래스인 Object 클래스의 toString() 메서드가 호출됨
			account2.withdraw(10000);
			System.out.println(account2.toString());
		} catch(InsufficientBalanceException e) {
			System.out.println(e.getMessage() + e.getCurrentBalance());
		}
	}

}

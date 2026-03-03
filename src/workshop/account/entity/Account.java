package workshop.account.entity;

import workshop.account.exception.InsufficientBalanceException;

public class Account extends Object {
	private String custId;
	private String acctId;
	private int balance;
	
	//Default Constructor 기본 생성자 
	public Account() {
		System.out.println(this.getClass().getName() + " 기본생성자 호출됨");
	}
	
	//Constructor Overloading (중복 정의)
	public Account(String custId, String acctId) {
		setCustId(custId);
		setAcctId(acctId);
	}
	
	//setter method ( 멤버변수 값 변경 ) 
//	private void setBalance(int balance) {
//		this.balance = balance;
//	}
	
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}


	public void setCustId(String custId) {
		this.custId = custId;
	}

	//getter method ( 멤버변수 값 조회 )
	public String getCustId() {
		return custId;
	}

	public String getAcctId() {
		return acctId;
	}

	public int getBalance() {
		return balance;
	}
	
	//입금 
	public void deposit(int amount) {
		//this.balance = this.balance + amount;
		this.balance += amount;
	}
	//출금
	public void withdraw(int amount) throws InsufficientBalanceException {
		if(amount > balance) {
			throw new InsufficientBalanceException("잔액 부족, 현재 잔액 = ",balance);
		}
		this.balance -= amount;
	}

	//메서드 재정의 (Overriding)
	@Override
	public String toString() {
		return "Account [고객번호 =" + custId + ", 계좌번호 =" + 
				acctId + ", 잔액 =" + balance + "]";
	}
}
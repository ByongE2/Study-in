
public class BankAccount2 {

	private int balance;
	private int sum;
	
//	void setSum(int sum) {		//getter,setter >> set값 입력, get값 출력. private변수라서 직접접근하면 안되기 때문.
//		this.sum = sum;
//	}
//	int getSum() {
//		return this.sum;
//	}
	
    int deposit(int amount) {		//입금
		if(amount<0)
			return 0;
    	balance += amount;
		return balance;
	}
	public int getSum() {				// 편집창, source , Getter-Setter 자동생선해주는것도 있다..그만큼 많이 쓴다.
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	int withdraw(int amount) {		//출금
		balance -= amount;
		return balance;
	}
	int checkBalance() {			//잔고 확인
		System.out.println("잔액 : " + balance);
		return 0;
	}
}// end of BankAccount

class MainClass2 {

	public static void main(String[] args) {
		//아래 화면처럼 잔액 뜨게 출력하기 위해 문장을 기술
		// sysout 문장 사용 금지
		
		// 객체 배열
		BankAccount2[] bank = new BankAccount2[3];
		bank[0] = new BankAccount2();
		bank[0].deposit(10000);
		bank[0].withdraw(3000);
//		bank[0].checkBalance();
		System.out.println(bank[0].checkBalance());
//		bank[1] = new BankAccount2();
//		bank[2] = new BankAccount2();
		
		
	}
}// end of MainClass

//잔액: 10000
//잔액: 7000
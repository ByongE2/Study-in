class MyExSpace{
//	MyExSpace(){}
	
   public static void main(String[] args) {
	   Test Ex1 = Test.getInstance();
	      Test Ex2 = Test.getInstance();
	      
//	      Test Ex3 = new Test(); // 생성자 사용 불가 private.
	      System.out.println(Ex1.num);
	      Ex1.num++;
	      System.out.println(Ex2.num);
	      Ex2.num++;
	      System.out.println(Ex1.num);
	      
	   }
	}

	class Test{
	   
	   int num = 10;
	   
	   private static Test Ex = new Test();
	   
	   private Test() {};
	   
	   public static Test getInstance() {
	         return Ex;
   }
	
	
}

public class Ex6_27_BlockTest {

		static {
			System.out.println("static { }");
		}
		
		{
			System.out.println("{ }");
		}
		
		public Ex6_27_BlockTest() {
			System.out.println("생성자");
		}
		
		
		public static void main(String args[]) {
			System.out.println("BlockTest bt = new BlockTest();");
			Ex6_27_BlockTest bt = new Ex6_27_BlockTest();
			
			System.out.println("BlockTest bt2 = new BlockTest();");
			Ex6_27_BlockTest bt2 = new Ex6_27_BlockTest();
		}

}

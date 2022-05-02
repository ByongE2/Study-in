// Equals()-주소비교 Equals()오버라이딩해서 iv비교. 
public class Ex9_1 {

	public static void main(String[] args) {
		Value v1 = new Value(40);
		Value v2 = new Value(49);


		System.out.println(v1.equals(v2));
	}
}


class Value {
	int value ;
	@Override
	public boolean equals(Object obj) {
		//		Value v = (Value)obj;
		if(!(obj instanceof Value)) 
			return false;
		return this.value == ((Value)obj).value; 
	}
	Value(){}
	Value(int value){
		this.value = value;
	}

}

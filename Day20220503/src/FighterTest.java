public class FighterTest {

	public static void main(String[] args) {

		Fighter f = new Fighter();
		
		if( f instanceof Unit)
			System.out.println("f는 Unit클래스의 자손입니다");
		if( f instanceof Fightable)
			System.out.println("f는 Fightable을 구현했습니다");
		if( f instanceof Movable )
			System.out.println("f는 Movable을 구현했습니다");
		if( f instanceof Attackable)
			System.out.println("f는 Attackable을 구현했습니다");
		if( f instanceof Object)
			System.out.println("f는 Object을 구현했습니다");
	}//main

}// end of FighterTest

class Fighter extends Unit implements Fightable{

	@Override
	public void move(int x, int y) {}
	@Override
	public void attack(Unit u) {}
}

class Unit {
	int currentHP; // 유닛 체력
	int x,y ; // 좌표
	
}
interface Fightable extends Movable, Attackable {}
interface Movable { void move(int x, int y); }
interface Attackable { void attack(Unit u); }	
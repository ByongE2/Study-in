package LGSamsung;

//디자인패턴>팩토리 메서드: 객체 생성 처리를 서브 클래스로 분리해 처리하도록 캡슐화하는 패턴
public class BeanFactory {

	public Object getBean(String beanName) {
		if(beanName.equalsIgnoreCase("samsung")) {
			return new SamsungTV();
		}else if(beanName.equalsIgnoreCase("lg")) {
			return new LgTV();
		}else return null;
		
	}
}

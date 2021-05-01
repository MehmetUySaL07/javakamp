package odevkamp;

public class InstructorManager extends Student {

	public void add(Instructor instructor) {

		System.out.println(instructor.getName() + " isimli ��retmen eklenmi�tir."+"\n"
	                      +"E�itmenin kurslar� : "+ instructor.trainings +"\n"
				          +"E�itmenin kurs zaman�: " + instructor.lessonTimes);
	}
	
	public void addMultiple(Instructor[] instructors) {
		
		for(Instructor instructor:instructors) {
			add(instructor);
		}
		
	}
	
	public void Update(Instructor instructor) {
		System.out.println(instructor.getName() +" isimli ��retmen g�ncellenmi�tir.");
	}
	
	public void Delete(Instructor instructor) {
		System.out.println(instructor.getName() +" isimli ��retmen silinmi�tir.");
	}
	
	
}
package diPrj.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import diPrj.di.entity.Exam;
import diPrj.di.entity.NewlecExam;
import diPrj.di.ui.ExamConsole;
import diPrj.di.ui.GridExamConsole;
import diPrj.di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {
		
		/* 스프링에게 지시하는 방법으로 변경
		Exam exam = new NewlecExam();
		ExamConsole console = new InlineExamConsole(exam);
		ExamConsole console = new GridExamConsole();
		console.setExam(exam);
		*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("diPrj/di/setting.xml");
		Exam exam = context.getBean(Exam.class);
		//System.out.println(exam.toString());
		ExamConsole console = (ExamConsole) context.getBean("console"); //형변환 필요
		//ExamConsole console = context.getBean(ExamConsole.class); //인터페이스가 많으면 다른 방법 찾아야함
		
		console.print();
		
		List<Exam> exams = (List<Exam>) context.getBean("exams");//new ArrayList<>();
		//exams.add(new NewlecExam(1,1,1,1));
		
		for (Exam e: exams)
			System.out.println(e);
	}

}

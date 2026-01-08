import java.util.List;
import java.util.ArrayList;

public class Student{
  private int studentId;
  private List<Exam> exams = new ArrayList<>();
  
  public Student(int studentId) {
        this.studentId = studentId;
    }
  public int getStudentId() {
    return studentId;
}

  public void addExam(Exam exam) {
        exams.add(exam);
    }
    
    public List<Exam> getExams() {
        return exams;
    }
}